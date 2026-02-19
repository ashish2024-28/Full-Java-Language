package com.demoproject.Entity;

import java.util.List;

import com.demoproject.Entity.ProfileInformation.Common.Notepad;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name = "sub_admin",
uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
public class SubAdmin extends BaseUser {
    
    // @Column(nullable = false)
    // private String domain;

    // @Column(nullable = false)
    // private String mobileNumber; //Country code +91

    // @Column(nullable = false)
    // private String name;

    // subAdminId  means (Id which provide by University or collage)
    //unique domain wise
    @Column(nullable = false)
    private String subAdminId;

    private String course;

    // for this use configration extend WebMvcConfigurer
    private String profilePhotoPath; // Stores "alex_profile.png"

   
 
    @ManyToOne
    @JoinColumn(name = "university_id")
    // @JsonBackReference
    @JsonIgnore
    private University university;

   
}
