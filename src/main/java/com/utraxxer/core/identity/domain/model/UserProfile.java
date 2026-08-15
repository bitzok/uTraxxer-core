package com.utraxxer.core.identity.domain.model;

import lombok.Getter;

@Getter
public class UserProfile {
    private Long id;
    private UserAuth userAuth;
    private String name;
    private String lastname;

    private UserProfile(Long id, UserAuth userAuth, String name, String lastname) {
        this.id = id;
        this.userAuth = userAuth;
        this.name = name;
        this.lastname = lastname;
    }

    public static UserProfile createNew(UserAuth userAuth, String name, String lastname) {
        return new UserProfile(null, userAuth, name, lastname);
    }

    public static UserProfile restoreFromRepository(Long id, UserAuth userAuth, String name, String lastname) {
        return new UserProfile(id, userAuth, name, lastname);
    }
}
