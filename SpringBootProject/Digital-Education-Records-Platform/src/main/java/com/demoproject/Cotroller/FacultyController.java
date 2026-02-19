package com.demoproject.Cotroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.demoproject.DTO.FacultyDTO.FacultySignupDTO;
import com.demoproject.DTO.StudentDTO.StudentResponseDTO;
import com.demoproject.Entity.Faculty;
import com.demoproject.Entity.Student;
import com.demoproject.Service.FacultyService;
import com.demoproject.Service.UniversityService;


@RestController
@RequestMapping("/{domain}/faculty")

@PreAuthorize("""
        hasRole('FACULTY') and
        #domain.equalsIgnoreCase(authentication.principal.domain)
        """)
public class FacultyController {

    @Autowired
    private FacultyService fService;
    @Autowired
    private UniversityService universityService;

    
    // @GetMapping
    // public ResponseEntity<?> signUpPage(@PathVariable String domain){
    //      try{
    //         return  ResponseEntity.ok(universityService.getUniversityName_Logo(domain) +
    //          "FACULTY Access OK");
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    //     }
    // }

    @GetMapping
    public ResponseEntity<?> getFaculty(@PathVariable String domain) {
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
            fService.getFacultyByEmailAndDomain(email, domain)
        );
    }



    
    // ---- CREATE ------
    @PostMapping("/add")
    public ResponseEntity<?> addFaculty(@PathVariable String domain, @RequestBody FacultySignupDTO s) {
        try {
            String save = fService.addFaculty(domain, s);
            return new ResponseEntity<>(save,HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);    
        }
    }

    // Update Password or Forget Password
    @PutMapping("/update_faculty_password")
    public ResponseEntity<?> updateStudentPassword(@PathVariable String domain, @RequestParam String email, @RequestParam String newpass){
        try {

            boolean save = fService.updatePasswordByEmail(domain, email, newpass);
            return new ResponseEntity<>(save + " Password change successfully \n",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

        // ------ UPDATE by facultyid  ------
    @PutMapping("/update_faculty")
    public ResponseEntity<?> updateFacultyByDid(@PathVariable String domain, @RequestBody Faculty faculty) {
        try {
            boolean get = fService.updateFacultyByFacultyId(domain, faculty);
            return new ResponseEntity<>(get,HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        
    }

    // ------ DELETE by facultyid ------
    @DeleteMapping("/delete_faculty")
    public String deleteFacultyByDId(@PathVariable String domain, @PathVariable String facultyId) {
        return fService.deleteFacultyByFacultyId(domain, facultyId);
    }



    // ------ READ ALL student for specific university ------
    @GetMapping("/all_student")
    public List<StudentResponseDTO> getAllStudents(@PathVariable String domain) {
        return fService.getAllStudents(domain);
    }
    
    // get or READ ONE by domain + rollNo
    @GetMapping("/student_by_rollno")
    public Student getStudentByRollNo(@PathVariable String domain, @RequestParam String rollNo) {
        return fService.getStudentByRollNo(domain, rollNo);
    }

    // ------ READ All by domain + Name ------
    @GetMapping("/student_by_name")
    public List<Student> getStudentByName(@PathVariable String domain, @RequestParam String name) {
        return fService.getAllStudentByName(domain, name);
    }

    // READ by domain + Branch
    @GetMapping("/student_by_branch")
    public List<Student> getAllStudentByBranch(@PathVariable String domain, @RequestParam String branch) {
        return fService.getStudentByBranch(domain, branch);
    }

    // ------ READ All by domain + Course ------
    @GetMapping("/student_by_course")
    public List<Student> getAllStudentByCourse(@PathVariable String domain, @RequestParam String course) {
        return fService.getStudentByCourse(domain, course);
    }

    // ------ READ All by domain + Batch ------
    @GetMapping("/student_by_batch")
    public List<Student> getAllStudentByBatch(@PathVariable String domain, @RequestParam String batch) {
        return fService.getStudentByBatch(domain, batch);
    }

   
}






/*
@RestController → tells Spring this class contains API endpoints.

@RequestMapping("/student") → all APIs will start with /student.

@Autowired → Spring will automatically create the object of StudentService.

@PostMapping → handles HTTP POST request.

@RequestBody → converts JSON → Student object.a
*/


