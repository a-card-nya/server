package com.back.server.meta.controller;

import com.back.server.common.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ApiV1MetaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("연령대 목록 조회 API 테스트")
    void getAgeGroups() throws Exception {
        mockMvc.perform(get("/api/v1/meta/age-groups"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(AgeGroup.values().length)))
                .andExpect(jsonPath("$[0].code", is(AgeGroup.values()[0].name())))
                .andExpect(jsonPath("$[0].label", is(AgeGroup.values()[0].getLabel())));
    }

    @Test
    @DisplayName("카드 혜택 목록 조회 API 테스트")
    void getCardBenefits() throws Exception {
        mockMvc.perform(get("/api/v1/meta/card-benefits"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(CardBenefit.values().length)))
                .andExpect(jsonPath("$[0].code", is(CardBenefit.values()[0].name())))
                .andExpect(jsonPath("$[0].label", is(CardBenefit.values()[0].getLabel())));
    }

    @Test
    @DisplayName("카드사 목록 조회 API 테스트")
    void getCardCompanies() throws Exception {
        mockMvc.perform(get("/api/v1/meta/card-companies"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(CardCompany.values().length)))
                .andExpect(jsonPath("$[0].code", is(CardCompany.values()[0].name())))
                .andExpect(jsonPath("$[0].label", is(CardCompany.values()[0].getLabel())));
    }

    @Test
    @DisplayName("카드 형태 목록 조회 API 테스트")
    void getCardForms() throws Exception {
        mockMvc.perform(get("/api/v1/meta/card-forms"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(CardForm.values().length)))
                .andExpect(jsonPath("$[0].code", is(CardForm.values()[0].name())))
                .andExpect(jsonPath("$[0].label", is(CardForm.values()[0].getLabel())));
    }

    @Test
    @DisplayName("카드 결제 방법 목록 조회 API 테스트")
    void getCardPaymentMethods() throws Exception {
        mockMvc.perform(get("/api/v1/meta/card-payment-methods"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(CardPaymentMethod.values().length)))
                .andExpect(jsonPath("$[0].code", is(CardPaymentMethod.values()[0].name())))
                .andExpect(jsonPath("$[0].label", is(CardPaymentMethod.values()[0].getLabel())));
    }

    @Test
    @DisplayName("카드 종류 목록 조회 API 테스트")
    void getCardTypes() throws Exception {
        mockMvc.perform(get("/api/v1/meta/card-types"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(CardType.values().length)))
                .andExpect(jsonPath("$[0].code", is(CardType.values()[0].name())))
                .andExpect(jsonPath("$[0].label", is(CardType.values()[0].getLabel())));
    }

    @Test
    @DisplayName("지역 목록 조회 API 테스트")
    void getRegions() throws Exception {
        mockMvc.perform(get("/api/v1/meta/regions"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(Region.values().length)))
                .andExpect(jsonPath("$[0].code", is(Region.values()[0].name())))
                .andExpect(jsonPath("$[0].label", is(Region.values()[0].getLabel())));
    }

    @Test
    @DisplayName("사회적 그룹 목록 조회 API 테스트")
    void getSocialGroups() throws Exception {
        mockMvc.perform(get("/api/v1/meta/social-groups"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(SocialGroup.values().length)))
                .andExpect(jsonPath("$[0].code", is(SocialGroup.values()[0].name())))
                .andExpect(jsonPath("$[0].label", is(SocialGroup.values()[0].getLabel())));
    }

    @Test
    @DisplayName("교통수단 목록 조회 API 테스트")
    void getTransportTypes() throws Exception {
        mockMvc.perform(get("/api/v1/meta/transport-types"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(TransportType.values().length)))
                .andExpect(jsonPath("$[0].code", is(TransportType.values()[0].name())))
                .andExpect(jsonPath("$[0].label", is(TransportType.values()[0].getLabel())));
    }
}
