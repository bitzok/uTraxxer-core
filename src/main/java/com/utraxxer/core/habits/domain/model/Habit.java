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

    private Habit(Long id, String name, String description, Instant startDate, UUID reminderId, Instant reminderTime, Intervale intervale, Color color, Icon icon, Long userId, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.reminderId = reminderId;
        this.reminderTime = reminderTime;
        this.intervale = intervale;
        this.color = color;
        this.icon = icon;
        this.userId = userId;
        this.createdAt = createdAt;
    }

    public static Habit restoreFromRepository(Long id, String name, String description, Instant startDate, UUID reminderId, Instant reminderTime, Intervale intervale, Color color, Icon icon, Long userId, Instant createdAt) {
        return new Habit(id, name, description, startDate, reminderId, reminderTime, intervale, color, icon, userId, createdAt);
    }
}
