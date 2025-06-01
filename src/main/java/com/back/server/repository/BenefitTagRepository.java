package com.back.server.repository;

import com.back.server.domain.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitTagRepository extends JpaRepository<BenefitTag, String> {}