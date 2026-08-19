package com.utraxxer.core.habits.domain.model;

import lombok.Getter;

@Getter
public class Color {
    private Long id;
    private String name;
    private String hexCode;

    private Color(Long id, String name, String hexCode) {
        this.id = id;
        this.name = name;
        this.hexCode = hexCode;
    }

    public static Color restoreFromRepository(Long id, String name, String hexCode) {
        return new Color(id, name, hexCode);
    }
}
