package com.utraxxer.core.habits.domain.port;

import com.utraxxer.core.habits.domain.model.Icon;

import java.util.List;

public interface IconRepositoryPort {
    List<Icon> findAll();
}
