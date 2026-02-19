package com.demoproject.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoproject.Entity.DomainAdmin;

@Repository
public interface DomainAdminRepository extends JpaRepository<DomainAdmin, Long>{

    
    // DomainAdmin findByDomain(String domain);
    Optional<DomainAdmin> findByDomain(String domain);

    DomainAdmin findByDomainAndEmail(String domain, String email);

    // DomainAdmin findByEmail(String email);
    Optional<DomainAdmin> findByEmail(String email);


    String deleteByDomainAndEmail(String domain, String email);

    boolean existsByEmail(String email);
    boolean existsByMobileNumber(String mobileNumber);

    Optional<DomainAdmin> findByEmailAndDomain(String email, String domain);




    
} 
