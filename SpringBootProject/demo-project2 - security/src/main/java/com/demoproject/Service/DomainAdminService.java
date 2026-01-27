package com.demoproject.Service;

import com.demoproject.Entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.demoproject.Repository.DomainAdminRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DomainAdminService {


    // method 1
    @Autowired
    private StudentService studentService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private SubAdminService subAdminService;
    @Autowired
    private DomainAdminRepository dAdminRepo;
    @Autowired
    @Qualifier("bcryptEncoder")
    PasswordEncoder passwordEncoder;


    

    // method 2
    // private final StudentService studentService;
    // private final FacultyService facultyService;
    // private final SubAdminService subAdminService;

    // public DomainAdminService(StudentService studentService, FacultyService facultyService, SubAdminService subAdminService) {

    //     this.studentService = studentService;
    //     this.facultyService = facultyService;
    //     this.subAdminService = subAdminService;
    // }


// ********** (self) DomainAdmin operations **********
 
    //here first fill all university details And Second Admin (means DomainAdmin) details
    // both details filled then submit and save both information in bd or create 
    // Admin's Details (who handle the own university) --> DomainAdmin

    //  Login by domain + Email + Password
    public DomainAdmin LoginDomainAdmin(String domain, String email, String password){
        DomainAdmin dAdminLogin = dAdminRepo.findByDomainAndEmail(domain,email);
        boolean passwordMatch = passwordEncoder.matches(password,dAdminLogin.getPassword());

        if (passwordMatch) {
            dAdminLogin.setLastLoginDateTime(LocalDateTime.now());
            return dAdminRepo.save(dAdminLogin);   
        } 
        else {    return null;  }
    }

    // Update Password or Forget Password
     public boolean updatePasswordByEmail(String domain, String email, String newPass ) {
        DomainAdmin old = dAdminRepo.findByDomainAndEmail(domain, email);
        if (old == null) return false;

        old.setPassword(passwordEncoder.encode(newPass));
        dAdminRepo.save(old);
        return true;

    }


// These all are use by Main Admin
    //  READ ONE by domain 
    public DomainAdmin getDomainAdmin(String domain){
        return dAdminRepo.findByDomain(domain);
        
    }

    // ------ READ ALL DomainAdmin  ------
    public List<DomainAdmin> getAllDomainAdmin() {
        return dAdminRepo.findAll();
    }
    
    // ------ Delete DomainAdmin for specific university ------
    public String deleteDomainAdminByGmail(String domain, String gmail){
        String delete = dAdminRepo.deleteByDomainAndEmail(domain,gmail);
        return "Deleted Domain Admin with gmail " + gmail + " \n" + delete;
    }

// ********** STUDENT operations **********
  
    // ---- Add Student ------
    public String addStudent(String domain, Student s) {
        return studentService.addStudent(domain, s);
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
    public List<Student> getAllStudentByName(String domain, String name) {
        return studentService.getAllStudentByName(domain, name);        
    }

    // ------ READ ONE by domain + Gmail ------
    public Student getStudentByEmail(String email, String domain) {
        return studentService.getStudentByEmail(domain, email);        
    }

    // ------ READ All by domain + Branch ------
    public List<Student> getAllStudentByBranch(String domain,String branch) {
        return studentService.getAllStudentByBranch(domain,branch);
    }

    // ------ READ All by domain + Course ------
    public List<Student> getAllStudentByCourse(String domain,String course) {
        return studentService.getAllStudentByCourse(domain,course);
    }

    // ------ READ All by domain + Batch ------
    public List<Student> getStudentByBatch(String domain, String batch) {
        return studentService.getAllStudentByBatch(domain, batch);
    }

    // ------ UPDATE  by email  ------
    public Boolean updateStudentByEmail(String domain, Student s) {
        return studentService.updateStudentByEmail(domain,s);
    }

    // ------ DELETE By email ------ 
    public String deleteStudentByEmail(String domain, String email) {
        return studentService.deleteStudentByEmail(domain, email);
    }


// ********** FACULTY operations ********** 


    // ---- CREATE ------
    public String addFaculty(String domain, Faculty s) {
        return facultyService.addFaculty(domain, s);
    }

    // ------ READ ALL faculty for specific university ------
    public List<Faculty> getAllFaculty(String domain) {
        return facultyService.getAll(domain);
    }
    
    public Faculty getFacultyByFacultyId(String domain, String facultyId ) {
        return facultyService.getFacultyByFacultyId(domain, facultyId);
    }
    
    //  READ ONE by domain + gmail
    public Faculty getFacultyByGmail(String domain, String gmail ) {
        return facultyService.getFacultyByGmail(domain, gmail);
    }

    // ------ UPDATE by FacultyId means (Id which provide by University or collage) ------
    public Boolean updateFacultyByFacultyId(String domain, Faculty f) {
       return facultyService.updateFacultyByFacultyId(domain, f);
    }
    
    // ------ DELETE by FacultyId ------
    public String deleteFacultyByFacultyId(String domain, String facultyId) {
       return facultyService.deleteFacultyByFacultyId(domain, facultyId);
    }


// **********  SUBADMIN operations ********** 
   
    // CREATE
    public String addSubAdmin(String domain, SubAdmin SA){
        return subAdminService.addSubAdmin(domain, SA);
    }

    // READ ALL subadmin by domain
    public List<SubAdmin> getAllSubAdmin(String domain){
        return subAdminService.getAllSubAdmin(domain);
    }

    //  READ ONE by domain + DomainId means (Id which provide by University or collage)
    public SubAdmin getSubAdminBySubAdminId(String domain, String subAdminId){
        return subAdminService.getSubAdminBySubAdminId(domain, subAdminId);
    }

    // UPDATE
    public SubAdmin updateSubAdminBySubAdminId(String domain, SubAdmin newData){
       return subAdminService.updateSubAdminBySubAdminId(domain,  newData);
    }

    // DELETE
    public String deleteSubAdminBySubAdminId(String domain, String subAdminId){
        return subAdminService.deleteSubAdminBySubAdminId(domain, subAdminId);
       
    }







   

    


   
}
