package com.utraxxer.core.identity.repository;

import com.utraxxer.core.identity.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {
}
