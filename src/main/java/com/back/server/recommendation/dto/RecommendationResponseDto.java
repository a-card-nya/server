package com.back.server.recommendation.dto;

import com.back.server.card.dto.CardResponseDto;
import com.back.server.common.domain.AgeGroup;
import com.back.server.common.domain.Region;

import java.util.List;

public record RecommendationResponseDto(
        Long recommendationId,
        Region region,
        AgeGroup ageGroup,
        Integer averageMonthlySpending,
        List<RecommendedCard> recommendedCards
) {
    record RecommendedCard(
            CardResponseDto card,
            Double score,
            Integer estimatedMonthlySpending
    ) {}
}
