package com.demoproject.DTO.SubAdminDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubAdminSignupDTO {
    private String name;
    private String mobileNumber;
    private String email;
    private String password; // Used for registration

    private String subAdminId;
    private String course;
    
}

