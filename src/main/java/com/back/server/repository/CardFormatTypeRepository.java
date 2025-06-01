package com.back.server.repository;

import com.back.server.domain.entity.CardFormatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardFormatTypeRepository extends JpaRepository<CardFormatType, String> {}
