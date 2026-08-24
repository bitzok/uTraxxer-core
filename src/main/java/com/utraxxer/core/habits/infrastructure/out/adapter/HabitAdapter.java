package com.utraxxer.core.habits.infrastructure.out.adapter;

import com.utraxxer.core.habits.domain.model.Color;
import com.utraxxer.core.habits.domain.model.Habit;
import com.utraxxer.core.habits.domain.model.Icon;
import com.utraxxer.core.habits.domain.model.Intervale;
import com.utraxxer.core.habits.domain.port.HabitRepositoryPort;
import com.utraxxer.core.habits.infrastructure.out.entity.HabitEntity;
import com.utraxxer.core.habits.infrastructure.out.repository.HabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HabitAdapter implements HabitRepositoryPort {
    private final HabitRepository habitRepository;

    @Override
    public List<Habit> findByUserId(Long userId) {
        List<HabitEntity> habitsEntities = habitRepository.findByUserId(userId);

        return habitsEntities.stream()
                .map(entity -> {
                    Intervale intervaleDomain = Intervale.restoreFromRepository(
                            entity.getIntervale().getId(),
                            entity.getIntervale().getName()
                    );
                    Color colorDomain = Color.restoreFromRepository(
                            entity.getColor().getId(),
                            entity.getColor().getName(),
                            entity.getColor().getHexCode()
                    );
                    Icon iconDomain = Icon.restoreFromRepository(
                            entity.getIcon().getId(),
                            entity.getIcon().getName(),
                            entity.getIcon().getSvgPath()
                    );
                    return Habit.restoreFromRepository(
                            entity.getId(),
                            entity.getName(),
                            entity.getDescription(),
                            entity.getStartDate(),
                            entity.getReminderId(),
                            entity.getReminderTime(),
                            intervaleDomain,
                            colorDomain,
                            iconDomain,
                            entity.getUserId(),
                            entity.getCreatedAt()
                    );
                })
                .toList();
    }
}
