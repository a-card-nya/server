package com.back.server.recommendation;

import com.back.server.recommendation.dto.RecommendationRequestDto;
import com.back.server.recommendation.dto.RecommendationResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/recommendations")
@RequiredArgsConstructor
public class ApiV1RecommendationController {
    private final RecommendationService recommendationService;

    @PostMapping("")
    public ResponseEntity<RecommendationResponseDto> createRecommendation(@RequestBody RecommendationRequestDto request) {
        RecommendationResponseDto recommendationResult = recommendationService.recommend(request);

        if (recommendationResult == null) {
            // 400 Bad Request 응답
            return ResponseEntity.badRequest().build();
        }

        // 200 OK 응답
        return ResponseEntity.ok(recommendationResult);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecommendationResponseDto> getRecommendationById(@PathVariable Long id) {
        RecommendationResponseDto recommendationResult = recommendationService.findById(id);

        if (recommendationResult == null) {
            // 404 Not Found 응답
            return ResponseEntity.notFound().build();
        }

        // 200 OK 응답
        return ResponseEntity.ok(recommendationResult);
    }
}
