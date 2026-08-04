package com.utraxxer.core.identity.domain.port;

import com.utraxxer.core.identity.domain.model.UserAuth;

public interface UserAuthRepositoryPort {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    void save(UserAuth user);
}
