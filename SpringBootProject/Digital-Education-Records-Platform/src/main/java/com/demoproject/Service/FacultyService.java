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
import com.demoproject.DTO.FacultyDTO.FacultyResponseDTO;
import com.demoproject.DTO.FacultyDTO.FacultySignupDTO;
import com.demoproject.DTO.StudentDTO.StudentResponseDTO;
import com.demoproject.Entity.Faculty;
import com.demoproject.Entity.Student;
import com.demoproject.Repository.FacultyRepository;
import com.demoproject.Repository.UniversityRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FacultyService {


    @Autowired
    private StudentService studentService;
    @Autowired
    private FacultyRepository frepo;
    @Autowired
    private UniversityRepo universityRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    @Qualifier("bcryptEncoder")
    private PasswordEncoder passwordEncoder;


    // private final FacultyRepository frepo;
    // public FacultyService(FacultyRepository frepo) {
    //     this.frepo = frepo;
    // }

    // //  Login by domain + Gmail + Password
    // public Faculty LoginFaculty(LoginRequestDTO loginRequestDTO){
    //     Faculty facultyLogin = frepo.findByEmailAndDomain(loginRequestDTO.getEmail() ,loginRequestDTO.getDomain()).orElse(null);
    //     boolean passwordMatch = passwordEncoder.matches(loginRequestDTO.getPassword() ,facultyLogin.getPassword());
        
    //     if (passwordMatch) {
    //         facultyLogin.setLastLoginDateTime(LocalDateTime.now());
    //         return frepo.save(facultyLogin);
            
    //     } else {    return null;    }
    // }


    // login when frontend send jwt token
    public FacultyResponseDTO getFacultyByEmailAndDomain(String email, String domain) {
        Faculty facultyLogin = frepo.findByEmailAndDomain(email,domain).orElseThrow();

        facultyLogin.setLastLoginDateTime(LocalDateTime.now());
        facultyLogin =  frepo.save(facultyLogin);

        return modelMapper.map(facultyLogin, FacultyResponseDTO.class) ;
    }


    // ---- CREATE ------
    public String addFaculty(String domain, FacultySignupDTO facultySignupDTO) {
        
        Faculty requesFaculty =modelMapper.map(facultySignupDTO, Faculty.class);

        University university = universityRepo.findByDomain(domain)
        .orElseThrow(() -> new RuntimeException("Invalid domain"));
        requesFaculty.setDomain(domain);
        requesFaculty.setUniversity(university);

        if( frepo.existsByFacultyIdAndDomain(requesFaculty.getFacultyId(),requesFaculty.getDomain()) ){    return "Faculty's Id field are already exist. ";  }
        if( frepo.existsByDomainAndEmail(requesFaculty.getDomain(),requesFaculty.getEmail()) ){    return "Faculty's Email field are already exist. ";  }
        if( frepo.existsByEmail(requesFaculty.getEmail())){ return "Enter Unique Email Id or Another Email Id . ";  }
       
        // for security use passwordEncoder
        requesFaculty.setPassword(passwordEncoder.encode(requesFaculty.getPassword()));

        requesFaculty.setRole(Role.FACULTY);
        Faculty save = frepo.save(requesFaculty);
        return save.getName() + ",\nYou Account is Created Successfully.\nFaculty Id : " + save.getFacultyId() ;
      
    }

    public long getFacultyCount(String domain) {
    return frepo.countByUniversity_Domain(domain);
    }



    // ------ READ ALL faculty for specific university ------
    public List<FacultyResponseDTO> getAll(String domain) {
        List<Faculty> facultyList = frepo.findByDomain(domain);
        
        return facultyList.stream()
            .map(faculty -> modelMapper.map(faculty, FacultyResponseDTO.class))
            .collect(Collectors.toList());
    }

    // ------ READ ONE by domain + id  ------
    // **** this is for official use only no others  ***** 
    public Faculty getById(String domain, Long id) {
        return frepo.findByIdAndDomain(id, domain);
    }
    
    //  READ ONE by domain + DomainId means (Id which provide by University or collage)
    public Faculty getFacultyByFacultyId(String domain, String facultyId ) {
        return frepo.findByFacultyIdAndDomain(facultyId, domain);
    }

    //  READ ONE by domain + gmail
    public Faculty getFacultyByGmail(String domain, String gmail ) {
        Faculty faculty = frepo.findByEmailAndDomain(gmail, domain).orElse(null); 
        return frepo.save(faculty);
    }
    
    // Update Password or Forget Password
     public boolean updatePasswordByEmail(String domain, String email, String newPass ) {
        Faculty old = frepo.findByEmailAndDomain(email, domain).orElse(null);
        if (old == null) return false;

        old.setPassword(newPass);
        frepo.save(old);
        return true;

    }

    // ------ UPDATE by id ------
    // **** this is for official use only no others  ***** 
    public Faculty updateFaculty(String domain, Long id, Faculty f) {
        Faculty old = frepo.findByIdAndDomain(id, domain);
        if (old == null) return null;
        
        old.setName(f.getName());
        old.setCourse(f.getCourse());
        old.setTeachingBatch(f.getTeachingBatch());
        old.setMobileNumber(f.getMobileNumber());
        
        return frepo.save(old);
    }

    // ------ UPDATE by Did (Domain id) ------
    public Boolean updateFacultyByFacultyId(String domain, Faculty f) {
        Faculty old = frepo.findByFacultyIdAndDomain(f.getFacultyId(), domain);
        if (old == null) return false;
        
        old.setName(f.getName());
        old.setCourse(f.getCourse());
        old.setTeachingBatch(f.getTeachingBatch());
        old.setMobileNumber(f.getMobileNumber());
        
        frepo.save(old);
        return true;
    }

    
    // ------ DELETE by id  ------
    // **** this is for official use only no others  ***** 
    public String deleteFacultyById(String domain, Long id) {
        Faculty f = frepo.findByIdAndDomain(id, domain);
        if (f == null) return "Invalid faculty ID";
        frepo.delete(f);
        return "Deleted faculty with id " + id;
    }

    // ------ DELETE by Did (Domain Id) ------
    public String deleteFacultyByFacultyId(String domain, String facultyId) {
        Faculty f = frepo.findByFacultyIdAndDomain(facultyId, domain);
        if (f == null) return "Invalid faculty ID";
        frepo.delete(f);
        return "Deleted faculty with id " + facultyId ;
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
