package com.back.server.repository;

import com.back.server.domain.entity.UserPreferredIssuer;
import com.back.server.domain.entity.UserPreferredIssuerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPreferredIssuerRepository extends JpaRepository<UserPreferredIssuer, UserPreferredIssuerId> {
}
