package com.demoproject.DTO.University;


import org.springframework.web.multipart.MultipartFile;

import com.demoproject.Entity.DomainAdmin;
import com.demoproject.Entity.University;

import lombok.Data;

// lombok auto create getter, setter ,constructor,..etc 
@Data
public class UniversityDomainAdminDTO {

    private University university;

    private DomainAdmin domainAdmin;

    // private MultipartFile logo;  
    
    // // getters & setters
    // public University getUniversity() {
    //     return university;
    // }

    // public void setUniversity(University university) {
    //     this.university = university;
    // }

    // public DomainAdmin getDomainAdmin() {
    //     return domainAdmin;
    // }

    // public void setDomainAdmin(DomainAdmin domainAdmin) {
    //     this.domainAdmin = domainAdmin;
    // }
}

