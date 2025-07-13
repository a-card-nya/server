package com.back.server.card.entity;

import com.back.server.common.jpa.entity.BaseEntity;
import com.back.server.meta.domain.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "card")
public class Card extends BaseEntity {

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "company", nullable = false, length = 20)
    private CardCompany company;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, length = 20)
    private CardCategory category;

    @Enumerated(EnumType.STRING)
    @Column(name = "region", length = 20)
    private Region region;

    @ElementCollection(targetClass = AgeGroup.class)
    @CollectionTable(name = "card_age_groups", joinColumns = @JoinColumn(name = "card_id"))
    @Column(name = "age_group", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private List<AgeGroup> ageGroups;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 20)
    private CardType type;

    @Column(name = "annual_fee", nullable = false)
    private Integer annualFee;

    @Column(name = "is_regional_voucher_card", nullable = false)
    private Boolean isRegionalVoucherCard;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false, length = 20)
    private CardPaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "form", nullable = false, length = 20)
    private CardForm form;

    @ElementCollection(targetClass = CardBenefit.class)
    @CollectionTable(name = "card_benefits", joinColumns = @JoinColumn(name = "card_id"))
    @Column(name = "benefit", length = 20)
    @Enumerated(EnumType.STRING)
    private List<CardBenefit> benefits;

    private String link;
}
