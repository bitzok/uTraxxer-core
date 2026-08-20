package com.utraxxer.core.habits.infrastructure.out.adapter;

import com.utraxxer.core.habits.domain.model.Icon;
import com.utraxxer.core.habits.domain.port.IconRepositoryPort;
import com.utraxxer.core.habits.infrastructure.out.entity.IconEntity;
import com.utraxxer.core.habits.infrastructure.out.repository.IconRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IconAdapter implements IconRepositoryPort {
    private final IconRepository iconRepository;

    @Override
    public List<Icon> findAll() {
        List<IconEntity> iconEntities = iconRepository.findAll();
        return iconEntities.stream()
                .map(entity -> Icon.restoreFromRepository(entity.getId(), entity.getName(), entity.getSvgPath()))
                .toList();
    }
}
