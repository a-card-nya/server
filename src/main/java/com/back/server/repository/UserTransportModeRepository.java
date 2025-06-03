package com.back.server.repository;

import com.back.server.domain.entity.UserTransportMode;
import com.back.server.domain.entity.UserTransportModeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTransportModeRepository extends JpaRepository<UserTransportMode, UserTransportModeId> {
    List<UserTransportMode> findByUserId(Long userId);
}
