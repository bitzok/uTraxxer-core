package com.utraxxer.core.habits.domain.model;

import lombok.Getter;

import java.time.Instant;

@Getter
public class Habit {
    private Long id;
    private String name;
    private String description;
    private Instant startDate;
    private Instant reminderTime;
    private Instant createdAt;
    private Intervale intervale;
    private Color color;
    private Icon icon;
    private Long userId;
}
