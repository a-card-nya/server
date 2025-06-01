package com.back.server.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "card_benefit_rates", schema = "acardnya_db")
public class CardBenefitRate {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "region", nullable = false, length = 50)
    private String region;

    @Size(max = 50)
    @NotNull
    @Column(name = "target", nullable = false, length = 50)
    private String target;

    @Size(max = 50)
    @NotNull
    @Column(name = "age_group", nullable = false, length = 50)
    private String ageGroup;

    @Column(name = "rate")
    private Float rate;

}