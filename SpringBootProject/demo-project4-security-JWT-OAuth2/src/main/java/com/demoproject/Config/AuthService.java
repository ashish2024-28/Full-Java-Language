package com.demoproject.Config;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import com.demoproject.DTO.LoginRequestDTO;
import com.demoproject.DTO.SignupResponseDTO;
import com.demoproject.Entity.AuthProviderType;
import com.demoproject.Entity.BaseUser;
import com.demoproject.Entity.Role;
import com.demoproject.Entity.Student;
import com.demoproject.Repository.StudentRepository;
import com.demoproject.Service.BaseUserService;
import com.demoproject.Service.CustomUserDetailsService;
import com.demoproject.Service.JWTServie;
import com.demoproject.Service.StudentService;

import jakarta.transaction.Transactional;

@Component
public class AuthService {
    @Autowired private AuthUtil authUtil;
    @Autowired private BaseUserService baseUserService;
    @Autowired private StudentRepository studentRepository;
    @Autowired private JWTServie jwtServie;

    @Transactional
    public ResponseEntity<?> handleOAuth2LoginRequest(OAuth2User oAuth2User, String registrationId, String domainFromUrl) {
        AuthProviderType providerType = authUtil.getProviderTypeFromRegistrationId(registrationId);
        String providerId = authUtil.getProviderIdFromOAuth2User(oAuth2User, registrationId);
        String email = oAuth2User.getAttribute("email");

        // GitHub fallback: If email is private, use login name
    if (email == null || email.isBlank()) {
        email = oAuth2User.getAttribute("login") + "@github.com";
    }

        // 1. Check if user exists by Provider ID
        BaseUser user = baseUserService.findUserByProviderIdAndProviderType(providerId, providerType);

        if (user == null) {
            // 2. Check if user exists by Email (to link accounts)
            user = (BaseUser) studentRepository.findByEmail(email).orElse(null);

            if (user == null) {
                // 3. AUTO-SIGNUP: Create new Student
                Student newStudent = new Student();
                newStudent.setEmail(email);
                newStudent.setName(oAuth2User.getAttribute("name") != null ? oAuth2User.getAttribute("name") : oAuth2User.getAttribute("login"));
                newStudent.setRole(Role.STUDENT); // Default Role
                newStudent.setProviderType(providerType);
                newStudent.setProviderId(providerId);
                newStudent.setDomain(domainFromUrl); // Set domain from URL path
                newStudent.setCreatedDateTime(LocalDateTime.now());
                newStudent.setPassword("OAUTH_USER"); // Placeholder
                
                user = studentRepository.save(newStudent);
            } else {
                // Link existing email account to this Social Provider
                user.setProviderId(providerId);
                user.setProviderType(providerType);
                studentRepository.save((Student) user);
            }
        }

        

        // 4. Generate JWT Token
        String jwtToken = jwtServie.generateToken(user.getEmail());

        // Map<String, Object> response = new HashMap<>();
        Map<String, String> response = new HashMap<>();
        response.put("token", jwtToken);
        response.put("email", user.getEmail());
        response.put("role", user.getRole().toString());
        response.put("domain", user.getDomain());
        response.put("status", "Success");

        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}









    // @Transactional
    // public ResponseEntity<?> handleOAuth2LoginRequest(OAuth2User oAuth2User, String registrationId) {

    //     // check/fetch providerType and providerId , beacuse not Dublicate like(google , github)
    //     AuthProviderType providerType = authUtil.getProviderTypeFromRegistrationId(registrationId);
    //     String providerId = authUtil.getProviderIdFromOAuth2User(oAuth2User, registrationId);

    //     // Save the providerType and providerId info with user
    //     BaseUser user = baseUserService.findUserByProviderIdAndProviderType(providerId, providerType);

    //     String email = oAuth2User.getAttribute("email");

    //     UserDetails emailUser = userDetailsService.loadUserByUsername(email);

    //     if(user == null && emailUser == null){
    //         // signup flow:
    //         String userEmail = authUtil.getUserEmailFromOAuth2User(oAuth2User, registrationId, providerId);
    //         // By default student profile , after create DomainAdmin change the role
    //         // set domail
    //         String domain = null;
    //         Student userSignup = studentService.addStudent(domain, email);

    //     }
    //     else{
    //         throw new BadCredentialsException("This email is alrady registerd with provider : "+ emailUser.getUsername());
    //     }

    //     return new ResponseEntity<>("user Login and token" , HttpStatus.OK);

    //     // if the user has an account : direct login
    //     // otherwise, first signup and then login


    // }

