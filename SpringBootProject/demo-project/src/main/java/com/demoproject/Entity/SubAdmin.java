package com.demoproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SubAdmin {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String branch;
    private Long mobNo;
    private String gmail;

    public SubAdmin(){}
    public SubAdmin(Long id, String name, String branch, Long mobNo, String gmail) {
        this.id = id;
        this.name = name;
        this.branch = branch;
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
