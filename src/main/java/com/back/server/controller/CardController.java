package com.back.server.controller;

import com.back.server.dto.CardCompareResponseDto;
import com.back.server.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/compare")
    public ResponseEntity<Map<String, Object>> getCardCompareData() {
        List<CardCompareResponseDto> cards = cardService.getAllCardsForCompare();
        return ResponseEntity.ok(Map.of("cards", cards));
    }
}

