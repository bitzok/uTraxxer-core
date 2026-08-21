package com.utraxxer.core.habits.infrastructure.out.adapter;

import com.utraxxer.core.habits.domain.model.Intervale;
import com.utraxxer.core.habits.domain.port.IntervaleRepositoryPort;
import com.utraxxer.core.habits.infrastructure.out.entity.IntervaleEntity;
import com.utraxxer.core.habits.infrastructure.out.repository.IntervaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IntervaleAdapter implements IntervaleRepositoryPort {
    private final IntervaleRepository intervaleRepository;

    @Override
    public List<Intervale> findAll() {
        List<IntervaleEntity> intervaleEntities = intervaleRepository.findAll();
        return intervaleEntities.stream()
                .map(entity -> Intervale.restoreFromRepository(entity.getId(), entity.getName()))
                .toList();
    }
}
