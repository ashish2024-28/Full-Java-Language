package com.demoproject.Cotroller.Home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.DTO.FacultyDTO.FacultySignupDTO;
import com.demoproject.DTO.StudentDTO.StudentSignupDTO;
import com.demoproject.DTO.SubAdminDTO.SubAdminSignupDTO;
import com.demoproject.Entity.Faculty;
import com.demoproject.Entity.Student;
import com.demoproject.Entity.SubAdmin;
import com.demoproject.Service.FacultyService;
import com.demoproject.Service.StudentService;
import com.demoproject.Service.SubAdminService;
import com.demoproject.Service.UniversityService;

@RestController
@RequestMapping("/{domain}/signup")
public class SignUp {
    
    @Autowired
    private SubAdminService subAdminService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UniversityService universityService;

    @GetMapping
    public ResponseEntity<?> LonginPage(@PathVariable String domain){
    try{
        return ResponseEntity.ok(
                universityService.getUniversityName_Logo(domain)
        );
    } catch (Exception e) {
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
}


    // ========= CREATE Student Account ========= 
    @PostMapping("/create_student")
    public ResponseEntity<?> createStudent(@PathVariable String domain, @RequestBody StudentSignupDTO studentDto) {
        try {
            String save = studentService.addStudent(domain, studentDto);
            return new ResponseEntity<>(save,HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    

    // ========= CREATE Sub Admin Account ========= 
    @PostMapping("/create_SubAdmin")
    public ResponseEntity<?> CreateSubAdmin(@PathVariable String domain, @RequestBody SubAdminSignupDTO subAdminDTO) {
        try {
        String save = subAdminService.addSubAdmin(domain, subAdminDTO);
        return new ResponseEntity<>(save,HttpStatus.CREATED);
        
    } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }    
    }
    
    // ========= CREATE Faculty Account ========= 
    @PostMapping("/create_faculty")
    public ResponseEntity<?> createFaculty(@PathVariable String domain, @RequestBody FacultySignupDTO facultySignupDTO) {
        try {
            String save = facultyService.addFaculty(domain, facultySignupDTO);
            return new ResponseEntity<>(save,HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);    
        }
    }
    
   

    
}
