package com.demoproject.Cotroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.Entity.Faculty;
import com.demoproject.Entity.Student;
import com.demoproject.Entity.SubAdmin;
import com.demoproject.Service.SubAdminService;


@RestController
@RequestMapping("/{domain}/subadmin")
public class SubAdminController {

    @Autowired
    private SubAdminService sAService;


    // CREATE
    @PostMapping("/add")
    public ResponseEntity<?> add(@PathVariable String domain, @RequestBody SubAdmin subAdmin) {
       try {
        String save = sAService.addSubAdmin(domain, subAdmin);
        return new ResponseEntity<>(save,HttpStatus.CREATED);
        
    } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }    
    }

    // Update Password or Forget Password
    @PutMapping("/forgot-password/update-password")
    public ResponseEntity<?> updateStudentPassword(@PathVariable String domain, @RequestParam String email, @RequestParam String newpass){
        try {

            boolean save = sAService.updatePasswordByEmail(domain, email, newpass);
            return new ResponseEntity<>(save + " Password change successfully \n",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    // UPDATE Domain + DomainId means (DId which provide by University or collage)
    @PutMapping("/update-profile")
    public SubAdmin  updateSubAdminByDomainId(@PathVariable String domain, @RequestBody SubAdmin subAdmin) {
        return sAService. updateSubAdminBySubAdminId(domain, subAdmin);
    }

    // DELETE
    @DeleteMapping("/delete-profile")
    public String deleteSubAdminByDomainId(@PathVariable String domain, @RequestBody String subAdminId) {
        return sAService.deleteSubAdminBySubAdminId(domain, subAdminId);
    }



// ------ READ ALL faculty for specific university ------
    @GetMapping("/faculty/all")
    public List<Faculty> getAllFaculty(@PathVariable String domain) {
        return sAService.getFacultyAll(domain);
    }
   
    //  READ ONE by domain + SubAdminId means (Id which provide by University or collage)
    @GetMapping("/faculty-by/facultyId")
    public Faculty getFacultyBySubAdminId(@PathVariable String domain, @PathVariable String facultyId) {
        return sAService.getFacultyByFacultyId(domain, facultyId);
    }





    // ------ READ ALL student for specific university ------
    @GetMapping("/student/all")
    public List<Student> getAllStudents(@PathVariable String domain) {
        return sAService.getAllStudents(domain);
    }
    
    // get or READ ONE by domain + rollNo
    @GetMapping("/student-by/rollno")
    public Student getStudentByRollNo(@PathVariable String domain, @RequestParam String rollNo) {
        return sAService.getStudentByRollNo(domain, rollNo);
    }

    // ------ READ All by domain + Name ------
    @GetMapping("/student-by/name")
    public List<Student> getStudentByName(@PathVariable String domain, @RequestParam String name) {
        return sAService.getStudentByName(domain, name);
    }

    // READ by domain + Branch
    @GetMapping("/student-by/branch")
    public List<Student> getAllStudentByBranch(@PathVariable String domain, @RequestParam String branch) {
        return sAService.getStudentByBranch(domain, branch);
    }

    // ------ READ All by domain + Course ------
    @GetMapping("/student-by/course")
    public List<Student> getAllStudentByCourse(@PathVariable String domain, @RequestParam String course) {
        return sAService.getStudentByCourse(domain, course);
    }

     // ------ READ All by domain + Batch ------
    @GetMapping("/student-by/batch")
    public List<Student> getAllStudentByBatch(@PathVariable String domain, @RequestParam String batch) {
        return sAService.getStudentByBatch(domain, batch);
    }
   



}