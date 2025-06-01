package com.back.server.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CardCompareResponseDto {
    private Long cardId;
    private String name;
    private String type;
    private String issuerCode;
    private String region;
    private Integer annualFee;
    private String paymentType;
    private String cardForm;
    private String cardFormat;
    private List<String> benefitTags;
}
