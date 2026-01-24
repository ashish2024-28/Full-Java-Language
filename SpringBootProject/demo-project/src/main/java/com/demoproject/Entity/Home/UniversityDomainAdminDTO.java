package com.demoproject.Entity.Home;


import com.demoproject.Entity.DomainAdmin;

import lombok.Data;

// lombok auto create getter, setter ,constructor,..etc 
@Data
public class UniversityDomainAdminDTO {

    private University university;

    private DomainAdmin domainAdmin;

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

