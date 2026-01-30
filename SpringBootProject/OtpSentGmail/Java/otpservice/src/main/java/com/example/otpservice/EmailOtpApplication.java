package com.example.otpservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailOtpApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailOtpApplication.class, args);
        System.out.println("🚀 OTP Email Service started on http://localhost:8080");
    }
}
