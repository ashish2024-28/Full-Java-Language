package com.demoproject.DTO.StudentDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentSignupDTO {

    private String name;
    private String email;
    private String password;
    private String mobileNumber; //Country code +91

    private String rollNumber;
    private String course;
    private String branch;
    private String batch;

    private String fatherName;
    private String fatherMobNo;
}
