package com.demoproject.DTO.DTO_Response;

import lombok.Data;

@Data
public class SubAdminResponseDTO {
    
    private String subAdminId;
    private String name;
    private String course;
    private String email;
    private String mobileNumber;
 
    // 👇 University reference only
    private String universityName;

}
