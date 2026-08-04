package com.utraxxer.core.identity.infrastructure.adapter;

import com.utraxxer.core.identity.domain.port.PasswordHashPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordHashAdapter implements PasswordHashPort {
    private final PasswordEncoder passwordEncoder;

    @Override
    public String encode(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
}