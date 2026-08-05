package com.utraxxer.core.identity.infrastructure.out.repository;

import com.utraxxer.core.identity.infrastructure.out.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
}
