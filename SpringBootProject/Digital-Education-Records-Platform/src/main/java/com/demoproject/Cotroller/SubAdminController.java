package com.demoproject.Cotroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.DTO.FacultyDTO.FacultyResponseDTO;
import com.demoproject.DTO.StudentDTO.StudentResponseDTO;
import com.demoproject.DTO.SubAdminDTO.SubAdminSignupDTO;
import com.demoproject.Entity.Faculty;
import com.demoproject.Entity.Student;
import com.demoproject.Entity.SubAdmin;
import com.demoproject.Service.SubAdminService;
import com.demoproject.Service.UniversityService;


@RestController
@RequestMapping("/{domain}/subAdmin")
@PreAuthorize("""
        hasRole('SUB_ADMIN') and
        #domain.equalsIgnoreCase(authentication.principal.domain)
        """)
public class SubAdminController {

    @Autowired
    private SubAdminService sAService;
    @Autowired
    private UniversityService universityService;


//     public ResponseEntity<?> test(@PathVariable String domain) {
//         try {
//             return ResponseEntity.ok(universityService.getUniversityName_Logo(domain) + ". \nSUB_ADMIN Access OK\n For dAdmin, sAdmin,...");
//         } catch (Exception e) {
//             return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
//         }
//   }

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
            sAService.getSubAdminByEmailAndDomain(email, domain)
        );
    }


    // CREATE
    @PostMapping("/add")
    public ResponseEntity<?> add(@PathVariable String domain, @RequestBody SubAdminSignupDTO subAdmin) {
       try {
        String save = sAService.addSubAdmin(domain, subAdmin);
        return new ResponseEntity<>(save,HttpStatus.CREATED);
        
    } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }    
    }

    // Update Password or Forget Password
    @PutMapping("/forgot_update_password")
    public ResponseEntity<?> updateStudentPassword(@PathVariable String domain, @RequestParam String email, @RequestParam String newpass){
        try {

            boolean save = sAService.updatePasswordByEmail(domain, email, newpass);
            return new ResponseEntity<>(save + " Password change successfully \n",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    // UPDATE Domain + DomainId means (DId which provide by University or collage)
    @PutMapping("/update_profile")
    public SubAdmin  updateSubAdminByDomainId(@PathVariable String domain, @RequestBody SubAdmin subAdmin) {
        return sAService. updateSubAdminBySubAdminId(domain, subAdmin);
    }

    // DELETE
    @DeleteMapping("/delete_profile")
    public String deleteSubAdminByDomainId(@PathVariable String domain, @RequestBody String subAdminId) {
        return sAService.deleteSubAdminBySubAdminId(domain, subAdminId);
    }



// ------ READ ALL faculty for specific university ------
    @GetMapping("/all_faculty")
    public List<FacultyResponseDTO> getAllFaculty(@PathVariable String domain) {
        return sAService.getFacultyAll(domain);
    }
   
    //  READ ONE by domain + SubAdminId means (Id which provide by University or collage)
    @GetMapping("/faculty_by_facultyId")
    public Faculty getFacultyBySubAdminId(@PathVariable String domain, @PathVariable String facultyId) {
        return sAService.getFacultyByFacultyId(domain, facultyId);
    }





    // ------ READ ALL student for specific university ------
    @GetMapping("/all_student")
    public List<StudentResponseDTO> getAllStudents(@PathVariable String domain) {
        return sAService.getAllStudents(domain);
    }
    
    // get or READ ONE by domain + rollNo
    @GetMapping("/student_by_rollno")
    public Student getStudentByRollNo(@PathVariable String domain, @RequestParam String rollNo) {
        return sAService.getStudentByRollNo(domain, rollNo);
    }

    // ------ READ All by domain + Name ------
    @GetMapping("/student_by_name")
    public List<Student> getStudentByName(@PathVariable String domain, @RequestParam String name) {
        return sAService.getStudentByName(domain, name);
    }

    // READ by domain + Branch
    @GetMapping("/student_by_branch")
    public List<Student> getAllStudentByBranch(@PathVariable String domain, @RequestParam String branch) {
        return sAService.getStudentByBranch(domain, branch);
    }

    // ------ READ All by domain + Course ------
    @GetMapping("/student_by_course")
    public List<Student> getAllStudentByCourse(@PathVariable String domain, @RequestParam String course) {
        return sAService.getStudentByCourse(domain, course);
    }

     // ------ READ All by domain + Batch ------
    @GetMapping("/student_by_batch")
    public List<Student> getAllStudentByBatch(@PathVariable String domain, @RequestParam String batch) {
        return sAService.getStudentByBatch(domain, batch);
    }
   



}