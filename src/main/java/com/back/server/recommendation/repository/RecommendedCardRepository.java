package com.back.server.recommendation.repository;

import com.back.server.recommendation.entity.RecommendedCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendedCardRepository extends JpaRepository<RecommendedCard, Long> {
}
