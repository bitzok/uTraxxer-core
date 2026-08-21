package com.utraxxer.core.habits.application.usecase;

import com.utraxxer.core.habits.domain.model.Habit;
import com.utraxxer.core.habits.domain.port.HabitRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetHabitByUserIdUseCase {
    private final HabitRepositoryPort habitRepositoryPort;

    @Transactional(readOnly = true)
    public List<Habit> execute(Long userId) {
        return habitRepositoryPort.findByUserId(userId);
    }

}
