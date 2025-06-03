package com.back.server.dto;

import com.back.server.domain.enums.CardFormType;
import com.back.server.domain.enums.CardPaymentType;
import lombok.Data;

import java.util.List;

@Data
public class UserRequestDto {
    private String ageGroup;
    private String region;
    private Boolean usesClimatecardLines;
    private Boolean usesBusanVoucher;
    private Integer ridesPerWeek;
    private Integer maxAnnualFee;
    private CardPaymentType paymentPreference;
    private CardFormType formPreference;
    private String specialTarget;

    private List<String> transportModes;
    private List<String> preferredIssuers;
    private List<String> preferredCardTypes;
    private List<String> preferredBenefitTags;
}
