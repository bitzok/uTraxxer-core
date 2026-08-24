package com.utraxxer.core.habits.infrastructure.out.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "habits")
public class HabitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String description;

    @Column(nullable=false)
    private Instant startDate;

    @Column(nullable=true)
    private UUID reminderId;

    @Column(nullable=true)
    private Instant reminderTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "intervale_id", nullable = false)
    private IntervaleEntity intervale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id", nullable = false)
    private ColorEntity color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "icon_id", nullable = false)
    private IconEntity icon;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(nullable=false)
    private Instant createdAt;
}
