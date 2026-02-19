package com.demoproject.DTO.StudentDTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDTO {
   
    private String name;
    private String rollNumber;
    private String email;
    private String password;
    private String mobileNumber;
    private String fatherName;
    private String fatherMobNo;
    private String course;
    private String branch;
    private String batch;
    private LocalDateTime createdDateTime;
    private LocalDateTime lastLoginDateTime; // For login purposes
    private String profilePhotoPath; // store image path OR base64


}

