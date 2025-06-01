package com.back.server.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "recommendations", schema = "acardnya_db")
public class Recommendation {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @NotNull
    @Column(name = "card_id", nullable = false)
    private Long cardId;

    @Column(name = "score")
    private Float score;

    @Column(name = "normal_spending")
    private Integer normalSpending;

    @Column(name = "card_spending")
    private Integer cardSpending;

    @Column(name = "created_at")
    private Instant createdAt;

}