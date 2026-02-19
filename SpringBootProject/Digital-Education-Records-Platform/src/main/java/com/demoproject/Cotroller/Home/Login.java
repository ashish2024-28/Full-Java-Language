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
import com.demoproject.DTO.LoginRequestDTO;
import com.demoproject.DTO.LoginResponseDTO;
import com.demoproject.DTO.University.UniversityName_LogoDTO;
import com.demoproject.Service.BaseUserService;

import com.demoproject.Service.UniversityService;

@RestController
@RequestMapping("/{domain}/login_profile")
public class Login {
    
    
    @Autowired
    private UniversityService universityService;
    @Autowired
    private BaseUserService baseUserService;



    @GetMapping
    public ResponseEntity<?> LonginPage(@PathVariable String domain){
    try{
        UniversityName_LogoDTO dto = universityService.getUniversityName_Logo(domain);
                        
        return ResponseEntity.ok( dto );
    } catch (Exception e) {
          return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}


    // process of jwt start(Security.java) step(2.) go to userLogin method -> BaseUserService

    // any user(DomainAdmin,SubAdmin,Faculty,Student) Login by domain + Email + Password

    // working first need email(username) & password and call userLogin method -> BaseUserService
    // @GetMapping("/user_login")
    @PostMapping("/user_login")
    public ResponseEntity<?> userLogin(@PathVariable String domain,
         @RequestBody LoginRequestDTO loginRequest){
        try {

            loginRequest.setDomain(domain);
            LoginResponseDTO response = baseUserService.userLogin(loginRequest);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        // in case of csrf disable 
        // .csrf(csrf -> csrf.disable()) // not use this one becuse csrf provide security which no any one hit apis except get
        // if domain are diff or change => Invalid domain or email
        // otherwise return token
    }

    //------------------------------------------------------------------------------------
    // Student Login by domain + Email + Password
    // @PostMapping("/student_login")
    // public ResponseEntity<?> studentLogin(@PathVariable String domain, @RequestBody LoginRequest loginRequest){
    //     try {

    //         String student = studentService.LoginStudent(domain, loginRequest.getEmail(), loginRequest.getPassword());
    //         return new ResponseEntity<>(student,HttpStatus.OK);

    //     } catch (Exception e) {
    //         return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    //     }
    // }
    // @PostMapping("/student_login")
    // public ResponseEntity<?> studentLogin(@PathVariable String domain, @RequestBody LoginRequestDTO loginRequestDTO){
    //     try {
    //         loginRequestDTO.setDomain(domain);
    //         Student student = studentService.LoginStudent(loginRequestDTO);
    //         return new ResponseEntity<>(student,HttpStatus.OK);

    //     } catch (Exception e) {
    //         return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    //     }
    // }
    // // First big mistake: GET + @RequestBody ❌ => ❌ Never use @RequestBody with @GetMapping
    // // GET requests do NOT have a body (by HTTP standard)
    // // @GetMapping("/student_login")
    // // // public ResponseEntity<?> studentLogin(@PathVariable String domain, @RequestParam String email , @RequestParam String password){
    // // public ResponseEntity<?> studentLogin(@PathVariable String domain, @RequestBody BaseUser baseUser){
    //     //     try {

    // //         // Student student = studentService.LoginStudent(domain, email, password);
    // //         Student student = studentService.LoginStudent(domain, baseUser.getEmail(), baseUser.getPassword());
    // //         return new ResponseEntity<>(student,HttpStatus.OK);
    
    // //     } catch (Exception e) {
    // //         return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    // //     }
    // // }

    // // Faculty Login by domain + Email + Password 
    // @PostMapping("/faculty_login")
    // public ResponseEntity<?> facultyLogin(@PathVariable String domain, @RequestBody LoginRequestDTO loginRequestDTO){
    //     try {
            
    //         loginRequestDTO.setDomain(domain);
    //         // Faculty faculty = facultyService.LoginFaculty(domain, email, password);
    //         Faculty faculty = facultyService.LoginFaculty(loginRequestDTO);
    //         return new ResponseEntity<>(faculty,HttpStatus.OK);
            
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    //     }
    // }
    
    // // SubAdmin Login by domain + Email + Password
    // @PostMapping("/subAdmin_login")
    // public ResponseEntity<?> subAdminLogin(@PathVariable String domain, @RequestBody LoginRequestDTO loginRequestDTO){
    //     try {
            
    //         loginRequestDTO.setDomain(domain);
    //         // SubAdmin subAdmin = subAdminService.LoginSubAdmin(domain, email, password);
    //         SubAdmin subAdmin = subAdminService.LoginSubAdmin(loginRequestDTO);
    //         return new ResponseEntity<>(subAdmin,HttpStatus.OK);
            
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    //     }
    // }

    
    // // DomainAdmin Login by domain + Gmail + Password
    // @PostMapping("/dAdmin_login")
    // public ResponseEntity<?> domainAdminLogin(@PathVariable String domain, @RequestBody LoginRequestDTO loginRequestDTO ){
    //     try {
            
    //         loginRequestDTO.setDomain(domain);
    //         // DomainAdmin dAdmin = dAdminService.LoginDomainAdmin(domain, email, password);
    //         DomainAdmin dAdmin = dAdminService.LoginDomainAdmin(loginRequestDTO);
    //         return new ResponseEntity<>(dAdmin,HttpStatus.OK);
            
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    //     }
    // }
}
