package com.back.server.repository;

import com.back.server.domain.entity.UserPreferredCardFormatType;
import com.back.server.domain.entity.UserPreferredCardFormatTypeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPreferredCardFormatTypeRepository extends JpaRepository<UserPreferredCardFormatType, UserPreferredCardFormatTypeId> {
}