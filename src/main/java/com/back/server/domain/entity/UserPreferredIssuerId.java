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
public class UserPreferredIssuerId implements java.io.Serializable {
    private static final long serialVersionUID = -441672785880569081L;
    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Size(max = 50)
    @NotNull
    @Column(name = "issuer_code", nullable = false, length = 50)
    private String issuerCode;

    public UserPreferredIssuerId() {

    }

    public UserPreferredIssuerId(Long userId, String issuerCode) {
        this.userId = userId;
        this.issuerCode = issuerCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserPreferredIssuerId entity = (UserPreferredIssuerId) o;
        return Objects.equals(this.issuerCode, entity.issuerCode) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuerCode, userId);
    }

}