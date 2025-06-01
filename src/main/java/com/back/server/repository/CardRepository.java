package com.back.server.repository;

import com.back.server.domain.entity.Card;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    @EntityGraph(attributePaths = {"benefitTags"})
    List<Card> findAll(); // benefitTags를 함께 로딩
}

