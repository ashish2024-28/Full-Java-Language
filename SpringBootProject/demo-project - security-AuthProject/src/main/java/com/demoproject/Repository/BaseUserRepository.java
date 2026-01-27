package com.demoproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demoproject.Entity.BaseUser;

public interface BaseUserRepository extends JpaRepository<BaseUser, Long> {

    BaseUser findByEmailAndPassword(String email, String password);
    
    BaseUser findByEmail(String email);

    BaseUser findByRole(String role);


}
