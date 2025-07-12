package com.back.server.recommendation.controller;

import com.back.server.recommendation.service.RecommendationService;
import com.back.server.recommendation.dto.RecommendationRequestDto;
import com.back.server.recommendation.dto.RecommendationResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/recommendations")
@RequiredArgsConstructor
@Tag(name = "ApiV1RecommendationController", description = "추천 관련 API")
public class ApiV1RecommendationController {
    private final RecommendationService recommendationService;

    @PostMapping
    @Operation(summary = "추천 생성")
    public ResponseEntity<RecommendationResponseDto> createRecommendation(@RequestBody RecommendationRequestDto request) {
        RecommendationResponseDto recommendationResult = recommendationService.recommend(request);

        if (recommendationResult == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(recommendationResult);
    }

    @GetMapping("/{id}")
    @Operation(summary = "추천 조회")
    public ResponseEntity<RecommendationResponseDto> getRecommendation(@PathVariable Long id) {
        RecommendationResponseDto recommendationResult = recommendationService.findById(id);

        if (recommendationResult == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(recommendationResult);
    }
}
