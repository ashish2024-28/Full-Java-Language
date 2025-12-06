package com.demoproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long rollNo;
    private String name;
    private String course;
    private String batch;
    private Long mobNo;
    private String gmail;

    // Default constructor (required)
    public Student() {}

    // Parameterized constructor
    public Student(Long rollNo, String name, String course, String batch, Long mobNo, String gmail) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.batch = batch;
        this.mobNo = mobNo;
        this.gmail = gmail;
    }

    // GETTERS + SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {  // REQUIRED for update
        this.id = id;
    }

    public Long getRollNo() {
        return rollNo;
    }

    public void setRollNo(Long rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Long getMobNo() {
        return mobNo;
    }

    public void setMobNo(Long mobNo) {
        this.mobNo = mobNo;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
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