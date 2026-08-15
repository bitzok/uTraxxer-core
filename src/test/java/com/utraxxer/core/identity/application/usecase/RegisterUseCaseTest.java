package com.utraxxer.core.identity.application.usecase;

import com.utraxxer.core.identity.domain.port.GenerateTokenPort;
import com.utraxxer.core.identity.domain.port.PasswordHashPort;
import com.utraxxer.core.identity.domain.port.UserAuthRepositoryPort;
import com.utraxxer.core.identity.domain.port.UserProfileRepositoryPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegisterUseCaseTest {
    @Mock
    private UserAuthRepositoryPort userAuthRepositoryPort;
    @Mock
    private UserProfileRepositoryPort userProfileRepositoryPort;
    @Mock
    private PasswordHashPort passwordHashPort;
    @Mock
    private GenerateTokenPort generateTokenPort;
    @InjectMocks
    private RegisterUseCase registerUseCase;

    @Test
    public void shouldReturnTokenWhenCredentialsAreValid(){
        String username = "testuser";
        String email = "test@test.com";
        String password = "Password123!";
        String name = "User";
        String lastname = "Test";

        when(userAuthRepositoryPort.existsByEmail(email)).thenReturn(false);
        when(userAuthRepositoryPort.existsByUsername(username)).thenReturn(false);
        when(passwordHashPort.encode(password)).thenReturn("hashedPassword");
        when(generateTokenPort.generateToken(email)).thenReturn("token");

        String tokenResultado = registerUseCase.execute(name, lastname, email, username, password);
        Assertions.assertEquals("token", tokenResultado);

        org.mockito.Mockito.verify(userAuthRepositoryPort).save(any());
        org.mockito.Mockito.verify(userProfileRepositoryPort).save(any());
    }

    @Test
    public void shouldThrowExceptionWhenUsernameAlreadyExists(){
        String username = "testuser";
        String email = "test@test.com";
        String password = "Password123!";
        String name = "User";
        String lastname = "Test";

        when(userAuthRepositoryPort.existsByEmail(email)).thenReturn(false);
        when(userAuthRepositoryPort.existsByUsername(username)).thenReturn(true);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            registerUseCase.execute(name, lastname, email, username, password);
        });
        org.mockito.Mockito.verify(userAuthRepositoryPort, org.mockito.Mockito.never()).save(any());
    }

    @Test
    public void shouldThrowExceptionWhenEmailAlreadyExists() {
        String username = "testuser";
        String email = "test@test.com";
        String password = "Password123!";
        String name = "User";
        String lastname = "Test";

        when(userAuthRepositoryPort.existsByEmail(email)).thenReturn(true);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            registerUseCase.execute(name, lastname, email, username, password);
        });
        org.mockito.Mockito.verify(userAuthRepositoryPort, org.mockito.Mockito.never()).save(any());
    }
}
