package com.example.otpservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
// Marks class as RESTController or Tells Spring this class handles web request
@RestController
// All URLs start with /otp or Base path for APIs
@RequestMapping("/otp")
public class OtpController {

    // injects out OtpService class
    @Autowired
    // use out OtpService
    private OtpService otpService;

    //API Endpoint: /otp/send?emal=example@gmail.com@PostMapping("/send") or Defines POST API endpoint 
    // @PostMapping("/send")
    // @GetMapping("/send")

    // ✅ Send OTP
    @RequestMapping(value = "/send", method = {RequestMethod.GET, RequestMethod.POST})

    // @RequestParam String email => Gets email from the request
    public String sendOtp(@RequestParam String email) {
        // Calls service to send Otp email
        otpService.sendOtp(email);
        return "OTP sent successfully to " + email;
    }


    // ✅ Verify OTP
    @RequestMapping(value = "/verify", method = {RequestMethod.GET, RequestMethod.POST})
    public String verifyOtp(@RequestParam String email, @RequestParam String otp) {
        boolean isValid = otpService.verifyOtp(email, otp);
        if (isValid) {
            return "✅ OTP verified successfully!";
        } else {
            return "❌ Invalid or expired OTP!";
        }
    }

}
