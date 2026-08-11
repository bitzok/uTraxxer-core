package com.utraxxer.core.identity.infrastructure.in.controller;

import com.utraxxer.core.config.SecurityConfig;
import com.utraxxer.core.identity.application.usecase.LoginUseCase;
import com.utraxxer.core.identity.application.usecase.RegisterUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import org.springframework.security.test.context.support.WithMockUser;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
@Import(SecurityConfig.class)
public class AuthControllerTest {
    @MockitoBean
    private RegisterUseCase registerUseCase;
    @MockitoBean
    private LoginUseCase loginUseCase;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void shouldReturn200AndTokenWhenRequestIsValid() throws Exception{
        String body = """
                {
                    "name": "User",
                    "lastname": "Test",
                    "email": "test@test.com",
                    "username": "testuser",
                    "password": "Password123!"
                }
                """;
        when(registerUseCase.execute(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn("token");

        mockMvc.perform(post("/register")
                .with(csrf())
                .contentType("application/json")
                .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("token"));
    }

}
