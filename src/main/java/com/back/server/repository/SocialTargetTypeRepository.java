package com.back.server.repository;

import com.back.server.domain.entity.SocialTargetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialTargetTypeRepository extends JpaRepository<SocialTargetType, String> {}
