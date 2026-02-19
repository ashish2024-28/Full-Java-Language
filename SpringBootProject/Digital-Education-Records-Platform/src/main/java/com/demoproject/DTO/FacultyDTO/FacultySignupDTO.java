package com.demoproject.DTO.FacultyDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacultySignupDTO {
    private String name;
    private String email;
    private String password; // Used for registration
    private String mobileNumber;
    
    private String facultyId;
    private String course;
    private String teachingBatch;
}
