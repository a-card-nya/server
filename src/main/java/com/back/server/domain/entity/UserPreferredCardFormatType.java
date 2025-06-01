package com.back.server.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_preferred_card_format_types", schema = "acardnya_db")
public class UserPreferredCardFormatType {
    @EmbeddedId
    private UserPreferredCardFormatTypeId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private com.back.server.User user;

    @MapsId("cardFormat")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "card_format", nullable = false)
    private com.back.server.CardFormatType cardFormat;

}