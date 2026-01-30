package com.oauth2.demo.Service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oauth2.demo.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

