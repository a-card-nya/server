package com.back.server.recommendation.entity;

import com.back.server.card.entity.Card;
import com.back.server.common.jpa.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recommended_card")
public class RecommendedCard extends BaseEntity {

    @Column(name = "score", nullable = false)
    private double score;

    @Column(name = "estimated_monthly_spending", nullable = false)
    private Integer estimatedMonthlySpending;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recommendation_id")
    private Recommendation recommendation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;
}
