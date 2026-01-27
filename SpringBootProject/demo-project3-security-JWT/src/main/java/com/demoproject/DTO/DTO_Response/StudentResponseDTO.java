package com.demoproject.DTO.DTO_Response;

import lombok.Data;

@Data
public class StudentResponseDTO {
   
    private String name;
    private String rollNumber;
    private String course;
    private String branch;
    private String batch;
    private String email;
    private String mobileNumber;
    private String fatherName;
    private String fatherMobNo;

    // 👇 University reference only
    private String universityName;

}

