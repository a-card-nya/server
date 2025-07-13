package com.back.server.meta.service;

import com.back.server.meta.domain.*;
import com.back.server.meta.dto.MetaOptionDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MetaService {

    public List<MetaOptionDto> getAgeGroups() {
        return Arrays.stream(AgeGroup.values())
                .map(ageGroup -> new MetaOptionDto(ageGroup.name(), ageGroup.getLabel()))
                .toList();
    }

    public List<MetaOptionDto> getCardBenefits() {
        return Arrays.stream(CardBenefit.values())
                .map(cardBenefit -> new MetaOptionDto(cardBenefit.name(), cardBenefit.getLabel()))
                .toList();
    }

    public List<MetaOptionDto> getCardCompanies() {
        return Arrays.stream(CardCompany.values())
                .map(cardCompany -> new MetaOptionDto(cardCompany.name(), cardCompany.getLabel()))
                .toList();
    }

    public List<MetaOptionDto> getCardForms() {
        return Arrays.stream(CardForm.values())
                .map(cardForm -> new MetaOptionDto(cardForm.name(), cardForm.getLabel()))
                .toList();
    }

    public List<MetaOptionDto> getCardPaymentMethods() {
        return Arrays.stream(CardPaymentMethod.values())
                .map(cardPaymentMethod -> new MetaOptionDto(cardPaymentMethod.name(), cardPaymentMethod.getLabel()))
                .toList();
    }

    public List<MetaOptionDto> getCardTypes() {
        return Arrays.stream(CardType.values())
                .map(cardType -> new MetaOptionDto(cardType.name(), cardType.getLabel()))
                .toList();
    }

    public List<MetaOptionDto> getRegions() {
        return Arrays.stream(Region.values())
                .map(r -> new MetaOptionDto(r.name(), r.getLabel()))
                .toList();
    }

    public List<MetaOptionDto> getSocialGroups() {
        return Arrays.stream(SocialGroup.values())
                .map(socialGroup -> new MetaOptionDto(socialGroup.name(), socialGroup.getLabel()))
                .toList();
    }

    public List<MetaOptionDto> getTransportTypes() {
        return Arrays.stream(TransportType.values())
                .map(transportType -> new MetaOptionDto(transportType.name(), transportType.getLabel()))
                .toList();
    }
}