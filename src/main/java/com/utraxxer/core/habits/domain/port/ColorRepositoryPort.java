package com.utraxxer.core.habits.domain.port;

import com.utraxxer.core.habits.domain.model.Color;

import java.util.List;

public interface ColorRepositoryPort {
    List<Color> findAll();
}
