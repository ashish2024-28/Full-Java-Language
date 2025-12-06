package com.demoproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoproject.Entity.Faculty;


public interface FacultyRepository extends JpaRepository<Faculty, Long>{

    
} 
