package com.utraxxer.core.identity.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfile {
    private Long id;
    private UserAuth userAuth;
    private String name;
    private String lastname;
}
