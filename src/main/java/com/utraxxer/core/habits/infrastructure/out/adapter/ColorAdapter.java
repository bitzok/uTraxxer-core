package com.utraxxer.core.habits.infrastructure.out.adapter;

import com.utraxxer.core.habits.domain.model.Color;
import com.utraxxer.core.habits.domain.port.ColorRepositoryPort;
import com.utraxxer.core.habits.infrastructure.out.entity.ColorEntity;
import com.utraxxer.core.habits.infrastructure.out.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ColorAdapter implements ColorRepositoryPort {
    private final ColorRepository colorRepository;

    @Override
    public List<Color> findAll() {
        List<ColorEntity> colorEntities = colorRepository.findAll();
        return colorEntities.stream()
                .map(entity -> Color.restoreFromRepository(entity.getId(), entity.getName(), entity.getHexCode()))
                .toList();
    }
}
