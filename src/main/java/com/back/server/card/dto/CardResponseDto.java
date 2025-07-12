package com.back.server.card.dto;

import com.back.server.card.entity.Card;

import java.util.List;

public record CardResponseDto(
        Long id,
        String name,
        String company,
        String category,
        String region,
        String type,
        Integer annualFee,
        Boolean isRegionalVoucherCard,
        String paymentMethod,
        String form,
        List<String> benefits,
        String link
) {
    public CardResponseDto(Card card) {
        this(
                card.getId(),
                card.getName(),
                card.getCompany().name(),
                card.getCategory().name(),
                card.getRegion() != null ? card.getRegion().name() : null,
                card.getType().name(),
                card.getAnnualFee(),
                card.getIsRegionalVoucherCard(),
                card.getPaymentMethod().name(),
                card.getForm().name(),
                card.getBenefits() != null ? card.getBenefits().stream().map(Enum::name).toList() : List.of(),
                card.getLink()
        );
    }
}