package com.utraxxer.core.identity.controller;

import com.utraxxer.core.identity.api.AuthApi;
import com.utraxxer.core.identity.model.IdentityResponse;
import com.utraxxer.core.identity.model.RegisterRequest;
import io.swagger.models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {
    @Override
    public ResponseEntity<IdentityResponse> registerUser(RegisterRequest registerRequest){
        System.out.println("¡Alguien se quiere registrar!");
        System.out.println("Nombre: " + registerRequest.getName());
        System.out.println("Correo: " + registerRequest.getEmail());

        String tokenFalso = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.simulacion";

        IdentityResponse response = new IdentityResponse();
        response.setToken(tokenFalso);

        return ResponseEntity.ok(response);
    }
}
