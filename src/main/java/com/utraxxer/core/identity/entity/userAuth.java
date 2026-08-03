package com.utraxxer.core.identity.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class userAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    @Column(unique=true, nullable=false)
    private String email;
    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }

    @Column(unique=true, nullable=false)
    private String username;
    public String getUsername(){ return username; }
    public void setUsername(String username){ this.username = username; }

    @Column(nullable=false)
    private String password;
    public String getPassword(){ return password; }
    public void setPassword(String username){ this.password = password; }

    @Column(nullable=false)
    private String state;
    public String getState(){ return state; }
    public void setState(String state){ this.state = state; }

    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;
    public LocalDateTime getCreatedAt(){ return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt){ this.createdAt = createdAt; }
}
