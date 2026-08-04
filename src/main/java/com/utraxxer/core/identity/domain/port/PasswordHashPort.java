package com.utraxxer.core.identity.domain.port;

public interface PasswordHashPort {
    String encode(String rawPassword);
}
