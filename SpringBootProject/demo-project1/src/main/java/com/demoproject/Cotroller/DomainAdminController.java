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

import com.demoproject.Entity.DomainAdmin;
import com.demoproject.Entity.Faculty;
import com.demoproject.Entity.Student;
import com.demoproject.Entity.SubAdmin;
import com.demoproject.Service.DomainAdminService;

@RestController
@RequestMapping("/{domain}/domainAdmin")
public class DomainAdminController {

    @Autowired
    private DomainAdminService domainAdminService;


    


// ********** (self) DomainAdmin operations **********
    // only one Domain admin which created with university created   


    @GetMapping("all")
    public DomainAdmin getAllDomainAdmin(@PathVariable String domain){
        return domainAdminService.getDomainAdmin(domain);
    }

    // Update Password or Forget Password
    @PutMapping("/forgot-password/update-password")
    public ResponseEntity<?> updateStudentPassword(@PathVariable String domain, @RequestParam String email, @RequestParam String newpass){
        try {

            boolean save = domainAdminService.updatePasswordByEmail(domain, email, newpass);
            return new ResponseEntity<>(save + " Password change successfully \n",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


// ===== STUDENT CRUD =====

    // ---- Add Student ------
    @PostMapping("/student/add")
    public ResponseEntity<?> addStudent(@PathVariable String domain, @RequestBody Student s) {
       try {
        String save = domainAdminService.addStudent(domain, s);
        return new ResponseEntity<>(save,HttpStatus.CREATED);
        
    } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);  
       }    
    }

    // ------ READ ALL student for specific university ------
    @GetMapping("/student/all")
    public List<Student> getAllStudents(@PathVariable String domain) {
        return domainAdminService.getAllStudents(domain);
    }
    
    // READ ONE by domain + rollNo
    @GetMapping("/student/rollno")
    public Student getStudentByRollNo(@PathVariable String domain, @RequestParam String rollNo) {
        return domainAdminService.getStudentByRollNo(domain, rollNo);
    }

    // ------ READ ONE by domain + Gmail ------
    @GetMapping("/student/email")
    public Student getStudentByEmail(@PathVariable String domain, @RequestParam String email) {
        return domainAdminService.getStudentByEmail(email ,domain);
    }

    // ------ READ All by domain + Name ------
    @GetMapping("/student/name")
    public List<Student> getAllStudentByName(@PathVariable String domain, @RequestParam String name) {
        return domainAdminService.getAllStudentByName(domain, name);
    }

    // READ by domain + Branch
    @GetMapping("/student/branch")
    public List<Student> getAllStudentByBranch(@PathVariable String domain, @RequestParam String branch) {
        return domainAdminService.getAllStudentByBranch(domain, branch);
    }

    // ------ READ All by domain + Course ------
    @GetMapping("/student/course")
    public List<Student> getAllStudentByCourse(@PathVariable String domain, @RequestParam String course) {
        return domainAdminService.getAllStudentByCourse(domain, course);
    }

    // ------ READ All by domain + Batch ------
    @GetMapping("/student/batch")
    public List<Student> getAllStudentByBatch(@PathVariable String domain, @RequestParam String batch) {
        return domainAdminService.getStudentByBatch(domain, batch);
    }
 

    // ------ UPDATE  by email ------
    @PutMapping("/student/update-by/email")
    public Boolean updateStudentByEmail(@PathVariable String domain,  @RequestBody Student s) {
        return domainAdminService.updateStudentByEmail(domain, s);
    }

    // DELETE By RollNo
    @DeleteMapping("/student/delete-by/email")
    public String deleteByEmail(@PathVariable String domain, @RequestParam String email) {
        return domainAdminService.deleteStudentByEmail(domain, email);
    }


// ===== FACULTY CRUD =====

    // ---- CREATE ------
    @PostMapping("/faculty/add")
    public ResponseEntity<?> addFaculty(@PathVariable String domain, @RequestBody Faculty f) {
       try {
        String save = domainAdminService.addFaculty(domain, f);
        return new ResponseEntity<>(save,HttpStatus.CREATED);
        
    } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }    
    }

    // ------ READ ALL faculty for specific university ------
    @GetMapping("/faculty/all")
    public List<Faculty> getAllFaculty(@PathVariable String domain) {
        return domainAdminService.getAllFaculty(domain);
    }
   
    //  READ ONE by domain + facultyId means (Id which provide by University or collage)
    @GetMapping("/faculty/facultyId")
    public Faculty getFacultyByFacultyId(@PathVariable String domain, @RequestParam String facultyId) {
        return domainAdminService.getFacultyByFacultyId(domain, facultyId);
    }

    //  READ ONE by domain + gmail
    @GetMapping("/faculty/gmail")
    public ResponseEntity<?> getByGamil(@PathVariable String domain, @RequestParam String gmail) {
        try {
            Faculty get = domainAdminService.getFacultyByGmail(domain, gmail);
            return new ResponseEntity<>(get,HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    // ------ UPDATE by FacultyId(FacultyId) means (Id which provide by University or collage) ------
    @PutMapping("/faculty/update-by/facultyId")
    public Boolean updateFacultyByFacultyId(@PathVariable String domain, @RequestBody Faculty f) {
        return domainAdminService.updateFacultyByFacultyId(domain, f);
    }

    // ------ DELETE by facultyId ------
    @DeleteMapping("/faculty/delete-by/facultyId")
    public String deleteFacultyByDId(@PathVariable String domain, @RequestParam String facultyId) {
        return domainAdminService.deleteFacultyByFacultyId(domain, facultyId);
    }


    // ===== SUBADMIN CRUD =====

    // CREATE
    @PostMapping("/subadmin/add")
    public ResponseEntity<?> addSubAdmin(@PathVariable String domain, @RequestBody SubAdmin subAdmin) {
       try {
        String save = domainAdminService.addSubAdmin(domain, subAdmin);
        return new ResponseEntity<>(save,HttpStatus.CREATED);
        
    } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        
       }    
    }

    // READ ALL subadmin by domain
    @GetMapping("/subadmin/all")
    public List<SubAdmin> getAllSubAdmin(@PathVariable String domain) {
        return domainAdminService.getAllSubAdmin(domain);
    }

    //  READ ONE by domain + DomainId means (Id which provide by University or collage)
    @GetMapping("/subadmin/subadminId")
    public SubAdmin getSubAdminBySubAdminId(@PathVariable String domain, @PathVariable String subAdminId) {
        return domainAdminService.getSubAdminBySubAdminId(domain, subAdminId);
    }
    // UPDATE
    @PutMapping("/subadmin/update-by/subadminId")
    public SubAdmin updateSubAdminBySubAdminId(@PathVariable String domain, @RequestBody SubAdmin s) {
        return domainAdminService.updateSubAdminBySubAdminId(domain, s);
    }

    // DELETE
    @DeleteMapping("/subadmin/delete-by/subadminId")
    public String deleteSubAdminBySubAdminId(@PathVariable String domain, @RequestParam String subAdminId) {
        return domainAdminService.deleteSubAdminBySubAdminId(domain, subAdminId);
    }
}
