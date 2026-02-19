package com.oauth2.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oauth2.demo.Entity.User;
import com.oauth2.demo.Repo.UserRepository;

@Service
public class UserService {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    @Autowired
    private UserRepository userRepository;

    public User Signup(User user){
       User loginUser = userRepository.findByEmail(user.getEmail());
       if(loginUser == null){
            user.setPassword(passwordEncoder.encode(user.getEmail()));
           return userRepository.save(user);
        }
        return loginUser;
    }


}
