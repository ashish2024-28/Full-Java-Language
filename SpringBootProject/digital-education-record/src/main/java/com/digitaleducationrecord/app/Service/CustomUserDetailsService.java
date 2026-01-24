package com.digitaleducationrecord.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.digitaleducationrecord.app.Entity.User;
import com.digitaleducationrecord.app.Entity.UsersPrinciple;
import com.digitaleducationrecord.app.Repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    // Once created → cannot change → thread safe immutable 🔒
    private final UserRepository userRepository;

    // Prevents circular dependency issues 🔄 Spring creates beans in correct order.
    // Dependency is mandatory , This is called Constructor Injection
    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(null);
        return new UsersPrinciple(user);
    }
    //  UsersPrinciple implements UserDetails 
    //             ^
    //             |
    //  create class UsersPrinciple otherwise 
    //             |
    //             v

    
    // @Override
    // public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    //     User user = userRepository.findByEmail(email);
    //     if (user != null) {
    //         return  org.springframework.security.core.userdetails.User
    //                 .withUsername(user.getEmail())
    //                 .password(user.getPassword())
    //                 .roles(String.valueOf(user.getRole()))
    //                 .build();

    //     }
    //     return    null;
    // }
    
}
