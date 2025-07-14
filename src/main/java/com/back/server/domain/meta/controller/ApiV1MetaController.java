package com.back.server.domain.meta.controller;

import com.back.server.domain.meta.dto.MetaOptionDto;
import com.back.server.domain.meta.service.MetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/meta")
@RequiredArgsConstructor
@Tag(name = "ApiV1MetaController", description = "메타데이터 관련 API")
public class ApiV1MetaController {

    private final MetaService metaService;

    @GetMapping("/age-groups")
    @Operation(summary = "연령대 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getAgeGroups() {
        return ResponseEntity.ok(metaService.getAgeGroups());
    }

    @GetMapping("/card-benefits")
    @Operation(summary = "카드 혜택 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getCardBenefits() {
        return ResponseEntity.ok(metaService.getCardBenefits());
    }

/*
    @GetMapping("/card-categories")
    @Operation(summary = "카드 카테고리 목록 조회")
*/

    @GetMapping("/card-companies")
    @Operation(summary = "카드사 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getCardCompanies() {
        return ResponseEntity.ok(metaService.getCardCompanies());
    }

    @GetMapping("/card-forms")
    @Operation(summary = "카드 형태 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getCardForms() {
        return ResponseEntity.ok(metaService.getCardForms());
    }

    @GetMapping("/card-payment-methods")
    @Operation(summary = "카드 결제 방법 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getCardPaymentMethods() {
        return ResponseEntity.ok(metaService.getCardPaymentMethods());
    }

    @GetMapping("/card-types")
    @Operation(summary = "카드 종류 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getCardTypes() {
        return ResponseEntity.ok(metaService.getCardTypes());
    }

    @GetMapping("/regions")
    @Operation(summary = "지역 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getRegions() {
        return ResponseEntity.ok(metaService.getRegions());
    }

    @GetMapping("/social-groups")
    @Operation(summary = "사회적 그룹 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getSocialGroups() {
        return ResponseEntity.ok(metaService.getSocialGroups());
    }

    @GetMapping("/transport-types")
    @Operation(summary = "교통수단 목록 조회")
    public ResponseEntity<List<MetaOptionDto>> getTransportTypes() {
        return ResponseEntity.ok(metaService.getTransportTypes());
    }
}
