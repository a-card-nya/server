package com.back.server.recommendation;

import java.util.List;

public record RecommendationRequestDto(
        String ageGroup,
        String region,
        Boolean useClimateLine,
        Boolean useBusanVoucher,
        List<String> mainTransport,
        Integer averageRidesPerWeek,
        List<String> preferredCardCompanies,
        List<String> preferredCardTypes,
        Integer annualFeeLimit,
        String preferredPaymentMethod,
        String preferredCardForm,
        List<String> preferredBenefits,
        String socialGroup
) {}
