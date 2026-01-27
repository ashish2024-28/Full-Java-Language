package com.demoproject.DTO.DTO_Response;

import lombok.Data;

@Data
public class UniversityResponseDTO {
    private Long id;
    private String domain;
    private String institutionName;
    private String universityName;
    private String institutionType;
    private String establishmentYear;
    private String state;
    private String email;
    private String mobileNumber;
}
