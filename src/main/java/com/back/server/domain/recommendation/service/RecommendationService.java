package com.back.server.domain.recommendation.service;

import com.back.server.domain.card.entity.Card;
import com.back.server.domain.card.repository.CardRepository;
import com.back.server.domain.meta.enums.CardCategory;
import com.back.server.domain.meta.enums.CardType;
import com.back.server.domain.meta.enums.Region;
import com.back.server.domain.recommendation.dto.RecommendationRequestDto;
import com.back.server.domain.recommendation.dto.RecommendationResponseDto;
import com.back.server.domain.recommendation.entity.Recommendation;
import com.back.server.domain.recommendation.entity.RecommendedCard;
import com.back.server.domain.recommendation.repository.RecommendationRepository;
import com.back.server.domain.recommendation.repository.RecommendedCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final RecommendationRepository recommendationRepository;
    private final RecommendedCardRepository recommendedCardRepository;
    private final CardRepository cardRepository;

    public RecommendationResponseDto findById(Long id) {
        Optional<Recommendation> recommendation = recommendationRepository.findById(id);
        if (recommendation.isPresent()) {
            return new RecommendationResponseDto(recommendation.get());
        } else {
            throw new RuntimeException("Recommendation not found with id: " + id);
        }
    }

    public RecommendationResponseDto recommend(RecommendationRequestDto request) {
        int singleRideFare = getSingleRideFare(request.region());
        int averageMonthlySpending = request.averageRidesPerWeek() * 4 * singleRideFare;
        Recommendation recommendation = new Recommendation(
                request.region(),
                request.ageGroup(),
                averageMonthlySpending,
                null
        );
        recommendationRepository.save(recommendation);

        List<RecommendedCard> recommendedCards = getRecommendedCards(request, recommendation);
        recommendedCardRepository.saveAll(recommendedCards);

        recommendation.setRecommendedCards(recommendedCards);
        return new RecommendationResponseDto(recommendation);
    }

    // TODO: 공공데이터 API를 통해 지역별 평균 교통비를 가져오는 로직 추가
    private int getSingleRideFare(Region region) {

        return 0;
    }

    // TODO: 추천 카드 검색 로직 개선 및 테스트 케이스 추가
    private List<RecommendedCard> getRecommendedCards(RecommendationRequestDto request, Recommendation recommendation) {

        // 조건에 맞는 카드 검색
        List<Card> filteredCards = cardRepository.findCardsForRecommendation(
                request.ageGroup(),
                request.region(),
                request.useClimateLine(),
                request.useBusanVoucher()
        );

        // 가점 계산
        List<RecommendedCard> scoredCards = filteredCards.stream()
                .map(card -> {
                    return new RecommendedCard(
                            calculateScore(card, request),
                            0,
                            recommendation,
                            card);
                })
                .sorted(Comparator.comparingDouble(RecommendedCard::getScore).reversed())
                .toList();

        // 높은 점수의 카드만 필터링
        double maxScore = scoredCards.isEmpty() ? 0.0 : scoredCards.get(0).getScore();
        List<RecommendedCard> recommendedCards = scoredCards.stream()
                .filter(rc -> rc.getScore() == maxScore)
                .toList();
        if (recommendedCards.size() < 3) {
            recommendedCards = scoredCards.stream().limit(3).toList();
        }

        // 예상 교통비 계산
        recommendedCards.forEach(rc -> rc.setEstimatedMonthlySpending(
                calculateEstimatedMonthlySpending(rc.getCard(), request, recommendation.getAverageMonthlySpending())
        ));

        return recommendedCards;
    }

    // TODO: 예상 교통비 계산 로직 추가
    private Integer calculateEstimatedMonthlySpending(Card card, RecommendationRequestDto request, Integer averageMonthlySpending) {

        if (card.getCategory() == CardCategory.KPASS) {
            // 지역, 연령대, 사회 그룹에 따라 할인 적용
        } else if (card.getCategory() == CardCategory.CLIMATE) {
            // 청년 할인 적용 대상인지 확인
        }
        return 0;
    }

    private double calculateScore(Card card, RecommendationRequestDto request) {
        double score = 0.0;

        // 선호 카드사
        if (request.preferredCardCompanies() != null && !request.preferredCardCompanies().isEmpty()) {
            if (request.preferredCardCompanies().contains(card.getCompany())) {
                score += 1.0;
            }
        }

        // 선호 카드 유형
        boolean hasPreferredCardType = false;
        if (request.preferredCardTypes() != null && !request.preferredCardTypes().isEmpty()) {
            if (request.preferredCardTypes().contains(card.getType())) {
                score += 1.0;
                hasPreferredCardType = true;
            }
        }

        // 신용카드 연회비 조건
        if (hasPreferredCardType && request.preferredCardTypes().contains(CardType.CREDIT)) {
            if (card.getAnnualFee() > request.annualFeeLimit()) {
                score -= 0.5;
            }
        }

        // 후불/선불
        if (request.preferredCardPaymentMethod() != null
                && request.preferredCardPaymentMethod() == card.getPaymentMethod()) {
            score += 1.0;
        }

        // 모바일/실물
        if (request.preferredCardForm() != null && request.preferredCardForm() == card.getForm()) {
            score += 1.0;
        }

        // 선호 혜택 점수
        if (request.preferredCardBenefits() != null && !request.preferredCardBenefits().isEmpty()) {
            long matchedBenefits = request.preferredCardBenefits().stream()
                    .filter(benefit -> card.getBenefits() != null && card.getBenefits().contains(benefit))
                    .count();

            double benefitScore = (double) matchedBenefits / request.preferredCardBenefits().size();
            score += benefitScore;
        }

        return score;
    }
}
