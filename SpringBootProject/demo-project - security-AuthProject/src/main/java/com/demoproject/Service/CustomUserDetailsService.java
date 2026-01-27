package com.demoproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demoproject.Entity.BaseUser;
import com.demoproject.Repository.BaseUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private BaseUserRepository baseUserRepository;




    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        BaseUser baseUser = baseUserRepository.findByEmail(email);
        if (baseUser != null) {
            return  org.springframework.security.core.userdetails.User
                    .withUsername(baseUser.getEmail())
                    .password(baseUser.getPassword())
                    .roles(String.valueOf(baseUser.getRole()))
                    .build();

        }
        return    null;


    }
}