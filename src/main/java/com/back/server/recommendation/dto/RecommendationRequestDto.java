package com.back.server.recommendation.dto;

import com.back.server.meta.domain.*;

import java.util.List;

public record RecommendationRequestDto(
        AgeGroup ageGroup,
        Region region,
        Boolean useClimateLine,
        Boolean useBusanVoucher,
        List<TransportType> mainTransport,
        Integer averageRidesPerWeek,
        List<CardCompany> preferredCardCompanies,
        List<CardType> preferredCardTypes,
        Integer annualFeeLimit,
        CardPaymentMethod preferredCardPaymentMethod,
        CardForm preferredCardForm,
        List<CardBenefit> preferredCardBenefits,
        SocialGroup socialGroup
) {}
