package com.utraxxer.core.habits.domain.model;

import lombok.Getter;

@Getter
public class Intervale {
    private Long id;
    private String name;

    private Intervale(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Intervale restoreFromRepository(Long id, String name) {
        return new Intervale(id, name);
    }
}
