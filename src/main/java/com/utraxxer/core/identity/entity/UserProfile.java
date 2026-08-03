package com.utraxxer.core.identity.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "auth_id")
    private UserAuth userAuth;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

}
