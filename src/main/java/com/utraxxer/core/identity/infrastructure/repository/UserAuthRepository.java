package com.utraxxer.core.identity.infrastructure.repository;

import com.utraxxer.core.identity.infrastructure.entity.UserAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<UserAuthEntity, Long> {
    boolean existsByEmail (String email);
    boolean existsByUsername (String username);
    Optional<UserAuthEntity> findByEmail(String email);
}
