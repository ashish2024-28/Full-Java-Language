package com.demoproject.DTO.SubAdminDTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubAdminResponseDTO {
   // Fields from BaseUser
    private String name;
    private String email;
    private String password;
    private String mobileNumber;

    // Fields specific to SubAdmin
    private String subAdminId;
    private String course;
    private LocalDateTime createdDateTime;
    private LocalDateTime lastLoginDateTime; // For login purposes
    private String profilePhotoPath; // store image path OR base64

}