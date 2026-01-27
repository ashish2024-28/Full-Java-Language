package com.demoproject.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name = "faculty",
uniqueConstraints = @UniqueConstraint(columnNames = "gmail"))

@Data
public class Faculty extends BaseUser {

    // @Column(nullable = false)
    // private String domain;

    // @Column(nullable = false)
    // private String name;

    // @Column(nullable = false)
    // private String mobileNumber;

    // facultyId  means (Id which provide by University or collage)
    //unique domain wise
    @Column(nullable = false)
    private String facultyId;


    @Column(nullable = false)
    private String course;
    @Column(nullable = false)
    private String teachingBatch;






    @ManyToOne
    @JoinColumn(name = "university_id")
    // @JsonBackReference
    @JsonIgnore
    private University university;
   

}
