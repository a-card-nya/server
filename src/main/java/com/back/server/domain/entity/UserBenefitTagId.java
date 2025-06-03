package com.back.server.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UserBenefitTagId implements java.io.Serializable {
    private static final long serialVersionUID = 5752604518200157494L;
    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Size(max = 50)
    @NotNull
    @Column(name = "tag_code", nullable = false, length = 50)
    private String tagCode;

    public UserBenefitTagId() {
    }

    public UserBenefitTagId(Long userId, String tagCode) {
        this.userId = userId;
        this.tagCode = tagCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserBenefitTagId entity = (UserBenefitTagId) o;
        return Objects.equals(this.tagCode, entity.tagCode) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagCode, userId);
    }

}