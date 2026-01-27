package com.demoproject.DTO.DTO_Response;

import lombok.Data;

@Data
public class DomainAdminResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
    private String domain;

    // 👇 University reference only
    private String universityName;


}
