package com.demoproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoproject.Entity.SubAdmin;



@Repository
public interface SubAdminRepository extends JpaRepository<SubAdmin, Long> {

    List<SubAdmin> findByDomain(String domain);

    // find by domain + id   or  READ ONE by domain + id
    // **** this is for official use only no others  ***** 
    SubAdmin findByIdAndDomain(Long id, String domain);

    SubAdmin findBySubAdminIdAndDomain(String subAdminId, String domain);

    SubAdmin findByEmailAndDomain(String email, String domain);

    SubAdmin findByEmailAndPassword(String email, String password);


// check this is exist or not
 
    boolean existsByEmail(String email);
    boolean existsBySubAdminIdAndDomain(String subAdminId, String domain);
    boolean existsByDomainAndEmail(String domain,String email);

}

