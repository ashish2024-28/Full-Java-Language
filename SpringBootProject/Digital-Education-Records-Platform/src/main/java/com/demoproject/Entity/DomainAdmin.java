package com.demoproject.Entity;



import java.util.List;

import com.demoproject.Entity.ProfileInformation.Common.Notepad;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="domain_admin",
uniqueConstraints = { 
    @UniqueConstraint(columnNames = "email"),
    @UniqueConstraint(columnNames = "mobilenumber")
})
@Data
public class DomainAdmin extends BaseUser {

    // @Column(nullable = false)
    // private String domain;

    // @Column(nullable = false)
    // private String name;
    
    // @Column(nullable = false)
    // private String mobileNumber;


    

    @OneToOne
    @JoinColumn(name = "university_id", nullable = false)
    // @JsonBackReference
    @JsonIgnore
    private University university;
  

    

}
