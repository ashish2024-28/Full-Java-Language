package com.demoproject.DTO.DTO_Response;

import lombok.Data;

@Data
public class FacultyResponseDTO {
 
    private String name;
    private String facultyId;
    private String course;
    private String teachingBatch;
    private String email;
    private String mobileNumber;
   

    // 👇 University reference only
    private String universityName;

}
