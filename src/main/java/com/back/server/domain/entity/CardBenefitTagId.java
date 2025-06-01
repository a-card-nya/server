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
public class CardBenefitTagId implements java.io.Serializable {
    private static final long serialVersionUID = -6868123154828510455L;
    @NotNull
    @Column(name = "card_id", nullable = false)
    private Long cardId;

    @Size(max = 50)
    @NotNull
    @Column(name = "tag_code", nullable = false, length = 50)
    private String tagCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CardBenefitTagId entity = (CardBenefitTagId) o;
        return Objects.equals(this.tagCode, entity.tagCode) &&
                Objects.equals(this.cardId, entity.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagCode, cardId);
    }

}