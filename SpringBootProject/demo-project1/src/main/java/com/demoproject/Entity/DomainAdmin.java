package com.demoproject.Entity;


import java.util.List;

import com.demoproject.Entity.Home.University;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="domain_admin",
uniqueConstraints = { 
    @UniqueConstraint(columnNames = "email"),
    @UniqueConstraint(columnNames = "mobile_number")
})
@Data
public class DomainAdmin extends BaseUser {

    @Column(nullable = false)
    private String domain;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String mobileNumber;

    

    @OneToOne
    @JoinColumn(name = "university_id", nullable = false)
    private University university;
  
    


}
