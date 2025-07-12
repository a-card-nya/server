package com.back.server.card.controller;

import com.back.server.card.dto.CardResponseDto;
import com.back.server.card.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
@Tag(name = "ApiV1CardController", description = "카드 관련 API")
public class ApiV1CardController {
    CardService cardService;

    @GetMapping
    @Transactional(readOnly = true)
    @Operation(summary = "모든 카드 조회")
    public ResponseEntity<List<CardResponseDto>> getAllCards() {
        List<CardResponseDto> cards = cardService.getAllCards();
        return ResponseEntity.ok(cards);
    }
}
