package com.demoproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoproject.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // find by domain
    // ------ READ ALL student for specific university ------
    List<Student> findAllByDomain(String domain);

    // find by domain + id   or  READ ONE by domain + id
    // **** this is for official use only no others  ***** 
    Student findByIdAndDomain(Long id, String domain);

    // find By RollNo + domain
    Student findByRollNumberAndDomain(String rollNumber, String domain);
    
    // find By  Gmail  + domain
    Student findByEmailAndDomain(String email, String domain);
    
    // find By  Gmail  + Password
    Student findByEmailAndPassword(String email, String domain);

    // find By Name + domain
    List<Student> findAllByNameAndDomain(String name, String domain);

    // find By Branch + domain
    List<Student> findAllByBranchAndDomain(String branch, String domain);
    
    // find By Course + domain
    List<Student> findAllByCourseAndDomain(String course, String domain);
    
    // find By Batch + domain
    List<Student> findAllByBatchAndDomain( String batch, String domain);

// check exist or not
    boolean existsByEmail(String gmail);
    boolean existsByRollNumberAndDomain(String rollNumber, String domain);
    boolean existsByDomainAndEmail(String domain, String gmail);





}
