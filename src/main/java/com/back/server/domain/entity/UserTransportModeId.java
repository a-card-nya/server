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
public class UserTransportModeId implements java.io.Serializable {
    private static final long serialVersionUID = 7684266800153444155L;
    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Size(max = 50)
    @NotNull
    @Column(name = "mode", nullable = false, length = 50)
    private String mode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserTransportModeId entity = (UserTransportModeId) o;
        return Objects.equals(this.mode, entity.mode) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mode, userId);
    }

}