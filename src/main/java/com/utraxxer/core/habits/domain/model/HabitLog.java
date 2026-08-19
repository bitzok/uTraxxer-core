package com.utraxxer.core.habits.domain.model;

import lombok.Getter;

import java.time.Instant;

@Getter
public class HabitLog {
    private Long id;
    private Instant completedDate;
    private Habit habit;
}
