package com.demoproject.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demoproject.Entity.AuthProviderType;
import com.demoproject.Entity.BaseUser;
import com.demoproject.Repository.DomainAdminRepository;
import com.demoproject.Repository.FacultyRepository;
import com.demoproject.Repository.StudentRepository;
import com.demoproject.Repository.SubAdminRepository;

@Service
public class BaseUserService {

    // @Autowired
    // private StudentRepository studentRepo; 
    // @Autowired
    // private FacultyRepository facultyRepo;
    // @Autowired
    // private SubAdminRepository subAdminRepo;
    // @Autowired
    // private DomainAdminRepository domainAdminRepo ;
   


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

    public boolean existsByEmail(String email) {

    boolean user = studentRepo.existsByEmail(email);
    if (user) return user;

    user = facultyRepo.existsByEmail(email);
    if (user) return user;

    user = subAdminRepo.existsByEmail(email);
    if (user) return user;

    return domainAdminRepo.existsByEmail(email);
           
    }

    //  Login by Email + Password but problem is domain not check

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTServie jwtService ;

    @Autowired
    private StudentRepository studentRepo; 
    @Autowired
    private FacultyRepository facultyRepo;
    @Autowired
    private SubAdminRepository subAdminRepo;
    @Autowired
    private DomainAdminRepository domainAdminRepo;


    // process of jwt verify user using userLogin method (3.) go to generateToken method call     -> JWTService

    public String userLogin(String domain, String email, String password){
    // public String userLogin(String domain, String email, String password){
        
        // 1️⃣ Domain validation (manual)
        BaseUser user = findUserByDomainAndEmail(domain, email);

        if (user == null) {
            throw new RuntimeException("Invalid domain or email");
        }

        // 2️⃣ Password validation (Spring Security)
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(email, password)
        );

        // 3️⃣ JWT
        // return jwtService.generateToken(email);


        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        if(authentication.isAuthenticated()){
            // return "success";
            return jwtService.generateToken(user.getEmail());
        }
        return "fail";
    }


    private BaseUser findUserByDomainAndEmail(String domain, String email) {

        BaseUser user =
            studentRepo.findByEmailAndDomain(email, domain).orElse(null);

        if (user == null)
            user = facultyRepo.findByEmailAndDomain(email, domain).orElse(null);

        if (user == null)
            user = subAdminRepo.findByEmailAndDomain(email, domain).orElse(null);

        if (user == null)
            user = domainAdminRepo.findByEmailAndDomain(email, domain).orElse(null);

        return user;
    }


    //  OAuth call from AuthService in config folder
    public BaseUser findUserByProviderIdAndProviderType(String providerId, AuthProviderType providerType) {

        BaseUser user =
            studentRepo.findByProviderIdAndProviderType(providerId, providerType).orElse(null);

        if (user == null)
            user = facultyRepo.findByProviderIdAndProviderType(providerId, providerType).orElse(null);

        if (user == null)
            user = subAdminRepo.findByProviderIdAndProviderType(providerId, providerType).orElse(null);

        if (user == null)
            user = domainAdminRepo.findByProviderIdAndProviderType(providerId, providerType).orElse(null);

        return user;
    }


}

