package com.demoproject.Cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.demoproject.Entity.Student;
import com.demoproject.Service.StudentService;

@RestController
@RequestMapping("/{domain}/student")
public class StudenController {

    @Autowired
    private StudentService service;


    // CREATE
    @PostMapping("/add")
    public ResponseEntity<?> add(@PathVariable String domain, @RequestBody Student s) {
        try {
            String save = service.addStudent(domain, s);
            return new ResponseEntity<>(save,HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    // Update Password or Forget Password
    @PutMapping("/forgot-password/update-password")
    public ResponseEntity<?> updateStudentPassword(@PathVariable String domain, @RequestParam String email, @RequestParam String newpass){
        try {

            boolean save = service.updatePasswordByEmail(domain, email, newpass);
            return new ResponseEntity<>(save + " Password change successfully \n",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    // ------ UPDATE  by email ------
    @PutMapping("/update-by/email")
    public ResponseEntity<?> updateStudentByRollNO(@PathVariable String domain, @RequestBody Student s) {
        try {

            boolean save = service.updateStudentByEmail(domain, s);
            return new ResponseEntity<>(save + " Update successfully \n",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    // DELETE By RollNo
    @DeleteMapping("/delete-by/gmail")
    public ResponseEntity<?> deleteByRollNO(@PathVariable String domain, @RequestParam String email) {
        try {

            String save = service.deleteStudentByEmail(domain, email);
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