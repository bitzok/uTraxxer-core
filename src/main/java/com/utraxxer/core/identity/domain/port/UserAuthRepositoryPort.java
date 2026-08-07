package com.utraxxer.core.identity.domain.port;

import com.utraxxer.core.identity.domain.model.UserAuth;

import java.util.Optional;

public interface UserAuthRepositoryPort {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    void save(UserAuth user);
    Optional<UserAuth> findByEmailOrUsername(String identifier);
}
