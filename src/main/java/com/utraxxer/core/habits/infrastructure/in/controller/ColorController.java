package com.utraxxer.core.habits.infrastructure.in.controller;

import com.utraxxer.core.habits.api.CustomizeApi;
import com.utraxxer.core.habits.application.usecase.GetColorsUseCase;
import com.utraxxer.core.habits.domain.model.Color;
import com.utraxxer.core.habits.model.ColorResponse;
import com.utraxxer.core.identity.model.IdentityResponse;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ColorController implements CustomizeApi {
    private final GetColorsUseCase getColorsUseCase;

    @Override
    @RateLimiter(name = "auth-limit")
    public ResponseEntity<List<ColorResponse>> getColors() {
        var colors = getColorsUseCase.execute();
        List<ColorResponse> responseList = colors.stream()
                .map(colorDomain -> {
                    ColorResponse colorResponse = new ColorResponse();
                    colorResponse.setId(colorDomain.getId());
                    colorResponse.setName(colorDomain.getName());
                    colorResponse.setHexCode(colorDomain.getHexCode());
                    return colorResponse;
                })
                .toList();

        return ResponseEntity.ok(responseList);
    }
}
