package com.utraxxer.core.identity.infrastructure.out.repository;

import com.utraxxer.core.identity.infrastructure.out.entity.UserAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<UserAuthEntity, Long> {
    boolean existsByEmail (String email);
    boolean existsByUsername (String username);
    Optional<UserAuthEntity> findByEmailOrUsername(String email, String username);
    Optional<UserAuthEntity> findByEmail(String email);
}
