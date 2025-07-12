package com.back.server.meta.controller;

import com.back.server.common.domain.*;
import com.back.server.meta.dto.MetaOptionDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/meta")
@RequiredArgsConstructor
@Tag(name = "ApiV1MetaController", description = "메타데이터 관련 API")
public class ApiV1MetaController {

    @GetMapping("/age-groups")
    @Operation(summary = "연령대 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getAgeGroups() {
        List<MetaOptionDto> ageGroups = Arrays.stream(AgeGroup.values())
                .map(ageGroup -> new MetaOptionDto(ageGroup.name(), ageGroup.getLabel()))
                .toList();
        return ResponseEntity.ok(ageGroups);
    }

    @GetMapping("/card-benefits")
    @Operation(summary = "카드 혜택 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getCardBenefits() {
        List<MetaOptionDto> cardBenefits = Arrays.stream(CardBenefit.values())
                .map(cardBenefit -> new MetaOptionDto(cardBenefit.name(), cardBenefit.getLabel()))
                .toList();
        return ResponseEntity.ok(cardBenefits);
    }

/*
    @GetMapping("/card-categories")
    @Operation(summary = "카드 카테고리 목록 조회")
*/

    @GetMapping("/card-companies")
    @Operation(summary = "카드사 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getCardCompanies() {
        List<MetaOptionDto> cardCompanies = Arrays.stream(CardCompany.values())
                .map(cardCompany -> new MetaOptionDto(cardCompany.name(), cardCompany.getLabel()))
                .toList();
        return ResponseEntity.ok(cardCompanies);
    }

    @GetMapping("/card-forms")
    @Operation(summary = "카드 형태 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getCardForms() {
        List<MetaOptionDto> cardForms = Arrays.stream(CardForm.values())
                .map(cardForm -> new MetaOptionDto(cardForm.name(), cardForm.getLabel()))
                .toList();
        return ResponseEntity.ok(cardForms);
    }

    @GetMapping("/card-payment-methods")
    @Operation(summary = "카드 결제 방법 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getCardPaymentMethods() {
        List<MetaOptionDto> cardPaymentMethods = Arrays.stream(CardPaymentMethod.values())
                .map(cardPaymentMethod -> new MetaOptionDto(cardPaymentMethod.name(), cardPaymentMethod.getLabel()))
                .toList();
        return ResponseEntity.ok(cardPaymentMethods);
    }

    @GetMapping("/card-types")
    @Operation(summary = "카드 종류 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getCardTypes() {
        List<MetaOptionDto> cardTypes = Arrays.stream(CardType.values())
                .map(cardType -> new MetaOptionDto(cardType.name(), cardType.getLabel()))
                .toList();
        return ResponseEntity.ok(cardTypes);
    }

    @GetMapping("/regions")
    @Operation(summary = "지역 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getRegions() {
        List<MetaOptionDto> regions = Arrays.stream(Region.values())
                .map(r -> new MetaOptionDto(r.name(), r.getLabel()))
                .toList();
        return ResponseEntity.ok(regions);
    }

    @GetMapping("/social-groups")
    @Operation(summary = "사회적 그룹 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getSocialGroups() {
        List<MetaOptionDto> socialGroups = Arrays.stream(SocialGroup.values())
                .map(socialGroup -> new MetaOptionDto(socialGroup.name(), socialGroup.getLabel()))
                .toList();
        return ResponseEntity.ok(socialGroups);
    }

    @GetMapping("/transport-types")
    @Operation(summary = "교통수단 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getTransportTypes() {
        List<MetaOptionDto> transportTypes = Arrays.stream(TransportType.values())
                .map(transportType -> new MetaOptionDto(transportType.name(), transportType.getLabel()))
                .toList();
        return ResponseEntity.ok(transportTypes);
    }
}
