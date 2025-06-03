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
    private User user;

    @MapsId("tagCode")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tag_code", nullable = false)
    private BenefitTag tagCode;

    public UserBenefitTag() {
    }

    public UserBenefitTag(User user, String tagCode) {
        this.user = user;
        this.id = new UserBenefitTagId(user.getId(), tagCode);
    }
}