package com.demoproject.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demoproject.Entity.BaseUser;
import com.demoproject.Repository.DomainAdminRepository;
import com.demoproject.Repository.FacultyRepository;
import com.demoproject.Repository.StudentRepository;
import com.demoproject.Repository.SubAdminRepository;

@Service
public class BaseUserService {

    @Autowired
    private StudentRepository studentRepo; 
    @Autowired
    private FacultyRepository facultyRepo;
    @Autowired
    private SubAdminRepository subAdminRepo;
    @Autowired
    private DomainAdminRepository domainAdminRepo ;
   


    public BaseUser findByEmail(String email) {

    BaseUser user = studentRepo.findByEmail(email).orElse(null);
    if (user != null) return user;

    user = facultyRepo.findByEmail(email).orElse(null);
    if (user != null) return user;

    user = subAdminRepo.findByEmail(email).orElse(null);
    if (user != null) return user;

    return domainAdminRepo.findByEmail(email)
            .orElseThrow(() ->
                new UsernameNotFoundException("User not found: " + email)
            );
    }

    //  Login by Email + Password but problem is domain not check
    // @Autowired
    // private JWTServie jwtServie ;
    // @Autowired
    // private AuthenticationManager authenticationManager;

    // private final JWTServie jwtServie ;
    // private final AuthenticationManager authenticationManager;
    // public BaseUserService (JWTServie jwtServie, AuthenticationManager authenticationManager){
    //     this.jwtServie = jwtServie;
    //     this.authenticationManager = authenticationManager;

    // }

    // public String userLogin(String domain, String email, String password){
    //     Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
    //     if(authentication.isAuthenticated()){
    //         return "success";
    //         // return jwtServie.generateToken(email);
    //     }
    //     return "fail";
    // }




}

