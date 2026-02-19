package com.demoproject.Entity;


import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseUser {
    // All fiels are commom for Student, Faculty, SubAdmin, DomainAdmin.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String domain; // domain => university/collage ka unique name(like Haridwar University HU,hu,Hu)

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String mobileNumber; //Country code +91

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @CreationTimestamp
    private LocalDateTime createdDateTime;
    private LocalDateTime lastLoginDateTime; // For login purposes

    
}

