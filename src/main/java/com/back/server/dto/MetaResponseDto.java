package com.back.server.dto;

import com.back.server.domain.entity.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MetaResponseDto {
    private List<AgeGroup> ageGroups;
    private List<Region> regions;
    private List<CardIssuer> cardIssuers;
    private List<BenefitTag> benefitTags;
    private List<CardFormatType> cardFormatTypes;
    private List<SocialTargetType> socialTargetTypes;
}

