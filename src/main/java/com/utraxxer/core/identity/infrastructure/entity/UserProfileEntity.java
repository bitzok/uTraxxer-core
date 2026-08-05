package com.utraxxer.core.identity.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_profile")
public class UserProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "auth_id")
    private UserAuthEntity userAuthEntity;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

}