package com.demoproject.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name = "students", 
uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
@Data
public class Student extends BaseUser {

    @Column(nullable = false)
    private String domain; // domain => university/collage ka unique name(like Haridwar University HU,hu,Hu)

    //unique domain wise
    @Column(nullable = false)
    private String rollNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String course;
    @Column(length = 50)
    private String branch;
    @Column(nullable = false)
    private String batch;

    @Column(nullable = false)
    private String mobileNumber;

    @Column(nullable = false)
    private String fatherName;
    @Column(nullable = false)
    private String fatherMobNo;

   

    @ManyToOne
    @JoinColumn(name = "university_id")
    // @JsonBackReference
    @JsonIgnore
    private University university;



    
}



// | Annotation        | Meaning                           |
// | ----------------- | --------------------------------- |
// | `@Entity`         | Class becomes a table in database |
// | `@Id`             | Primary key                       |
// | `@GeneratedValue` | Auto increment ID                 |

// When app runs, Spring auto-creates SQL table:/
// create table student (
//   id bigint auto_increment,
//   roll_no bigint,
//   name varchar(255),
//   course varchar(255),
//   batch varchar(255),
//   mob_no bigint,
//   gmail varchar(255)
// );


// spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
// spring.datasource.username=root
// spring.datasource.password=1234

// spring.jpa.hibernate.ddl-auto=update
// spring.jpa.show-sql=true


// ddl-auto=update → auto update table structure
// show-sql=true → shows SQL queries in console