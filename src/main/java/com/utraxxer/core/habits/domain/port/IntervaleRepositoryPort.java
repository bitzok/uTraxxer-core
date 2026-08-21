package com.utraxxer.core.habits.domain.port;

import com.utraxxer.core.habits.domain.model.Intervale;

import java.util.List;

public interface IntervaleRepositoryPort {
    List<Intervale> findAll();
}
