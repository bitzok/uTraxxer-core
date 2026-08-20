package com.utraxxer.core.habits.domain.model;

import lombok.Getter;

@Getter
public class Icon {
    private Long id;
    private String name;
    private String svgPath;

    private Icon(Long id, String name, String svgPath) {
        this.id = id;
        this.name = name;
        this.svgPath = svgPath;
    }

    public static Icon restoreFromRepository(Long id, String name, String svgPath) {
        return new Icon(id, name, svgPath);
    }
}
