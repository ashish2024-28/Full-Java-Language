package com.demoproject.DTO;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String email;
    private String password;
    private String domain;
}
