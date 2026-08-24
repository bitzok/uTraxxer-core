package com.utraxxer.core.habits.infrastructure.out.repository;

import com.utraxxer.core.habits.infrastructure.out.entity.HabitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitRepository extends JpaRepository<HabitEntity, Long> {
    List<HabitEntity> findByUserId(Long userId);
}
