package com.demoproject.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoproject.Entity.Faculty;
import com.demoproject.Entity.University;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Optional<Faculty> findByEmail(String email);


    // ------ find all faculty for specific university ------
    List<Faculty> findByDomain(String domain);

    // ------ find one by domain + id  ------
    // **** this is for official use only no others  ***** 
    Faculty findByIdAndDomain(Long id, String domain);
    
    //  find one by domain + DomainId(Did) means (Id which provide by University or collage)
    Faculty findByFacultyIdAndDomain(String facultyId, String domain);
    
    //  find one by domain + Email
    Optional<Faculty> findByEmailAndDomain(String email, String domain);
    
    //  Login by domain + Email + Password
    Faculty findByEmailAndPassword(String email, String password);

    List<Faculty> findByCourseAndDomain(String course, String domain);
    
    List<Faculty> findByteachingBatchAndDomain(String tbatch, String domain);

    // check
    boolean existsByEmail(String email);
    boolean existsByFacultyIdAndDomain(String facultyId, String domain);
    boolean existsByDomainAndEmail(String domain, String email);



    
    // count 
    long countByUniversity(University university);
    long countByUniversity_Domain(String domain);





    
}
