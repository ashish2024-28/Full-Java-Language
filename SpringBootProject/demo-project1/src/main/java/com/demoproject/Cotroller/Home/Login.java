package com.demoproject.Cotroller.Home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.Entity.DomainAdmin;
import com.demoproject.Entity.Faculty;
import com.demoproject.Entity.Student;
import com.demoproject.Entity.SubAdmin;
import com.demoproject.Service.DomainAdminService;
import com.demoproject.Service.FacultyService;
import com.demoproject.Service.StudentService;
import com.demoproject.Service.SubAdminService;

@RestController
@RequestMapping("{domain}/login_profile")
public class Login {
    
    @Autowired
    private StudentService studentService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private SubAdminService subAdminService;
    @Autowired
    private DomainAdminService dAdminService;



    @GetMapping
    public String LonginPage(){
        return "Login Page ...\n For dAdmin, sAdmin,...";
    }

    // Student Login by domain + Email + Password
    @GetMapping("/student_login")
    public ResponseEntity<?> studentLogin(@PathVariable String domain, @RequestBody Student loginStudent){
        try {

            Student student = studentService.LoginStudent(domain, loginStudent);
            return new ResponseEntity<>(student,HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    // Faculty Login by domain + Email + Password
    @GetMapping("/faculty_login")
    public ResponseEntity<?> facultyLogin(@PathVariable String domain, @RequestBody Faculty loginFaculty){
        try {
            
            Faculty faculty = facultyService.LoginFaculty(domain, loginFaculty);
            return new ResponseEntity<>(faculty,HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    // SubAdmin Login by domain + Email + Password
     @GetMapping("/subAdmin_login")
    public ResponseEntity<?> subAdminLogin(@PathVariable String domain, @RequestBody SubAdmin loginsubAdmin){
        try {
            
            SubAdmin subAdmin = subAdminService.LoginSubAdmin(domain, loginsubAdmin);
            return new ResponseEntity<>(subAdmin,HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    // DomainAdmin Login by domain + Gmail + Password
    @GetMapping("/dAdmin_login")
    public ResponseEntity<?> domainAdminLogin(@PathVariable String domain, @RequestBody DomainAdmin loginDAdmin){
        try {
            
            DomainAdmin dAdmin = dAdminService.LoginDomainAdmin(domain, loginDAdmin);
            return new ResponseEntity<>(dAdmin,HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
