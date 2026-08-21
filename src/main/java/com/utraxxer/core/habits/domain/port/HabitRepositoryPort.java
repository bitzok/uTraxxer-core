package com.utraxxer.core.habits.domain.port;

import com.utraxxer.core.habits.domain.model.Habit;

import java.util.List;

public interface HabitRepositoryPort {
    List<Habit> findByUserId(Long userId);
}
