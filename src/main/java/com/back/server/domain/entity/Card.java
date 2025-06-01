package com.back.server.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cards", schema = "acardnya_db")
public class Card {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @Lob
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private String type;

    @Size(max = 50)
    @NotNull
    @Column(name = "issuer_code", nullable = false, length = 50)
    private String issuerCode;

    @Size(max = 50)
    @NotNull
    @Column(name = "region", nullable = false, length = 50)
    private String region;

    @Size(max = 255)
    @Column(name = "link")
    private String link;

    @Size(max = 50)
    @NotNull
    @Column(name = "card_format", nullable = false, length = 50)
    private String cardFormat;

    @Column(name = "is_local_giftcard")
    private Boolean isLocalGiftcard;

    @Lob
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")
    private String paymentType;

    @Lob
    @Enumerated(EnumType.STRING)
    @Column(name = "card_form")
    private String cardForm;

    @Column(name = "annual_fee")
    private Integer annualFee;

}