package com.back.server.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "card_benefit_tags", schema = "acardnya_db")
public class CardBenefitTag {
    @EmbeddedId
    private CardBenefitTagId id;

    @MapsId("cardId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @MapsId("tagCode")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tag_code", nullable = false)
    private BenefitTag tagCode;

}