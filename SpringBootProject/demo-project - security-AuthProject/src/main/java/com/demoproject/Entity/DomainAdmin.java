package com.demoproject.Entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    // @JsonBackReference
    @JsonIgnore
    private University university;
  
    


}
