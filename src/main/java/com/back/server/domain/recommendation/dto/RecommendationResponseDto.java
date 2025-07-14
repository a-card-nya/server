package com.back.server.domain.recommendation.dto;

import com.back.server.domain.meta.enums.AgeGroup;
import com.back.server.domain.meta.enums.Region;
import com.back.server.domain.recommendation.entity.Recommendation;
import com.back.server.domain.recommendation.entity.RecommendedCard;

import java.util.List;

public record RecommendationResponseDto(
        Long recommendationId,
        Region region,
        AgeGroup ageGroup,
        Integer averageMonthlySpending,
        List<RecommendedCard> recommendedCards
) {
    public RecommendationResponseDto(Recommendation recommendation) {
        this(
                recommendation.getId(),
                recommendation.getRegion(),
                recommendation.getAgeGroup(),
                recommendation.getAverageMonthlySpending(),
                recommendation.getRecommendedCards()
        );
    }
}
