package com.example.otpservice;

import java.util.HashMap;
import java.util.Map;

// for generating random number
// import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

// Makes this class as a Spring "service" component or Spring-managed service
@Service
public class OtpService {


    // Spring automatically injects JavaMailSender here or Spring give us an object of JavaMailSender
    @Autowired
    private JavaMailSender mailSender;

    // ✅ Class to hold OTP + time
    private static class OtpData {
        String otp;
        long timestamp;

        OtpData(String otp, long timestamp) {
            this.otp = otp;
            this.timestamp = timestamp;
        }
    }

    
     // ✅ Store email → OTP data
    private final Map<String, OtpData> otpStore = new HashMap<>();


    // Generate & send OTP to given email
    public void sendOtp(String userEmail) {
        // Generate 6-digit OTP
        String otp = String.valueOf((int) (Math.random() * 900000) + 100000);

        long now = System.currentTimeMillis();

        // Save OTP + time
        otpStore.put(userEmail, new OtpData(otp, now));

        // email message 
        SimpleMailMessage message = new SimpleMailMessage();
        // recipient email or Adds reciver's email address
        message.setTo(userEmail);
        // Adds email subject
        message.setSubject("Your OTP Code");
        // Adds email body text
        message.setText("Your One-Time Password (OTP) is: " + otp + "\nValid for 5 minutes.");
        // Actually sends the mail
        mailSender.send(message);
        System.out.println("OTP " + otp + " sent to " + userEmail);
    }

    // Verify OTP with expiry check
    public boolean verifyOtp(String email, String otp) {
        OtpData otpData = otpStore.get(email);

        if (otpData == null) return false;

        long now = System.currentTimeMillis();
        long diff = now - otpData.timestamp;

        // 10 min = 600000 ms
        if (diff > 600000) {
            otpStore.remove(email); // remove expired
            return false;
        }

        return otpData.otp.equals(otp);
    }
    
}
