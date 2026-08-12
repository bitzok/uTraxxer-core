package com.utraxxer.core.identity.application.usecase;

import com.utraxxer.core.identity.domain.exception.InvalidCredentialsException;
import com.utraxxer.core.identity.domain.model.UserAuth;
import com.utraxxer.core.identity.domain.port.GenerateTokenPort;
import com.utraxxer.core.identity.domain.port.PasswordHashPort;
import com.utraxxer.core.identity.domain.port.UserAuthRepositoryPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LoginUseCaseTest {
    @Mock
    private UserAuthRepositoryPort userAuthRepositoryPort;
    @Mock
    private PasswordHashPort passwordHashPort;
    @Mock
    private GenerateTokenPort generateTokenPort;
    @InjectMocks
    private LoginUseCase loginUseCase;

    @Test
    public void shouldReturnTokenWhenUserIsAuthenticated() {
        String identifier = "testuser";
        String password = "Password123!";

        UserAuth userAuth = new UserAuth();
        userAuth.setUsername("testuser");
        userAuth.setEmail("test@test.com");
        userAuth.setState("active");
        userAuth.setPassword("hashedPassword");

        when(userAuthRepositoryPort.findByEmailOrUsername(identifier)).thenReturn(java.util.Optional.of(userAuth));
        when(passwordHashPort.matches(password, userAuth.getPassword())).thenReturn(true);
        when(generateTokenPort.generateToken(userAuth.getEmail())).thenReturn("token");

        String tokenResultado = loginUseCase.execute(identifier, password);
        Assertions.assertEquals("token", tokenResultado);

    }

    @Test
    public void shouldReturnErrorWhereUserNoExists(){
        String identifier = "testuser";
        String password = "Password123!";

        when(userAuthRepositoryPort.findByEmailOrUsername(identifier)).thenReturn(java.util.Optional.empty());

        Assertions.assertThrows(InvalidCredentialsException.class, () -> {
            loginUseCase.execute(identifier, password);
        });

    }

    @Test
    public void shouldReturnErrorWhereUserisInactive(){
        String identifier = "testuser";
        String password = "Password123!";

        UserAuth userAuth = new UserAuth();
        userAuth.setUsername("testuser");
        userAuth.setEmail("test@test.com");
        userAuth.setState("inactive");
        userAuth.setPassword("hashedPassword");

        when(userAuthRepositoryPort.findByEmailOrUsername(identifier)).thenReturn(java.util.Optional.of(userAuth));

        Assertions.assertThrows(InvalidCredentialsException.class, () -> {
            loginUseCase.execute(identifier, password);
        });

    }

    @Test
    public void shouldReturnErrorWherePasswordIsIncorrect(){
        String identifier = "testuser";
        String password = "Password123!";

        UserAuth userAuth = new UserAuth();
        userAuth.setUsername("testuser");
        userAuth.setEmail("test@test.com");
        userAuth.setState("active");
        userAuth.setPassword("hashedPassword");

        when(userAuthRepositoryPort.findByEmailOrUsername(identifier)).thenReturn(java.util.Optional.of(userAuth));
        when(passwordHashPort.matches(password, userAuth.getPassword())).thenReturn(false);

        Assertions.assertThrows(InvalidCredentialsException.class, () -> {
            loginUseCase.execute(identifier, password);
        });

    }
}