package com.demoproject.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demoproject.Entity.Role;
import com.demoproject.Entity.University;
import com.demoproject.DTO.LoginRequestDTO;
import com.demoproject.DTO.FacultyDTO.FacultyResponseDTO;
import com.demoproject.DTO.StudentDTO.StudentResponseDTO;
import com.demoproject.DTO.SubAdminDTO.SubAdminResponseDTO;
import com.demoproject.DTO.SubAdminDTO.SubAdminSignupDTO;
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
    private ModelMapper modelMapper;
    @Autowired
    @Qualifier("bcryptEncoder")
    private PasswordEncoder passwordEncoder ;

    

    // public SubAdminService(SubAdminRepository repo){
    //     this.SArepo = repo;
    // }

    

    //  Login by domain + email + Password
    public SubAdmin LoginSubAdmin(LoginRequestDTO loginRequestDTO){
        SubAdmin subAdminLogin = SArepo.findByEmailAndDomain(loginRequestDTO.getEmail(), loginRequestDTO.getDomain()).orElse(null);
        boolean passwordMatch = passwordEncoder.matches(loginRequestDTO.getPassword() ,subAdminLogin.getPassword());

        if (passwordMatch) {
            subAdminLogin.setLastLoginDateTime(LocalDateTime.now());
            return SArepo.save(subAdminLogin);
            
        } else {     return null;    }
    }


    // login when frontend send jwt token
    public SubAdminResponseDTO getSubAdminByEmailAndDomain(String email, String domain) {
        SubAdmin subAdminLogin = SArepo.findByEmailAndDomain(email,domain).orElseThrow();

        subAdminLogin.setLastLoginDateTime(LocalDateTime.now());
        subAdminLogin =  SArepo.save(subAdminLogin);

        return modelMapper.map(subAdminLogin, SubAdminResponseDTO.class) ;
    }



    // CREATE
    public String addSubAdmin(String domain, SubAdminSignupDTO signupDTO){
       
        SubAdmin requestSubAdmin = modelMapper.map(signupDTO, SubAdmin.class);

        University university = universityRepo.findByDomain(domain)
            .orElseThrow(() -> new RuntimeException("University not found"));
        requestSubAdmin.setDomain(domain);
        requestSubAdmin.setUniversity(university);
       
        if( SArepo.existsBySubAdminIdAndDomain(requestSubAdmin.getSubAdminId(),requestSubAdmin.getDomain())){ return "Sub Admin's Id field are already exist. ";  }
        if( SArepo.existsByDomainAndEmail(requestSubAdmin.getDomain(),requestSubAdmin.getEmail())){ return "Sub Admin's field are already exist. ";  }
        if( SArepo.existsByEmail(requestSubAdmin.getEmail())){ return "Enter Unique Email Id or Another Email Id . ";  }

        // for security use passwordEncoder
        requestSubAdmin.setPassword(passwordEncoder.encode(requestSubAdmin.getPassword()));
        requestSubAdmin.setRole(Role.SUB_ADMIN);
        SubAdmin save = SArepo.save(requestSubAdmin);
        return save.getName() + ",\nYour Account is Created Successfully.\nSub Admin Id : " + save.getSubAdminId() ;
            
    }

    public long getSubAdminCount(String domain) {
        return SArepo.countByUniversity_Domain(domain);
    }



    // ------ READ ALL domain for specific university ------
    public List<SubAdminResponseDTO> getAllSubAdmin(String domain){
        List<SubAdmin> subAdminList = SArepo.findByDomain(domain);

        return subAdminList.stream()
            .map(subAdmin -> modelMapper.map(subAdmin, SubAdminResponseDTO.class))
            .collect(Collectors.toList());
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

        SubAdmin subAdmin = SArepo.findByEmailAndDomain(email, domain).orElse(null); 
        return SArepo.save(subAdmin);
    }

    // Update Password or Forget Password
     public boolean updatePasswordByEmail(String domain, String email, String newPass ) {
        SubAdmin old = SArepo.findByEmailAndDomain(email, domain).orElse(null);
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
    public List<FacultyResponseDTO> getFacultyAll(String domain) {
        return facultyService.getAll(domain);
    }
    
    //  READ ONE by domain + DomainId(Did) means (Id which provide by University or collage)
    public Faculty getFacultyByFacultyId(String domain, String facultyId ) {
        return facultyService.getFacultyByFacultyId(domain, facultyId);
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

