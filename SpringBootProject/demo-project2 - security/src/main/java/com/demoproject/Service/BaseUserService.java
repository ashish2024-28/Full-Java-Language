package com.demoproject.Service;


import org.springframework.beans.factory.annotation.Autowired;
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



}

