package com.utraxxer.core.identity.domain.model;

import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
public class UserAuth {
    private Long id;
    private String email;
    private String username;
    private String password;
    private UserState state;
    private Instant createdAt;

    private UserAuth(Long id, String email, String username, String password, UserState state, Instant createdAt) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.state = state;
        this.createdAt = createdAt;
    }

    public static UserAuth createNew(String email, String username, String password) {
        return new UserAuth(null, email, username, password, UserState.ACTIVE, Instant.now());
    }

    public static UserAuth restoreFromRepository(Long id, String email, String username, String password, UserState state, Instant createdAt) {
        return new UserAuth(id, email, username, password, state, createdAt);
    }

    public boolean isActive() {
        return UserState.ACTIVE == this.state;
    }
}
