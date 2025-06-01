package com.back.server.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_benefit_tags", schema = "acardnya_db")
public class UserBenefitTag {
    @EmbeddedId
    private UserBenefitTagId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private com.back.server.User user;

    @MapsId("tagCode")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tag_code", nullable = false)
    private com.back.server.BenefitTag tagCode;

}