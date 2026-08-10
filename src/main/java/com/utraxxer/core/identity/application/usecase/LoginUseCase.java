package com.utraxxer.core.identity.application.usecase;

import com.utraxxer.core.identity.domain.exception.InvalidCredentialsException;
import com.utraxxer.core.identity.domain.model.UserAuth;
import com.utraxxer.core.identity.domain.port.GenerateTokenPort;
import com.utraxxer.core.identity.domain.port.PasswordHashPort;
import com.utraxxer.core.identity.domain.port.UserAuthRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginUseCase {
    private final UserAuthRepositoryPort userAuthRepositoryPort;
    private final PasswordHashPort passwordHashPort;
    private final GenerateTokenPort generateTokenPort;

    @Transactional
    public String execute(String identifier, String password){
        UserAuth userFind = userAuthRepositoryPort.findByEmailOrUsername(identifier).orElseThrow(() -> new InvalidCredentialsException("Credenciales inválidas"));

        if (!"active".equals(userFind.getState())) {
            throw new InvalidCredentialsException("Credenciales inválidas");
        }

        if (!passwordHashPort.matches(password, userFind.getPassword())) {
            throw new InvalidCredentialsException("Credenciales inválidas");
        }
        return generateTokenPort.generateToken(userFind.getEmail());
    }
}
