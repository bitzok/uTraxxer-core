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

    @OneToOne
    @JoinColumn(name = "intervales", nullable = false)
    private IntervaleEntity intervale;

    @OneToOne
    @JoinColumn(name = "colors", nullable = false)
    private ColorEntity color;

    @OneToOne
    @JoinColumn(name = "icons", nullable = false)
    private IconEntity icon;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(nullable=false)
    private Instant createdAt;
}
