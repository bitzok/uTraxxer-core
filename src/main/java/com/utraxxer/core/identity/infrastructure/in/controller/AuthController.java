package com.utraxxer.core.identity.infrastructure.in.controller;

import com.utraxxer.core.identity.api.AuthApi;
import com.utraxxer.core.identity.model.IdentityResponse;
import com.utraxxer.core.identity.model.RegisterRequest;
import com.utraxxer.core.identity.application.usecase.RegisterUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController implements AuthApi {
    private final RegisterUserUseCase registerUserUseCase;

    @Override
    public ResponseEntity<IdentityResponse> registerUser(RegisterRequest registerRequest){
        registerUserUseCase.execute(
                registerRequest.getName(),
                registerRequest.getLastname(),
                registerRequest.getEmail(),
                registerRequest.getUsername(),
                registerRequest.getPassword()
        );

        IdentityResponse response = new IdentityResponse();
        response.setToken("token-temporal-hasta-que-hagamos-jwt");

        return ResponseEntity.ok(response);
    }
}