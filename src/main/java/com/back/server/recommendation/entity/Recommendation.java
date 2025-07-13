package com.back.server.recommendation.entity;

import com.back.server.common.jpa.entity.BaseEntity;
import com.back.server.meta.domain.AgeGroup;
import com.back.server.meta.domain.Region;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recommendation")
public class Recommendation extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "region", nullable = false, length = 20)
    private Region region;

    @Enumerated(EnumType.STRING)
    @Column(name = "age_group", nullable = false, length = 20)
    private AgeGroup ageGroup;

    @Column(name = "average_monthly_spending", nullable = false)
    private Integer averageMonthlySpending;

    @OneToMany(mappedBy = "recommendation", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("estimatedMonthlySpending")
    private List<RecommendedCard> recommendedCards = new ArrayList<>();
}
