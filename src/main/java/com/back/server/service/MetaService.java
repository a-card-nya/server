package com.back.server.service;

import com.back.server.dto.MetaResponseDto;
import com.back.server.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetaService {

    private final AgeGroupRepository ageGroupRepo;
    private final RegionRepository regionRepo;
    private final CardIssuerRepository issuerRepo;
    private final BenefitTagRepository tagRepo;
    private final CardFormatTypeRepository formatRepo;
    private final SocialTargetTypeRepository targetRepo;

    public MetaResponseDto getAllMeta() {
        return MetaResponseDto.builder()
                .ageGroups(ageGroupRepo.findAll())
                .regions(regionRepo.findAll())
                .cardIssuers(issuerRepo.findAll())
                .benefitTags(tagRepo.findAll())
                .cardFormatTypes(formatRepo.findAll())
                .socialTargetTypes(targetRepo.findAll())
                .build();
    }
}

