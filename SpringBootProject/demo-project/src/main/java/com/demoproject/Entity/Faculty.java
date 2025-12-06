package com.demoproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Faculty {
    
    @Id
    @GeneratedValue
    private Long id;
    // private Long rollNo;
    private String name;
    private String branch;
    private String course;
    private Long mobNo;
    private String gmail;

    public Faculty(){}
    public Faculty(Long id, String name, String branch, String course, Long mobNo, String gmail) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.course = course;
        this.mobNo = mobNo;
        this.gmail = gmail;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
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
