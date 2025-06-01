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
public class UserPreferredCardFormatTypeId implements java.io.Serializable {
    private static final long serialVersionUID = -8296485725838570281L;
    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Size(max = 50)
    @NotNull
    @Column(name = "card_format", nullable = false, length = 50)
    private String cardFormat;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserPreferredCardFormatTypeId entity = (UserPreferredCardFormatTypeId) o;
        return Objects.equals(this.cardFormat, entity.cardFormat) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardFormat, userId);
    }

}