package com.utraxxer.core.habits.infrastructure.in.controller;

import com.utraxxer.core.habits.api.CustomizeApi;
import com.utraxxer.core.habits.application.usecase.GetColorUseCase;
import com.utraxxer.core.habits.application.usecase.GetIconUseCase;
import com.utraxxer.core.habits.application.usecase.GetIntervaleUseCase;
import com.utraxxer.core.habits.infrastructure.out.entity.IntervaleEntity;
import com.utraxxer.core.habits.model.ColorResponse;
import com.utraxxer.core.habits.model.IconResponse;
import com.utraxxer.core.habits.model.IntervaleResponse;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CustomizeController implements CustomizeApi {
    private final GetIconUseCase getIconUseCase;
    private final GetColorUseCase getColorUseCase;
    private final GetIntervaleUseCase getIntervaleUseCase;

    @Override
    @RateLimiter(name = "auth-limit")
    public ResponseEntity<List<ColorResponse>> getColors() {
        var colors = getColorUseCase.execute();
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

    @Override
    @RateLimiter(name = "auth-limit")
    public ResponseEntity<List<IconResponse>> getIcons() {
        var icons = getIconUseCase.execute();
        List<IconResponse> responseList = icons.stream()
                .map(iconDomain -> {
                    IconResponse iconResponse = new IconResponse();
                    iconResponse.setId(iconDomain.getId());
                    iconResponse.setName(iconDomain.getName());
                    iconResponse.setSvgPath(iconDomain.getSvgPath());
                    return iconResponse;
                })
                .toList();

        return ResponseEntity.ok(responseList);
    }

    @Override
    @RateLimiter(name = "auth-limit")
    public ResponseEntity<List<IntervaleResponse>> getIntervales() {
        var intervales = getIntervaleUseCase.execute();
        List<IntervaleResponse> responseList = intervales.stream()
                .map(intervaleDomain -> {
                    IntervaleResponse intervaleResponse = new IntervaleResponse();
                    intervaleResponse.setId(intervaleDomain.getId());
                    intervaleResponse.setName(intervaleDomain.getName());
                    return intervaleResponse;
                })
                .toList();

        return ResponseEntity.ok(responseList);
    }

}
