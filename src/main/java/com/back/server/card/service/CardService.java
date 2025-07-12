package com.back.server.card.service;

import com.back.server.card.dto.CardResponseDto;
import com.back.server.card.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    CardRepository cardRepository;

    public List<CardResponseDto> getAllCards() {
        return cardRepository.findAll().stream()
                .map(CardResponseDto::new)
                .toList();
    }
}
