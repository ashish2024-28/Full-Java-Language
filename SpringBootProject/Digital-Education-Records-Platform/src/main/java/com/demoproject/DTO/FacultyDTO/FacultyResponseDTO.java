package com.demoproject.DTO.FacultyDTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacultyResponseDTO {
    // Fields from BaseUser
    private String name;
    private String email;
    private String password;
    private String mobileNumber;

    private LocalDateTime createdDateTime;
    private LocalDateTime lastLoginDateTime;
    // Fields specific to Faculty
    private String facultyId;
    private String course;
    private String teachingBatch;
    private String profilePhotoPath;
}