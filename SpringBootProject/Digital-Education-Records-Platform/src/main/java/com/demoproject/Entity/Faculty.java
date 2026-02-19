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
@Table(name = "faculty",
uniqueConstraints = @UniqueConstraint(columnNames = "gmail"))

@Data
public class Faculty extends BaseUser {
    
    // facultyId  means (Id which provide by University or collage)
    //unique domain wise
    @Column(nullable = false)
    private String facultyId;


    @Column(nullable = false)
    private String course;
    @Column(nullable = false)
    private String teachingBatch;

    // for this use configration extend WebMvcConfigurer
    private String profilePhotoPath; // Stores "alex_profile.png"





    @ManyToOne
    @JoinColumn(name = "university_id")
    // @JsonBackReference
    @JsonIgnore
    private University university;
   

    


}
