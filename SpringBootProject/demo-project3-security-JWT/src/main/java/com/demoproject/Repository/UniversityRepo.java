package com.demoproject.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoproject.Entity.University;


@Repository
public interface UniversityRepo extends JpaRepository<University,Long> {

    // University findByDomain(String domain);
    
    University findByDomain(String domain);
    
    University findByDomainAndId(String domain, Long id);
    
    void deleteByIdAndDomain(Long id, String domain);
    
    
    boolean existsByDomain(String domain);

    boolean existsByPermanentId(String permanentId);

    boolean existsByEmail(String email);

    boolean existsByMobileNumber(String mobileNumber);

  
}
