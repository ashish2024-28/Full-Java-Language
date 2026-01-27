package com.demoproject.Cotroller.Home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.DTO.UniversityDomainAdminDTO;
import com.demoproject.Service.UniversityService;

@RestController
@CrossOrigin // user to react both connect frotend and backend
// @CrossOrigin(origins = "http://localhost:300")
@RequestMapping("/home/university")
public class AddUniversity {
    
     @Autowired
    private UniversityService universityService;


    @GetMapping
    public String greet(){
        return "welcome to my digitalEducationRecord Platform \nAdd Universitiy and DomanAdmin ";
    }

    //here first fill all university details And Second Admin (means DomainAdmin) details
    // both details filled then submit and save both information in bd or create 
    // Admin's Details (who handle the owne university) --> DomainAdmin

    // CREATE
    @PostMapping("/add-univ-&-dadmin")
    public ResponseEntity<?> add(@RequestBody UniversityDomainAdminDTO dto){
        try {

            String save = universityService.registerUniversityWithDomainAdmin(
                dto.getUniversity(),
                dto.getDomainAdmin()
            );
            return new ResponseEntity<>(save,HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() ,HttpStatus.BAD_REQUEST);
        }

    }
    


}
