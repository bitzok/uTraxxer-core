package com.utraxxer.core.identity.infrastructure.repository;

import com.utraxxer.core.identity.infrastructure.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
}
