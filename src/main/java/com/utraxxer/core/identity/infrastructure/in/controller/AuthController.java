package com.utraxxer.core.identity.infrastructure.in.controller;

import com.utraxxer.core.identity.api.AuthApi;
import com.utraxxer.core.identity.model.IdentityResponse;
import com.utraxxer.core.identity.model.LoginRequest;
import com.utraxxer.core.identity.model.RegisterRequest;
import com.utraxxer.core.identity.application.usecase.RegisterUserUseCase;
import com.utraxxer.core.identity.application.usecase.LoginUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController implements AuthApi {
    private final RegisterUserUseCase registerUserUseCase;
    private final LoginUseCase loginUseCase;

    @Override
    public ResponseEntity<IdentityResponse> registerUser(@Valid RegisterRequest registerRequest){
        String token = registerUserUseCase.execute(
                registerRequest.getName(),
                registerRequest.getLastname(),
                registerRequest.getEmail(),
                registerRequest.getUsername(),
                registerRequest.getPassword()
        );
        IdentityResponse response = new IdentityResponse();
        response.setToken(token);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<IdentityResponse> loginUser(@Valid LoginRequest loginRequest) {
        String token = loginUseCase.execute(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );
        IdentityResponse response = new IdentityResponse();
        response.setToken(token);

        return ResponseEntity.ok(response);
    }
}