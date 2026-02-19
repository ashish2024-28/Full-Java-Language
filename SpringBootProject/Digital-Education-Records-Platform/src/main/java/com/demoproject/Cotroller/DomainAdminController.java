package com.demoproject.Cotroller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.demoproject.DTO.FacultyDTO.FacultySignupDTO;
import com.demoproject.DTO.StudentDTO.StudentResponseDTO;
import com.demoproject.DTO.StudentDTO.StudentSignupDTO;
import com.demoproject.DTO.SubAdminDTO.SubAdminResponseDTO;
import com.demoproject.DTO.SubAdminDTO.SubAdminSignupDTO;
import com.demoproject.Entity.Faculty;
import com.demoproject.Entity.Student;
import com.demoproject.Entity.SubAdmin;
import com.demoproject.Service.DomainAdminService;
import com.demoproject.Service.UniversityService;

@RestController
@RequestMapping("/{domain}/domainAdmin")

@PreAuthorize("""
    hasRole('DOMAIN_ADMIN') and
    #domain.equalsIgnoreCase(authentication.principal.domain)
""")
public class DomainAdminController {

    @Autowired
    private DomainAdminService domainAdminService;
    @Autowired
    private UniversityService universityService;


    @GetMapping
    public ResponseEntity<?> getDomainAdmin(@PathVariable String domain) {
        try{
            String email = SecurityContextHolder.getContext().getAuthentication().getName();
            return ResponseEntity.ok(domainAdminService.getDomainAdminByEmailAndDomain(email, domain));

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get_dashboard")
    public ResponseEntity<?> getDashboard(@PathVariable String domain) {

        long totalstudent = domainAdminService.getStudentCount(domain);
        long totalfaculty = domainAdminService.getFacultyCount(domain);
        long totalsubAdmin = domainAdminService.getSubAdminCount(domain);

        Map<String, Long> response = new HashMap<>();
        response.put("students", totalstudent);
        response.put("faculty", totalfaculty);
        response.put("subAdmin", totalsubAdmin);

        return ResponseEntity.ok(response);
    }

     // Update Password or Forget Password
    @PutMapping("/forgot_update_password")
    // public ResponseEntity<?> updateStudentPassword(@PathVariable String domain, @RequestParam String email, @RequestParam String newPassword){
    public ResponseEntity<?> updateStudentPassword(@PathVariable String domain, @RequestParam String email, @RequestParam String newPassword){
        try {

            boolean save = domainAdminService.updatePasswordByEmail(domain, email, newPassword);
            return new ResponseEntity<>(save + " Password change successfully \n",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


// ===== STUDENT CRUD =====

    // ---- Add Student ------
    @PostMapping("/add_student")
    public ResponseEntity<?> addStudent(@PathVariable String domain, @RequestBody StudentSignupDTO s) {
       try {
        String save = domainAdminService.addStudent(domain, s);
        return new ResponseEntity<>(save,HttpStatus.CREATED);
        
    } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);  
       }    
    }

    // ------ READ ALL student for specific university ------
    @GetMapping("/all_student")
    public List<StudentResponseDTO> getAllStudents(@PathVariable String domain) {
        return domainAdminService.getAllStudents(domain);
    }
    
    // READ ONE by domain + rollNo
    @GetMapping("/student_by_rollno")
    public Student getStudentByRollNo(@PathVariable String domain, @RequestParam String rollNo) {
        return domainAdminService.getStudentByRollNo(domain, rollNo);
    }

    // ------ READ ONE by domain + Gmail ------
    @GetMapping("/student_by_email")
    public Student getStudentByEmail(@PathVariable String domain, @RequestParam String email) {
        return domainAdminService.getStudentByEmail(email ,domain);
    }

    // ------ READ All by domain + Name ------
    @GetMapping("/student_by_name")
    public List<Student> getAllStudentByName(@PathVariable String domain, @RequestParam String name) {
        return domainAdminService.getAllStudentByName(domain, name);
    }

    // READ by domain + Branch
    @GetMapping("/student_by_branch")
    public List<Student> getAllStudentByBranch(@PathVariable String domain, @RequestParam String branch) {
        return domainAdminService.getAllStudentByBranch(domain, branch);
    }

    // ------ READ All by domain + Course ------
    @GetMapping("/student_by_course")
    public List<Student> getAllStudentByCourse(@PathVariable String domain, @RequestParam String course) {
        return domainAdminService.getAllStudentByCourse(domain, course);
    }

    // ------ READ All by domain + Batch ------
    @GetMapping("/student_by_batch")
    public List<Student> getAllStudentByBatch(@PathVariable String domain, @RequestParam String batch) {
        return domainAdminService.getStudentByBatch(domain, batch);
    }
 

    // ------ UPDATE  by email ------
    @PutMapping("/update_student_by_email")
    public Boolean updateStudentByEmail(@PathVariable String domain,  @RequestBody Student s) {
        return domainAdminService.updateStudentByEmail(domain, s);
    }

    // DELETE By RollNo
    @DeleteMapping("/delete_student_by_email")
    public String deleteByEmail(@PathVariable String domain, @RequestParam String email) {
        return domainAdminService.deleteStudentByEmail(domain, email);
    }


// ===== FACULTY CRUD =====

    // ---- CREATE ------
    @PostMapping("/add_faculty")
    public ResponseEntity<?> addFaculty(@PathVariable String domain, @RequestBody FacultySignupDTO f) {
       try {
        String save = domainAdminService.addFaculty(domain, f);
        return new ResponseEntity<>(save,HttpStatus.CREATED);
        
    } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }    
    }

    // ------ READ ALL faculty for specific university ------
    @GetMapping("/all_faculty")
    public List<FacultyResponseDTO> getAllFaculty(@PathVariable String domain) {
        return domainAdminService.getAllFaculty(domain);
    }
   
    //  READ ONE by domain + facultyId means (Id which provide by University or collage)
    @GetMapping("/faculty_by_facultyId")
    public Faculty getFacultyByFacultyId(@PathVariable String domain, @RequestParam String facultyId) {
        return domainAdminService.getFacultyByFacultyId(domain, facultyId);
    }

    //  READ ONE by domain + gmail
    @GetMapping("/faculty_by_gmail")
    public ResponseEntity<?> getByGamil(@PathVariable String domain, @RequestParam String gmail) {
        try {
            Faculty get = domainAdminService.getFacultyByGmail(domain, gmail);
            return new ResponseEntity<>(get,HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    // ------ UPDATE by FacultyId(FacultyId) means (Id which provide by University or collage) ------
    @PutMapping("/update_faculty_by_facultyId")
    public Boolean updateFacultyByFacultyId(@PathVariable String domain, @RequestBody Faculty f) {
        return domainAdminService.updateFacultyByFacultyId(domain, f);
    }

    // ------ DELETE by facultyId ------
    @DeleteMapping("/delete_faculty_by_facultyId")
    public String deleteFacultyByDId(@PathVariable String domain, @RequestParam String facultyId) {
        return domainAdminService.deleteFacultyByFacultyId(domain, facultyId);
    }


    // ===== SUBADMIN CRUD =====

    // CREATE
    @PostMapping("/add_subAdmin")
    public ResponseEntity<?> addSubAdmin(@PathVariable String domain, @RequestBody SubAdminSignupDTO subAdmin) {
       try {
        String save = domainAdminService.addSubAdmin(domain, subAdmin);
        return new ResponseEntity<>(save,HttpStatus.CREATED);
        
    } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        
       }    
    }

    // READ ALL subadmin by domain
    @GetMapping("/all_subadmin")
    public List<SubAdminResponseDTO> getAllSubAdmin(@PathVariable String domain) {
        return domainAdminService.getAllSubAdmin(domain);
    }

    //  READ ONE by domain + DomainId means (Id which provide by University or collage)
    @GetMapping("/subadmin_by_subadminId")
    public SubAdmin getSubAdminBySubAdminId(@PathVariable String domain, @PathVariable String subAdminId) {
        return domainAdminService.getSubAdminBySubAdminId(domain, subAdminId);
    }
    // UPDATE
    @PutMapping("/update_subadmin_by_subadminId")
    public SubAdmin updateSubAdminBySubAdminId(@PathVariable String domain, @RequestBody SubAdmin s) {
        return domainAdminService.updateSubAdminBySubAdminId(domain, s);
    }

    // DELETE
    @DeleteMapping("/delete_subadmin_by_subadminId")
    public String deleteSubAdminBySubAdminId(@PathVariable String domain, @RequestParam String subAdminId) {
        return domainAdminService.deleteSubAdminBySubAdminId(domain, subAdminId);
    }
}
