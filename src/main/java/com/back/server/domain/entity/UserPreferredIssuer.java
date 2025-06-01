package com.back.server.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_preferred_issuers", schema = "acardnya_db")
public class UserPreferredIssuer {
    @EmbeddedId
    private UserPreferredIssuerId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private com.back.server.User user;

    @MapsId("issuerCode")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "issuer_code", nullable = false)
    private com.back.server.CardIssuer issuerCode;

}