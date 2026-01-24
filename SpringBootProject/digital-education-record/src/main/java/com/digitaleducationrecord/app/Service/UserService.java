package com.digitaleducationrecord.app.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.digitaleducationrecord.app.Entity.User;
import com.digitaleducationrecord.app.Repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    @Qualifier("BCryptEncoder")
    private PasswordEncoder passwordEncoder;



    // public User LoginUser(String domain, String email, String password){
    public User loginUser(String email, String password){
        User loginUser = userRepository.findByEmail(email).orElseThrow(null);
        boolean passwordMatch = passwordEncoder.matches(password,loginUser.getPassword());
        if (passwordMatch) {
            loginUser.setLastLoginDateTime(LocalDateTime.now());
            return userRepository.save(loginUser);
            
         } else {    return null;    }
    }


    // --------- Create a User ---------
    public String createUser(User user){
        if(userRepository.existsByEmail(user.getEmail())){  return "Email Id field are already exist. Entern unique. ";    }
        // for security use passwordEncoder
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "You Account is Created Successfully." ;
    }
}
