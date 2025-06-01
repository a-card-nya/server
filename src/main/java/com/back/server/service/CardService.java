package com.back.server.service;

import com.back.server.dto.CardCompareResponseDto;
import com.back.server.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public List<CardCompareResponseDto> getAllCardsForCompare() {
        return cardRepository.findAll().stream()
                .map(card -> CardCompareResponseDto.builder()
                        .cardId(card.getId())
                        .name(card.getName())
                        .type(card.getType())
                        .issuerCode(card.getIssuerCode())
                        .region(card.getRegion())
                        .annualFee(card.getAnnualFee())
                        .paymentType(card.getPaymentType() != null ? card.getPaymentType() : null)
                        .cardForm(card.getCardForm() != null ? card.getCardForm() : null)
                        .cardFormat(card.getCardFormat())
                        .benefitTags(
                                card.getCardBenefitTags().stream()
                                        .map(cbt -> cbt.getTagCode().getCode())
                                        .toList()
                        )
                        .build()
                )
                .toList();
    }
}
