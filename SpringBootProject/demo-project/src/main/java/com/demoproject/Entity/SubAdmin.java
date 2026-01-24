package com.demoproject.Entity;

import com.demoproject.Entity.Home.University;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name = "sub_admin",
uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
public class SubAdmin extends BaseUser {
    
    @Column(nullable = false)
    private String domain;

    // subAdminId  means (Id which provide by University or collage)
    //unique domain wise
    @Column(nullable = false)
    private String subAdminId;

    @Column(nullable = false)
    private String name;
    private String course;

    @Column(nullable = false)
    private String mobileNumber; //Country code +91

   
 
    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;
    
}
