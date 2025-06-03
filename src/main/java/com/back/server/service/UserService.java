package com.back.server.service;

import com.back.server.domain.entity.*;
import com.back.server.dto.UserRequestDto;
import com.back.server.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserTransportModeRepository userTransportModeRepository;
    private final UserPreferredIssuerRepository userPreferredIssuerRepository;
    private final UserPreferredCardFormatTypeRepository userPreferredCardFormatTypeRepository;
    private final UserBenefitTagRepository userBenefitTagRepository;

    public Long save(UserRequestDto dto) {
        User user = new User();
        user.setAgeGroup(dto.getAgeGroup());
        user.setRegion(dto.getRegion());
        user.setUsesClimatecardLines(dto.getUsesClimatecardLines());
        user.setUsesBusanVoucher(dto.getUsesBusanVoucher());
        user.setRidesPerWeek(dto.getRidesPerWeek());
        user.setMaxAnnualFee(dto.getMaxAnnualFee());
        user.setPaymentPreference(String.valueOf(dto.getPaymentPreference()));
        user.setFormPreference(String.valueOf(dto.getFormPreference()));
        user.setSpecialTarget(dto.getSpecialTarget());

        userRepository.save(user);

        dto.getTransportModes().forEach(mode ->
                userTransportModeRepository.save(new UserTransportMode(user, mode)));

        dto.getPreferredIssuers().forEach(issuer ->
                userPreferredIssuerRepository.save(new UserPreferredIssuer(user, issuer)));

        dto.getPreferredCardTypes().forEach(type ->
                userPreferredCardFormatTypeRepository.save(new UserPreferredCardFormatType(user, type)));

        dto.getPreferredBenefitTags().forEach(tag ->
                userBenefitTagRepository.save(new UserBenefitTag(user, tag)));

        return user.getId();
    }
}
