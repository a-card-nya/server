package com.back.server.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "region_transport_statistics", schema = "acardnya_db")
public class RegionTransportStatistic {
    @Id
    @Size(max = 50)
    @Column(name = "region", nullable = false, length = 50)
    private String region;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "region", nullable = false)
    private com.back.server.Region regions;

    @Column(name = "avg_fare_per_ride")
    private Integer avgFarePerRide;

    @Column(name = "avg_rides_per_week")
    private Integer avgRidesPerWeek;

    @Column(name = "avg_monthly_spending")
    private Integer avgMonthlySpending;

}