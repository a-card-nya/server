package com.back.server.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "acardnya_db")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "age_group", nullable = false, length = 50)
    private String ageGroup;

    @Size(max = 50)
    @NotNull
    @Column(name = "region", nullable = false, length = 50)
    private String region;

    @Column(name = "uses_climatecard_lines")
    private Boolean usesClimatecardLines;

    @Column(name = "uses_busan_voucher")
    private Boolean usesBusanVoucher;

    @Column(name = "rides_per_week")
    private Integer ridesPerWeek;

    @Column(name = "max_annual_fee")
    private Integer maxAnnualFee;

    @Lob
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_preference")
    private String paymentPreference;

    @Lob
    @Enumerated(EnumType.STRING)
    @Column(name = "form_preference")
    private String formPreference;

    @Size(max = 50)
    @NotNull
    @Column(name = "special_target", nullable = false, length = 50)
    private String specialTarget;

}