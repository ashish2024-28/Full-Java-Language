package com.demoproject.Cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.demoproject.Entity.Student;
import com.demoproject.Service.StudentService;

@RestController
@RequestMapping("/{domain}/student")

@PreAuthorize("""
        hasRole('STUDENT') and
        #domain.equalsIgnoreCase(authentication.principal.domain)
        """)
        // #domain == principal.domain


public class StudenController {

    @Autowired
    private StudentService studentService;
    

    // @GetMapping
    // public ResponseEntity<?> test(@PathVariable String domain) {
    //     try {
    //         return  ResponseEntity.ok(universityService.getUniversityName_Logo(domain) +
    //          "Student Access OK");
            
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    //     }

    // }

    @GetMapping
    public ResponseEntity<?> getStudent(@PathVariable String domain) {
        // 1st option 
        // UsersPrinciple user =
        //     (UsersPrinciple) SecurityContextHolder
        //         .getContext()
        //         .getAuthentication()
        //         .getPrincipal();

        // String email = user.getUsername();

        // 2nd option 
        // Get the email from the SecurityContext (set by JwtFilter)
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return ResponseEntity.ok(
            studentService.getStudentByEmailAndDomain(email, domain)
        );
    }


    // // CREATE
    // @PostMapping("/add")
    // public ResponseEntity<?> add(@PathVariable String domain, @RequestBody Student s) {
    //     try {
    //         String save = service.addStudent(domain, s);
    //         return new ResponseEntity<>(save,HttpStatus.CREATED);

    //     } catch (Exception e) {
    //         return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    //     }
    // }

    // Update Password or Forget Password
    @PutMapping("/forgot_update_password")
    public ResponseEntity<?> updateStudentPassword(@PathVariable String domain, @RequestParam String email, @RequestParam String newpass){
        try {

            boolean save = studentService.updatePasswordByEmail(domain, email, newpass);
            return new ResponseEntity<>(save + " Password change successfully \n",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    // ------ UPDATE  by email ------
    @PutMapping("/update_by_email")
    public ResponseEntity<?> updateStudentByRollNO(@PathVariable String domain, @RequestBody Student s) {
        try {

            boolean save = studentService.updateStudentByEmail(domain, s);
            return new ResponseEntity<>(save + " Update successfully \n",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    // DELETE By RollNo
    @DeleteMapping("/delete_by_gmail")
    public ResponseEntity<?> deleteByRollNO(@PathVariable String domain, @RequestParam String email) {
        try {

            String save = studentService.deleteStudentByEmail(domain, email);
            System.out.println(save);
            return new ResponseEntity<>(save ,HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}


/*
@RestController → tells Spring this class contains API endpoints.

@RequestMapping("/student") → all APIs will start with /student.

@Autowired → Spring will automatically create the object of StudentService.

@PostMapping → handles HTTP POST request.

@RequestBody → converts JSON → Student object.
*/