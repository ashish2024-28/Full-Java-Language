package com.demoproject.Service;

import com.demoproject.DTO.DomainAdminDTO.DomainAdminResponseDTO;
import com.demoproject.DTO.FacultyDTO.FacultyResponseDTO;
import com.demoproject.DTO.FacultyDTO.FacultySignupDTO;
import com.demoproject.DTO.StudentDTO.StudentResponseDTO;
import com.demoproject.DTO.StudentDTO.StudentSignupDTO;
import com.demoproject.DTO.SubAdminDTO.SubAdminResponseDTO;
import com.demoproject.DTO.SubAdminDTO.SubAdminSignupDTO;
import com.demoproject.Entity.*;

import org.modelmapper.ModelMapper;
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
    private UniversityService universityService;
    @Autowired
    @Qualifier("bcryptEncoder")
    PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    
    //  Login by domain + Email + Password
    // public DomainAdmin LoginDomainAdmin(LoginRequestDTO loginRequestDTO){
    //     DomainAdmin dAdminLogin = dAdminRepo.findByDomainAndEmail(loginRequestDTO.getDomain(),loginRequestDTO.getEmail());
    //     boolean passwordMatch = passwordEncoder.matches(loginRequestDTO.getPassword() ,dAdminLogin.getPassword());

    //     if (passwordMatch) {
    //         dAdminLogin.setLastLoginDateTime(LocalDateTime.now());
    //         return dAdminRepo.save(dAdminLogin);   
    //     } 
    //     else {    return null;  }
    // }

    // login when frontend send jwt token
    public DomainAdminResponseDTO getDomainAdminByEmailAndDomain(String email, String domain){
        DomainAdmin dAdminLogin = dAdminRepo.findByDomainAndEmail(domain, email);
        University university = universityService.getByDomain(domain);
        
        dAdminLogin.setCreatedDateTime(LocalDateTime.now());
        dAdminLogin = dAdminRepo.save(dAdminLogin);
        
        DomainAdminResponseDTO responseDTO = modelMapper.map(dAdminLogin, DomainAdminResponseDTO.class) ;
        responseDTO.setUniversityId(university.getId());
        String univName = university.getUniversityName();
        if(univName.isBlank() || univName == null){
            univName = university.getInstitutionName();
        }
        responseDTO.setUniversityName(univName);
        return responseDTO;

    }

    // Update Password or Forget Password
     public boolean updatePasswordByEmail(String domain, String email, String newPass ) {
        DomainAdmin old = dAdminRepo.findByDomainAndEmail(domain, email);
        if (old == null) return false;

        old.setPassword(passwordEncoder.encode(newPass));
        dAdminRepo.save(old);
        return true;

    }

// count 
    public long getStudentCount(String domain) {
        return studentService.getStudentCount(domain);
    }
    public long getFacultyCount(String domain) {
        return facultyService.getFacultyCount(domain);
    }
    public long getSubAdminCount(String domain) {
        return subAdminService.getSubAdminCount(domain);
    }




// These all are use by Main Admin
    //  READ ONE by domain 
    public DomainAdmin getDomainAdmin(String domain){
        return dAdminRepo.findByDomain(domain).orElse(null);
        
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
    public String addStudent(String domain, StudentSignupDTO s) {
        return studentService.addStudent(domain, s);
    }

    // ------ READ ALL student for specific university ------
    public List<StudentResponseDTO> getAllStudents(String domain) {
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
    public String addFaculty(String domain, FacultySignupDTO s) {
        return facultyService.addFaculty(domain, s);
    }

    // ------ READ ALL faculty for specific university ------
    public List<FacultyResponseDTO> getAllFaculty(String domain) {
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
    public String addSubAdmin(String domain, SubAdminSignupDTO SA){
        return subAdminService.addSubAdmin(domain, SA);
    }

    // READ ALL subadmin by domain
    public List<SubAdminResponseDTO> getAllSubAdmin(String domain){
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
