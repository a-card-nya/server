package com.back.server.domain.card.repository;

import com.back.server.domain.card.entity.Card;
import com.back.server.domain.meta.enums.AgeGroup;
import com.back.server.domain.meta.enums.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("""
        SELECT c
        FROM Card c
        WHERE 
            :ageGroup in elements(c.ageGroups)
        AND
            (c.region = :region OR c.region IS NULL)
        AND
            (
                (:region != 'SEOUL')
                OR
                (:region = 'SEOUL' AND :useClimateLine = TRUE)
                OR
                (:region = 'SEOUL' AND :useClimateLine = FALSE AND c.category != com.back.server.meta.domain.CardCategory.CLIMATE)
            )
        AND
            (
                (:region != 'BUSAN')
                OR
                (:region = 'BUSAN' AND :useRegionalVoucher = TRUE)
                OR
                (:region = 'BUSAN' AND :useRegionalVoucher = FALSE AND c.isRegionalVoucherCard != FALSE)
            )
    """)
    List<Card> findCardsForRecommendation(
            @Param("ageGroup") AgeGroup ageGroup,
            @Param("region") Region region,
            @Param("useClimateLine") boolean useClimateLine,
            @Param("useRegionalVoucher") boolean useRegionalVoucher
    );
}
