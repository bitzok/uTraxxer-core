package com.utraxxer.core.habits.domain.model;

import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public class Habit {
    private Long id;
    private String name;
    private String description;
    private Instant startDate;
    private UUID reminderId;
    private Instant reminderTime;
    private Intervale intervale;
    private Color color;
    private Icon icon;
    private Long userId;
    private Instant createdAt;
}
