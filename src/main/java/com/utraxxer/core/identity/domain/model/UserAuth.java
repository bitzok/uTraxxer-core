package com.utraxxer.core.identity.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserAuth {
    private Long id;
    private String email;
    private String username;
    private String password;
    private String state;
    private LocalDateTime createdAt;
}
