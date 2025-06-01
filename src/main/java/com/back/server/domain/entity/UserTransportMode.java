package com.back.server.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_transport_modes", schema = "acardnya_db")
public class UserTransportMode {
    @EmbeddedId
    private UserTransportModeId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private com.back.server.User user;

}