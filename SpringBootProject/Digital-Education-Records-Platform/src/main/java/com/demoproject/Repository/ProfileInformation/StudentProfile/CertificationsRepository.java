package com.demoproject.Repository.ProfileInformation.StudentProfile;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoproject.Entity.ProfileInformation.StudentInfo.Certifications;

@Repository
public interface CertificationsRepository 
        extends JpaRepository<Certifications, Long> {


    List<Certifications> findByTitleContainingIgnoreCase(String title);
    
    List<Certifications> findByStudentId(Long studentId);

    
}
