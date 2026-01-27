package com.demoproject.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demoproject.Entity.Role;
import com.demoproject.Entity.University;
import com.demoproject.Entity.Faculty;
import com.demoproject.Entity.Student;
import com.demoproject.Entity.SubAdmin;
import com.demoproject.Repository.SubAdminRepository;
import com.demoproject.Repository.UniversityRepo;


@Service
public class SubAdminService {


    @Autowired
    private StudentService studentService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private SubAdminRepository SArepo;
    @Autowired
    private UniversityRepo universityRepo;
    @Autowired
    @Qualifier("bcryptEncoder")
    private PasswordEncoder passwordEncoder ;

    

    // public SubAdminService(SubAdminRepository repo){
    //     this.SArepo = repo;
    // }


      //  Login by domain + email + Password
    public SubAdmin LoginSubAdmin(String domain, String email, String password){
        SubAdmin subAdminLogin = SArepo.findByEmailAndDomain(email, domain);
        boolean passwordMatch = passwordEncoder.matches(password,subAdminLogin.getPassword());

        if (passwordMatch) {
            subAdminLogin.setLastLoginDateTime(LocalDateTime.now());
            return SArepo.save(subAdminLogin);
            
        } else {     return null;    }
    }



    // CREATE
    public String addSubAdmin(String domain, SubAdmin SA){
       
        University university = universityRepo.findByDomain(domain);
        if (university == null) {   return "University not found for domain: " + domain;    }
        SA.setDomain(domain);
       
        if( SArepo.existsBySubAdminIdAndDomain(SA.getSubAdminId(),SA.getDomain())){ return "Sub Admin's Id field are already exist. ";  }
        if( SArepo.existsByDomainAndEmail(SA.getDomain(),SA.getEmail())){ return "Sub Admin's field are already exist. ";  }
        if( SArepo.existsByEmail(SA.getEmail())){ return "Enter Unique Email Id or Another Email Id . ";  }

        // for security use passwordEncoder
        SA.setPassword(passwordEncoder.encode(SA.getPassword()));
        SA.setRole(Role.SUB_ADMIN);
        SA.setUniversity(university);
        SubAdmin save = SArepo.save(SA);
        return save.getName() + ",\nYou Account is Created Successfully.\nSub Admin Id : " + save.getSubAdminId() ;
            
    }

    // ------ READ ALL domain for specific university ------
    public List<SubAdmin> getAllSubAdmin(String domain){
        return SArepo.findByDomain(domain);
    }

    // READ ONE by domain + id
    // **** this is for official use only no others  ***** 
    public SubAdmin getSubAdminById(String domain, Long id){
        return SArepo.findByIdAndDomain(id ,domain);
    }
    
    // //  READ ONE by domain + DomainId means (Id which provide by University or collage)
    public SubAdmin getSubAdminBySubAdminId(String domain, String subAdminId){
        return SArepo.findBySubAdminIdAndDomain(subAdminId, domain);
    }
    
    //  READ ONE by domain + Email
    public SubAdmin getFacultyByEmail(String domain, String email ) {

        SubAdmin subAdmin = SArepo.findByEmailAndDomain(email, domain); 
        return SArepo.save(subAdmin);
    }

    // Update Password or Forget Password
     public boolean updatePasswordByEmail(String domain, String email, String newPass ) {
        SubAdmin old = SArepo.findByEmailAndDomain(email, domain);
        if (old == null) return false;

        old.setPassword(passwordEncoder.encode(newPass));
        SArepo.save(old);
        return true;

    }

    // UPDATE 
    // **** this is for official use only no others  ***** 
    public SubAdmin updateSubAdminById(String domain, Long id, SubAdmin newData){
        SubAdmin old = SArepo.findByIdAndDomain(id, domain);
        if (old == null) return null;

        old.setName(newData.getName());
        old.setCourse(newData.getCourse());
        old.setMobileNumber(newData.getMobileNumber());
        old.setEmail(newData.getEmail());
        
        return SArepo.save(old);
    }

    // UPDATE  + SubAdminId means (subAdminId which provide by University or collage)
    public SubAdmin updateSubAdminBySubAdminId(String domain, SubAdmin newData){
        SubAdmin old = SArepo.findBySubAdminIdAndDomain(newData.getSubAdminId(), domain);
        if (old == null) return null;
        
        old.setName(newData.getName());
        old.setCourse(newData.getCourse());
        old.setMobileNumber(newData.getMobileNumber());
        
        return SArepo.save(old);
    }

    // DELETE
    // **** this is for official use only no others  ***** 
    public String deleteSubAdminbyId(String domain, Long id){
        SubAdmin sa = SArepo.findByIdAndDomain(id, domain);
        if (sa == null) return "Not found";

        SArepo.delete(sa);
        return "SubAdmin deleted: " + id;
    }

    // DELETE
    public String deleteSubAdminBySubAdminId(String domain, String subAdminId){
        SubAdmin sa = SArepo.findBySubAdminIdAndDomain(subAdminId, domain);;
        if (sa == null) return "Not found";

        SArepo.delete(sa);
        return "Deleted SubAdmin with DId (ID) : " + subAdminId;
    }



    // ------ READ ALL faculty for specific university ------
    public List<Faculty> getFacultyAll(String domain) {
        return facultyService.getAll(domain);
    }
    
    //  READ ONE by domain + DomainId(Did) means (Id which provide by University or collage)
    public Faculty getFacultyByFacultyId(String domain, String facultyId ) {
        return facultyService.getFacultyByFacultyId(domain, facultyId);
    }
   



    // ------ READ ALL student for specific university ------
    public List<Student> getAllStudents(String domain) {
        return studentService.getAllStudent(domain);
    }

    // ------ READ ONE by domain + rollNo ------
    public Student getStudentByRollNo(String domain, String rollNo) {
        return studentService.getStudentByRollNo(domain, rollNo);        
    }
    
    // ------ READ ONE by domain + Name ------
    public List<Student> getStudentByName(String domain, String name) {
        return studentService.getAllStudentByName(domain, name);        
    }

    // ------ READ All by domain + Branch ------
    public List<Student> getStudentByBranch(String domain,String branch) {
        return studentService.getAllStudentByBranch(domain,branch);
    }

    // ------ READ All by domain + Course ------
    public List<Student> getStudentByCourse(String domain,String course) {
        return studentService.getAllStudentByCourse(domain,course);
    }

    // ------ READ All by domain + Batch ------
    public List<Student> getStudentByBatch(String domain, String batch) {
        return studentService.getAllStudentByBatch(domain, batch);
    }



}

