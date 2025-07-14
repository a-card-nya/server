package com.back.server.domain.recommendation.controller;

import com.back.server.domain.meta.enums.AgeGroup;
import com.back.server.domain.meta.enums.Region;
import com.back.server.domain.recommendation.entity.Recommendation;
import com.back.server.domain.recommendation.entity.RecommendedCard;
import com.back.server.domain.recommendation.repository.RecommendationRepository;
import com.back.server.domain.recommendation.repository.RecommendedCardRepository;
import com.back.server.domain.recommendation.service.RecommendationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class ApiV1RecommendationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecommendationService recommendationService;

    @Autowired
    private RecommendationRepository recommendationRepository;
    @Autowired
    private RecommendedCardRepository recommendedCardRepository;

    @Test
    @DisplayName("추천 생성 성공 테스트")
    public void createRecommendationSuccess() throws Exception {
        String requestJson = """
                {
                    "ageGroup": "AGE_19_34",
                    "region": "SEOUL",
                    "useClimateLine": true,
                    "useBusanVoucher": null,
                    "mainTransport": ["SUBWAY", "BIKE"],
                    "averageRidesPerWeek": 12,
                    "preferredCardCompanies": ["SHINHAN", "SAMSUNG"],
                    "preferredCardTypes": ["CREDIT"],
                    "annualFeeLimit": 20000,
                    "preferredPaymentMethod": "POSTPAID",
                    "preferredCardForm": "MOBILE",
                    "preferredBenefits": ["TRANSPORT", "COFFEE"],
                    "socialGroup": "NONE"
                }
                """;

        mockMvc.perform(post("/api/v1/recommendations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    String content = result.getResponse().getContentAsString();
                    // TODO: 응답 내용 검증 로직 추가
                });
    }

    @Test
    @DisplayName("추천 조회 성공 테스트")
    public void getRecommendationSuccess() throws Exception {
        Long recommendationId = 1L;
        if (recommendationRepository.findById(recommendationId).isEmpty()) {
            Recommendation recommendation = new Recommendation(
                    Region.SEOUL,
                    AgeGroup.AGE_19_34,
                    100000,
                    null
            );
            recommendationRepository.save(recommendation);
            List<RecommendedCard> recommendedCards = List.of(
                    // TODO: 실제 추천 카드 데이터를 넣어야 함
                    new RecommendedCard(4.0, 62000, recommendation, null),
                    new RecommendedCard(3.0, 70000, recommendation, null)
            );
            recommendedCardRepository.saveAll(recommendedCards);
            recommendation.setRecommendedCards(recommendedCards);
            recommendationId = recommendation.getId();
        }

        mockMvc.perform(get("/api/v1/recommendations/{id}", recommendationId))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    String content = result.getResponse().getContentAsString();
                    // TODO: 응답 내용 검증 로직 추가
                });
    }

    @Test
    @DisplayName("추천 조회 실패 테스트 (존재하지 않는 ID)")
    public void getRecommendationNotFound() throws Exception {
        Long recommendationId = 999L;
        given(recommendationService.findById(recommendationId)).willReturn(null);

        mockMvc.perform(get("/api/v1/recommendations/{id}", recommendationId))
                .andExpect(status().isNotFound());
    }
}
