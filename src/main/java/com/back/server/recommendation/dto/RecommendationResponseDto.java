package com.back.server.recommendation;

public record RecommendationResponseDto(
        Long recommendationId,
        String region,
        String ageGroup,
        Integer averageMonthlySpending,
        List<RecommendedCard> recommendedCards
) {
}
