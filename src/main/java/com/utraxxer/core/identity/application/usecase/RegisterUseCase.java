package com.utraxxer.core.identity.application.usecase;

import com.utraxxer.core.identity.domain.model.UserAuth;
import com.utraxxer.core.identity.domain.model.UserProfile;
import com.utraxxer.core.identity.domain.port.GenerateTokenPort;
import com.utraxxer.core.identity.domain.port.PasswordHashPort;
import com.utraxxer.core.identity.domain.port.UserAuthRepositoryPort;
import com.utraxxer.core.identity.domain.port.UserProfileRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterUseCase {
    private final UserAuthRepositoryPort userAuthRepositoryPort;
    private final UserProfileRepositoryPort userProfileRepositoryPort;
    private final PasswordHashPort passwordHashPort;
    private final GenerateTokenPort generateTokenPort;

    @Transactional
    public String execute(String name, String lastname, String email, String username, String password) {
        if (userAuthRepositoryPort.existsByEmail(email)) {
            throw new IllegalArgumentException("El email ya está siendo usado por otro usuario");
        }
        if (userAuthRepositoryPort.existsByUsername(username)) {
            throw new IllegalArgumentException("El nombre de usuario ya está siendo usado por otro usuario");
        }
        String encodedPassword = passwordHashPort.encode(password);

        UserAuth userAuth = new UserAuth();
        userAuth.setEmail(email);
        userAuth.setPassword(encodedPassword);
        userAuth.setUsername(username);
        userAuth.setState("active");

        UserAuth savedUserAuth = userAuthRepositoryPort.save(userAuth);

        UserProfile userProfile = new UserProfile();
        userProfile.setName(name);
        userProfile.setLastname(lastname);
        userProfile.setUserAuth(savedUserAuth);

        userAuthRepositoryPort.save(userAuth);
        userProfileRepositoryPort.save(userProfile);

        return generateTokenPort.generateToken(email);
    }
}
