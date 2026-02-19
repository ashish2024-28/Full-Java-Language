package com.demoproject.Cotroller.Home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.Entity.Faculty;
import com.demoproject.Entity.Student;
import com.demoproject.Entity.SubAdmin;
import com.demoproject.Service.FacultyService;
import com.demoproject.Service.StudentService;
import com.demoproject.Service.SubAdminService;
import com.demoproject.Service.UniversityService;

@RestController
@RequestMapping("/{domain}/signUp")
public class SignUpController {
    
    @Autowired
    private SubAdminService subAdminService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UniversityService universityService;

    @GetMapping
    public ResponseEntity<?> signUpPage(@PathVariable String domain){
        try{
            return ResponseEntity.ok(universityService.getUniversityName(domain) + ". \nsignUp or create Yor Account ...\n For dAdmin, sAdmin,...");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    // ========= CREATE Sub Admin Account ========= 
    @PostMapping("/create_SubAdmin")
    public ResponseEntity<?> CreateSubAdmin(@PathVariable String domain, @RequestBody SubAdmin subAdmin) {
        try {
        String save = subAdminService.addSubAdmin(domain, subAdmin);
        return new ResponseEntity<>(save,HttpStatus.CREATED);
        
    } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }    
    }
    
    // ========= CREATE Faculty Account ========= 
    @PostMapping("/create_faculty")
    public ResponseEntity<?> createFaculty(@PathVariable String domain, @RequestBody Faculty s) {
        try {
            String save = facultyService.addFaculty(domain, s);
            return new ResponseEntity<>(save,HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);    
        }
    }
    
    // ========= CREATE Student Account ========= 
    @PostMapping("/create_student")
    public ResponseEntity<?> createStudent(@PathVariable String domain, @RequestBody Student s) {
        try {
            String save = studentService.addStudent(domain, s);
            return new ResponseEntity<>(save,HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    
}
