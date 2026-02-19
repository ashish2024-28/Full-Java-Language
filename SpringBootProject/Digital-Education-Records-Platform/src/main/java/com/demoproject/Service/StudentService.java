package com.demoproject.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demoproject.DTO.LoginRequestDTO;
import com.demoproject.DTO.StudentDTO.StudentResponseDTO;
import com.demoproject.DTO.StudentDTO.StudentSignupDTO;
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

    @Autowired
    private ModelMapper modelMapper;

    
    //  Login by domain + Email + Password
    // public StudentResponseDTO LoginStudent(LoginRequestDTO loginRequestDTO){
    //     Student studentLogin = repo.findByEmailAndDomain(loginRequestDTO.getEmail(), loginRequestDTO.getDomain()).orElse(null);
    //     boolean passwordMatch = passwordEncoder.matches(loginRequestDTO.getPassword(),studentLogin.getPassword());

    //     if (passwordMatch) {
    //         studentLogin.setLastLoginDateTime(LocalDateTime.now());
    //         studentLogin =  repo.save(studentLogin);
    //         return modelMapper.map(studentLogin, StudentResponseDTO.class);
            
    //     } else {    return null;    }
    // }

    // login when frontend send jwt token
    public StudentResponseDTO getStudentByEmailAndDomain(String email, String domain) {
        Student studentLogin = repo.findByEmailAndDomain(email,domain).orElseThrow();

        studentLogin.setLastLoginDateTime(LocalDateTime.now());
        studentLogin =  repo.save(studentLogin);

        return modelMapper.map(studentLogin, StudentResponseDTO.class) ;
    }

    public StudentResponseDTO LoginStudent(LoginRequestDTO loginRequestDTO){
        Student studentLogin = repo.findByEmailAndDomain(loginRequestDTO.getEmail(), loginRequestDTO.getDomain()).orElse(null);
        boolean passwordMatch = passwordEncoder.matches(loginRequestDTO.getPassword(),studentLogin.getPassword());

        if (passwordMatch) {
            studentLogin.setLastLoginDateTime(LocalDateTime.now());
            studentLogin =  repo.save(studentLogin);
            return modelMapper.map(studentLogin, StudentResponseDTO.class);
            
        } else {    return null;    }
    }
    

    // ---- CREATE ------
    public String addStudent(String domain, StudentSignupDTO signupStrudent) {
        
        Student save = modelMapper.map(signupStrudent, Student.class);

        University university = universityRepo.findByDomain(domain)
        .orElseThrow(() -> new RuntimeException("Invalid domain"));
        save.setDomain(domain);
        save.setUniversity(university);


        if( repo.existsByRollNumberAndDomain(save.getRollNumber(),save.getDomain()) ){    return "Student's RollNumber field are already exist. ";    }
        if( repo.existsByDomainAndEmail(save.getDomain(),save.getEmail()) ){    return "Student's Email field are already exist. ";    }
        if( repo.existsByEmail(save.getEmail())){ return "Enter Unique Email Id or Another Email Id . ";  }
        
        // for security use passwordEncoder
        save.setPassword(passwordEncoder.encode(save.getPassword()));

        save.setRole(Role.STUDENT);
        save = repo.save(save);
        return save.getName() + ",\nYou Account is Created Successfully.\nRoll Number : " + save.getRollNumber() ;

    }

    public long getStudentCount(String domain) {
    return repo.countByUniversity_Domain(domain);
    }


    // ------ READ ALL student for specific university ------
   
    public List<StudentResponseDTO> getAllStudent(String domain) {
        List<Student> studentsList = repo.findAllByDomain(domain);

        return studentsList.stream()
            .map(student -> modelMapper.map(student, StudentResponseDTO.class))
            .collect(Collectors.toList());
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
        
        Student student  = repo.findByEmailAndDomain(email, domain).orElse(null);        
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
        Student old = repo.findByEmailAndDomain(email, domain).orElse(null);
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
        Student old = repo.findByEmailAndDomain(s.getEmail(), domain).orElse(null);
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
