package com.demoproject.Service.Home;

import java.util.List;

import com.demoproject.Repository.DomainAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoproject.Entity.DomainAdmin;
import com.demoproject.Entity.Role;
import com.demoproject.Entity.Home.University;
import com.demoproject.Repository.Home.UniversityRepo;
import com.demoproject.Service.DomainAdminService;

import jakarta.transaction.Transactional;


@Service
public class UniversityService {


    @Autowired
    private UniversityRepo universityRepo;
    @Autowired
    private DomainAdminService dAdminService;
    @Autowired
    private DomainAdminRepository dAdminRepo;

    //here first fill all university details And Second Admin (means DomainAdmin) details
    // both details filled then submit and save both information in bd or create 
    // Admin's Details (who handle the owen university) --> DomainAdmin

    // CREATE 
        // ✔ University saved
        // ✔ ID auto-generated
        // ✔ DomainAdmin auto-saved
        // ✔ university_id auto-filled
        // ✔ ONE DB TRANSACTION
    @Transactional
    public String registerUniversityWithDomainAdmin(University university, DomainAdmin domainAdmin){
        try {
            // * if... use because id of university and domainAdmin same and also first check both are unique then create both
            if(universityRepo.existsByDomain(university.getDomain())){   return " university's domain field exists \nEnter Unique domain";   }
            if(universityRepo.existsByPermanentId(university.getPermanentId())){   return "You Entered Wrong PermanentId. \nEntere Correct PermanentId ";   }
            if(universityRepo.existsByEmail(university.getEmail())){   return " university's Email field exists \nEnter Unique Email Id or Another Email Id";   }
            if(universityRepo.existsByMobileNumber(university.getMobileNumber())){   return " university's MobileNumber field exists ";   }
            
            if(dAdminRepo.existsByMobileNumber(domainAdmin.getMobileNumber())){   return "Domain Admin's MobileNumber field exists";   }
            if(dAdminRepo.existsByEmail(domainAdmin.getEmail())){   return "Domain Admin's Email field exists";   }

            // set relationship (BOTH SIDES)
            domainAdmin.setUniversity(university);
            domainAdmin.setRole(Role.DOMAIN_ADMIN);
            domainAdmin.setDomain(university.getDomain());
            university.setDomainAdmin(domainAdmin);

            University saved = universityRepo.save(university);
            return "University created with ID: " + saved.getId() + "\ndomain : " + saved.getDomain() + "\nDomainAdmin ID: " + saved.getDomainAdmin().getId();
            
        } 
        catch (Exception e) {  return e.getMessage();  }
    }


    // @Transactional
    // public String addUniversityAndDomainAdmin(University univ, DomainAdmin dAdmin){
    //     try {
    //         // * if-if use because id of university and dAdmin same and also first check both are unique then create both
    //         if(!(universityRepo.existsByDomain(univ.getDomain()) && universityRepo.existsByPermanentId(univ.getPermanentId())) && !(universityRepo.existsByGmail(univ.getGmail()) && universityRepo.existsByMobileNumber(univ.getMobileNumber())))
    //         {
    //             if (!dAdminRepo.existsByMobileNumber(dAdmin.getMobileNumber()) && !dAdminRepo.existsByGmail(dAdmin.getGmail())) {

    //                 University addUniversity = universityRepo.save(univ);

    //                 // add DomainAdmin  method 1
    //                 String domain = addUniversity.getDomain();
    //                 // Long univId =  addUniversity.getId();
    //                 DomainAdmin addDAdmin = dAdminService.addDomainAdmin(domain, dAdmin);
                   
    //                 //  method 2
    //                 // dAdmin.setDomain(addUniversity.getDomain());
    //                 // dAdmin.setUniversity(univ.getId());
    //                 // DomainAdmin addDAdmin = dAdminRepo.save(dAdmin);
    //                 //Mapping OneToOne
    //                 // univ.setDomainAdmin(addDAdmin);
    //                 // addUniversity = universityRepo.save(univ);

    //                 return "Successfully create with id : "+ addUniversity.getId() + "\nDomain : " + addUniversity.getDomain() + "\nGmail : " + addUniversity.getGmail() + "\nMobile Number : " + addUniversity.getMobileNumber() + "\nInstitution Name : " + addUniversity.getInstitutionName() + "\nUniversity Name : " + addUniversity.getUniversityName() + "\n----- Domain Admin ( Admin ) -----\n" + "\nDomain Id : " + addDAdmin.getId() + "\nDomain Admin Name : " + addDAdmin.getName() + "\nGmail : " + addDAdmin.getGmail() + "\nMobile Number : " + addDAdmin.getMobileNumber() + "\nPassword : " + addDAdmin.getPassword();
    //             }
    //             else{
    //                 return "dAdmin field exists";
    //             }
    //         }
    //         else{
    //             return "university field exists";
    //         }
    //     } catch (Exception e) {
    //         return e.getMessage();
    //     }
    // }

// **** these all are for official use only no others  ***** 
    // READ ALL
    public List<University> getAll(){
        return universityRepo.findAll();
    }

    // Get By Id  // This will match /123 (numeric id)
    public University getById(Long id){
        return universityRepo.findById(id).orElse(null);
    }

    // Get By Domain   This will match /hu, /dtu, /aku etc.
    public University getByDomain(String domain) {
        return universityRepo.findByDomain(domain);
    }
    
    // UPDATE id and domain
    public University updateUniversity(String domain, Long id,University univ){
        University old = universityRepo.findByDomainAndId(domain,id);
        old.setUniversityName(univ.getUniversityName());
        return universityRepo.save(old);
    }
    
    // delete by id and domain
    public String deleteUniversity(Long id, String domain){
        universityRepo.deleteByIdAndDomain(id,domain);
        return "University deleted successfully with id " + id + "And domain " + domain;
    }


    
}
