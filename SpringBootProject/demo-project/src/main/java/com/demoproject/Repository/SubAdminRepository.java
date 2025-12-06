package com.demoproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoproject.Entity.SubAdmin;

public interface SubAdminRepository extends JpaRepository<SubAdmin, Long> {
    
}
