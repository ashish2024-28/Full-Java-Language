package com.demoproject.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demoproject.Entity.Role;
import com.demoproject.Entity.Student;
import com.demoproject.Entity.University;
import com.demoproject.Repository.StudentRepository;
import com.demoproject.Repository.UniversityRepo;

@Service
public class StudentService {


    @Autowired
    private StudentRepository repo;
    @Autowired
    private UniversityRepo universityRepo;
    
    @Autowired
    @Qualifier("bcryptEncoder")
    private PasswordEncoder passwordEncoder;

    // private StudentRepository repo;
    // public StudentService(StudentRepository repo)  {
    //     this.repo = repo;
    // }

    // ❌ WHAT YOU MUST NEVER DO ->  ❌ BAD -> return studentRepo.findById(id).get();
    // Why? => Exposes entity, Breaks security, Infinite JSON loop risk, Hard to refactor later
    //  Login by domain + Email + Password DTO

    @Autowired
    private JWTServie jwtServie ;
    @Autowired
    AuthenticationManager authenticationManager;    
    //  Login by Email + Password
    public String LoginStudent(String domain, String email, String password){
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            if(authentication.isAuthenticated()){
                    // return "success";
                 return jwtServie.generateToken(email);

                }
                return "fail";
    }
    //  Login by domain + Email + Password
    // public Student LoginStudent(String domain, String email, String password){
    //     Student studentLogin = repo.findByEmailAndDomain(email, domain);
    //     boolean passwordMatch = passwordEncoder.matches(password,studentLogin.getPassword());

    //     if (passwordMatch) {
    //         studentLogin.setLastLoginDateTime(LocalDateTime.now());
    //         return repo.save(studentLogin);
            
    //     } else {    return null;    }
    // }
    

    // ---- CREATE ------
    public String addStudent(String domain, Student s) {
        
        University university = universityRepo.findByDomain(domain);
        if (university == null) {   return "University not found for domain: " + domain;    }
        s.setDomain(domain);

        if( repo.existsByRollNumberAndDomain(s.getRollNumber(),s.getDomain()) ){    return "Student's RollNumber field are already exist. ";    }
        if( repo.existsByDomainAndEmail(s.getDomain(),s.getEmail()) ){    return "Student's Email field are already exist. ";    }
        if( repo.existsByEmail(s.getEmail())){ return "Enter Unique Email Id or Another Email Id . ";  }
        
        // for security use passwordEncoder
        s.setPassword(passwordEncoder.encode(s.getPassword()));

        s.setRole(Role.STUDENT);
        s.setUniversity(university);
        Student save = repo.save(s);
        return save.getName() + ",\nYou Account is Created Successfully.\nRoll Number : " + save.getRollNumber() ;

    }

    // ------ READ ALL student for specific university ------
   
    public List<Student> getAllStudent(String domain) {
        return repo.findAllByDomain(domain);
    }

    // READ ONE by domain + id
    // **** this is for official use only no others  ***** 
    public Student getById(String domain, Long id) {
        return repo.findByIdAndDomain(id, domain);
    }

    // ------ READ ONE by domain + rollNo ------
    public Student getStudentByRollNo(String domain, String rollNumber) {
        return repo.findByRollNumberAndDomain(rollNumber, domain);        
    }
    
    // ------ READ ONE by domain + Email ------
    public Student getStudentByEmail(String email, String domain) {
        
        Student student  = repo.findByEmailAndDomain(email, domain);        
        return repo.save(student);
    }
    
    // ------ READ All by domain + Name ------
    public List<Student> getAllStudentByName(String domain,String name) {
        return repo.findAllByNameAndDomain(name, domain);
    }
    
    // ------ READ All by domain + Branch ------
    public List<Student> getAllStudentByBranch(String domain,String branch) {
        return repo.findAllByBranchAndDomain(branch, domain);
    }

    // ------ READ All by domain + Course ------
    public List<Student> getAllStudentByCourse(String domain,String course) {
        return repo.findAllByCourseAndDomain(course, domain);
    }

    // ------ READ All by domain + Batch ------
    public List<Student> getAllStudentByBatch(String domain,String batch) {
        return repo.findAllByBatchAndDomain(batch, domain);
    }

    // Update Password or Forget Password
     public boolean updatePasswordByEmail(String domain, String email, String newPass ) {
        Student old = repo.findByEmailAndDomain(email, domain);
        if (old == null) return false;

        old.setPassword(passwordEncoder.encode(newPass));
        repo.save(old);
        return true;
    }

    // ------ UPDATE by id ------
    // **** this is for official use only no others  ***** 
    public Student updateStudentById(String domain, Long id, Student s) {
        Student old = repo.findByIdAndDomain(id, domain);
        if (old == null) return null;

        old.setName(s.getName());
        old.setBranch(s.getBranch());
        old.setCourse(s.getCourse());
        old.setBatch(s.getBatch());
        old.setMobileNumber(s.getMobileNumber());
        old.setFatherName(s.getFatherName());
        old.setFatherMobNo(s.getFatherMobNo());

        return repo.save(old);
    }


    // ------ UPDATE  by Email ------
    public Boolean updateStudentByEmail(String domain, Student s) {
        Student old = repo.findByEmailAndDomain(s.getEmail(), domain);
        if (old == null) return false;

        old.setName(s.getName());
        old.setBranch(s.getBranch());
        old.setCourse(s.getCourse());
        old.setBatch(s.getBatch());
        old.setMobileNumber(s.getMobileNumber());
        old.setFatherName(s.getFatherName());
        old.setFatherMobNo(s.getFatherMobNo());

        repo.save(old);
        return true;
    }

    // ------ DELETE by id ------
    // **** this is for official use only no others  ***** 
    public String deleteStudentbyId(String domain, Long id) {
        Student s = repo.findByIdAndDomain(id, domain);
        if (s == null) return "Invalid student";
        
        repo.delete(s);
        return "Deleted student with id " + id;
    }

    // ------ DELETE By RollNo ------
    public String deleteStudentByEmail(String domain, String email) {
        Student s = repo.findByRollNumberAndDomain(email, domain);
        if (s == null) return "Invalid student";
        String rollno = s.getRollNumber();
        repo.delete(s);
        return "Deleted student with RollNo " + rollno;
    }


  


}
