package com.oauth2.demo.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    
    @CreationTimestamp
    private LocalDateTime createAccounDateTime;

    private String providerType;   // GOOGLE / GITHUB
    private String providerId; // sub (google) / id (github)
    
    private String role = "USER";

    // getters & setters
}

