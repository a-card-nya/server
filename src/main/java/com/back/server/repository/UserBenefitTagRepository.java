package com.back.server.repository;

import com.back.server.domain.entity.UserBenefitTag;
import com.back.server.domain.entity.UserBenefitTagId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBenefitTagRepository extends JpaRepository<UserBenefitTag, UserBenefitTagId> {
}
