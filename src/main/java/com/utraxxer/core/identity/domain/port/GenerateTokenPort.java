package com.utraxxer.core.identity.domain.port;

public interface GenerateTokenPort {
    String generateToken(String email);
}
