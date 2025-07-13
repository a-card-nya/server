package com.back.server.recommendation.dto;

import com.back.server.meta.domain.AgeGroup;
import com.back.server.meta.domain.Region;
import com.back.server.recommendation.entity.Recommendation;
import com.back.server.recommendation.entity.RecommendedCard;

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
