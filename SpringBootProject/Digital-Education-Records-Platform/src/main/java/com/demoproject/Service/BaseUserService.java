package com.demoproject.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.demoproject.DTO.LoginRequestDTO;
import com.demoproject.DTO.LoginResponseDTO;
import com.demoproject.Entity.BaseUser;
import com.demoproject.Repository.DomainAdminRepository;
import com.demoproject.Repository.FacultyRepository;
import com.demoproject.Repository.StudentRepository;
import com.demoproject.Repository.SubAdminRepository;
import com.demoproject.Security.JWTService;

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
   


    // public BaseUser findByEmail(String email) {

    // BaseUser user = studentRepo.findByEmail(email).orElse(null);
    // if (user != null) return user;

    // user = facultyRepo.findByEmail(email).orElse(null);
    // if (user != null) return user;

    // user = subAdminRepo.findByEmail(email).orElse(null);
    // if (user != null) return user;

    // return domainAdminRepo.findByEmail(email)
    //         .orElseThrow(() ->
    //             new UsernameNotFoundException("User not found: " + email)
    //         );
    // }

    //  Login by Email + Password but problem is domain not check

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService ;

    @Autowired
    private StudentRepository studentRepo; 
    @Autowired
    private FacultyRepository facultyRepo;
    @Autowired
    private SubAdminRepository subAdminRepo;
    @Autowired
    private DomainAdminRepository domainAdminRepo;


    // process of jwt verify user using userLogin method (3.) go to generateToken method call     -> JWTService

    // working 2.  -> if use 1️⃣ manualy check user by its domain => ✔ Domain validated ,✔ Authentication validated ,✔ JWT generated
    //                       2️⃣ Authentication call loadUserByUsername() method ->  CustomUserDetailsService
    
    // public String userLogin(LoginRequestDTO loginRequestDTO){
    public LoginResponseDTO userLogin(LoginRequestDTO request){
        
        // 1️⃣ Domain validation (manual)
        BaseUser user = findUserByDomainAndEmail(request.getDomain(), request.getEmail());
        // LoginResponseDTO user = findUserByDomainAndEmail(request.getDomain(), request.getEmail());

        if (user == null) {
            throw new RuntimeException("Invalid domain or email");
        }
        // 2️⃣ Password validation (Spring Security)
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        if(authentication.isAuthenticated()){
            // return jwtService.generateToken(user.getEmail());
            // authentication.getName() => return user email

            // return jwtService.generateToken(authentication.getName());
            String token =  jwtService.generateToken(authentication.getName());
                    
            return new LoginResponseDTO(token, user.getRole().toString());

        }
        // return "fail";
        return null;
    }


    public BaseUser findUserByDomainAndEmail(String domain, String email) {
    // private LoginResponseDTO findUserByDomainAndEmail(String domain, String email) {

        BaseUser user =
            studentRepo.findByEmailAndDomain(email, domain).orElse(null);

        if (user == null)
            user = facultyRepo.findByEmailAndDomain(email, domain).orElse(null);

        if (user == null)
            user = subAdminRepo.findByEmailAndDomain(email, domain).orElse(null);

        if (user == null)
            user = domainAdminRepo.findByEmailAndDomain(email, domain).orElse(null);

        return user;
        // return new LoginResponseDTO(token, user.getRole());
    }


}

