package com.demoproject.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import com.demoproject.Repository.DomainAdminRepository;
import com.demoproject.Repository.UniversityRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demoproject.Entity.Role;
import com.demoproject.Entity.University;
import com.demoproject.DTO.University.UniversityName_LogoDTO;
import com.demoproject.Entity.DomainAdmin;

import jakarta.transaction.Transactional;


@Service
public class UniversityService {


    @Autowired
    private UniversityRepo universityRepo;
    @Autowired
    private DomainAdminRepository dAdminRepo;
    @Autowired
    @Qualifier("bcryptEncoder")
    private PasswordEncoder passwordEncoder;

    
    @Transactional
    public String registerUniversityWithDomainAdmin(University university, DomainAdmin domainAdmin){
    // public String registerUniversityWithDomainAdmin(University university, DomainAdmin domainAdmin , MultipartFile logoFile){
        try {
            // * if... use because id of university and domainAdmin same and also first check both are unique then create both
            if(universityRepo.existsByDomain(university.getDomain())){   return " university's domain field exists \nEnter Unique domain";   }
            if(universityRepo.existsByPermanentId(university.getPermanentId())){   return "You Entered Wrong PermanentId. \nEntere Correct PermanentId ";   }
            if(universityRepo.existsByEmail(university.getEmail())){   return " university's Email field exists \nEnter Unique Email Id or Another Email Id";   }
            if(universityRepo.existsByMobileNumber(university.getMobileNumber())){   return " university's MobileNumber field exists ";   }
            
            if(dAdminRepo.existsByMobileNumber(domainAdmin.getMobileNumber())){   return "Domain Admin's MobileNumber field exists";   }
            if(dAdminRepo.existsByEmail(domainAdmin.getEmail())){   return "Domain Admin's Email field exists";   }
            // for security use passwordEncoder
            domainAdmin.setPassword(passwordEncoder.encode(domainAdmin.getPassword()));
            
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

            
    // String uploadDir = "uploads/university/";

            // @Value("${file.upload-dir}")
            // private String uploadDir;

    // @Transactional
    // public String registerUniversityWithDomainAdmin(University university, DomainAdmin domainAdmin, MultipartFile logoFile){
    // // public String registerUniversityWithDomainAdmin(University university, DomainAdmin domainAdmin , MultipartFile logoFile){
    //     try {
    //         // * if... use because id of university and domainAdmin same and also first check both are unique then create both
    //         if(universityRepo.existsByDomain(university.getDomain())){   return " university's domain field exists \nEnter Unique domain";   }
    //         if(universityRepo.existsByPermanentId(university.getPermanentId())){   return "You Entered Wrong PermanentId. \nEntere Correct PermanentId ";   }
    //         if(universityRepo.existsByEmail(university.getEmail())){   return " university's Email field exists \nEnter Unique Email Id or Another Email Id";   }
    //         if(universityRepo.existsByMobileNumber(university.getMobileNumber())){   return " university's MobileNumber field exists ";   }
            
    //         if(dAdminRepo.existsByMobileNumber(domainAdmin.getMobileNumber())){   return "Domain Admin's MobileNumber field exists";   }
    //         if(dAdminRepo.existsByEmail(domainAdmin.getEmail())){   return "Domain Admin's Email field exists";   }

    //         // ========= SAVE IMAGE =========
            
    //         if (logoFile != null && !logoFile.isEmpty()) {

    //             String contentType = logoFile.getContentType();

    //             if (!contentType.equals("image/png") &&
    //                 !contentType.equals("image/jpeg")) {
    //                 throw new RuntimeException("Only PNG and JPEG allowed");
    //             }

    //             if (logoFile.getSize() > 2 * 1024 * 1024) {
    //                 throw new RuntimeException("File size must be under 2MB");
    //             }

    //             String extension = contentType.equals("image/png") ? ".png" : ".jpg";

    //             String fileName = university.getDomain().toLowerCase() + "_logo" + extension;

    //             Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();

    //             Files.createDirectories(uploadPath);

    //             Path targetLocation = uploadPath.resolve(fileName);

    //             Files.copy(
    //                 logoFile.getInputStream(),
    //                 targetLocation,
    //                 StandardCopyOption.REPLACE_EXISTING
    //             );

    //             university.setUniversityLogoPath(fileName);
    //         }


    //         // for security use passwordEncoder
    //         domainAdmin.setPassword(passwordEncoder.encode(domainAdmin.getPassword()));
            
    //         // set relationship (BOTH SIDES)
    //         domainAdmin.setUniversity(university);
    //         domainAdmin.setRole(Role.DOMAIN_ADMIN);
    //         domainAdmin.setDomain(university.getDomain());
    //         university.setDomainAdmin(domainAdmin);

    //         University saved = universityRepo.save(university);
    //         return "University created with ID: " + saved.getId() + "\ndomain : " + saved.getDomain() + "\nDomainAdmin ID: " + saved.getDomainAdmin().getId();
            
    //     } 
    //     catch (Exception e) {  return e.getMessage();  }
    // }



    public UniversityName_LogoDTO getUniversityName_Logo(String domain) throws Exception {

        University university = universityRepo.findByDomain(domain).orElseThrow(() -> new Exception("Invalid domain"));

        
        String name = Optional.ofNullable(university.getUniversityName())
                .filter(n -> !n.isBlank())
                .orElse(university.getInstitutionName());

        String logoUrl = ServletUriComponentsBuilder
            .fromCurrentContextPath()
            .path("/uploads/university/")
            .path(university.getUniversityLogoPath())
            .toUriString();

        return new UniversityName_LogoDTO(name, logoUrl);


        
    }






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
        return universityRepo.findByDomain(domain).orElse(null);
    }
    
    // UPDATE id and domain
    public University updateUniversity(String domain, Long id,University univ){
        University old = universityRepo.findByDomainAndId(domain,id).orElse(null);
        old.setUniversityName(univ.getUniversityName());
        return universityRepo.save(old);
    }
    
    // delete by id and domain
    public String deleteUniversity(Long id, String domain){
        universityRepo.deleteByIdAndDomain(id,domain);
        return "University deleted successfully with id " + id + "And domain " + domain;
    }


    
}
