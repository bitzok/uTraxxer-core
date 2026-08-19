package com.utraxxer.core.habits.application.usecase;

import com.utraxxer.core.habits.domain.model.Color;
import com.utraxxer.core.habits.domain.port.ColorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetColorsUseCase {
    private final ColorRepositoryPort colorRepositoryPort;

    @Transactional(readOnly = true)
    public List<Color> execute() {
        return colorRepositoryPort.findAll();
    }

}
