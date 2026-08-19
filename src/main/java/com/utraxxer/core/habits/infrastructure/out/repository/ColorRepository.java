package com.utraxxer.core.habits.infrastructure.out.repository;

import com.utraxxer.core.habits.infrastructure.out.entity.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<ColorEntity, Long> {
}
