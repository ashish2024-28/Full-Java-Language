package com.demoproject.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demoproject.Entity.BaseUser;
import com.demoproject.Repository.DomainAdminRepository;
import com.demoproject.Repository.FacultyRepository;
import com.demoproject.Repository.StudentRepository;
import com.demoproject.Repository.SubAdminRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService{
// NOTE: CustomUserDetailsService → talks ONLY to repositories
        // BaseUserService → uses AuthenticationManager
        // NO cross-dependency

    private final StudentRepository studentRepo;
    private final FacultyRepository facultyRepo;
    private final SubAdminRepository subAdminRepo;
    private final DomainAdminRepository domainAdminRepo;

    public CustomUserDetailsService(
        StudentRepository studentRepo,
        FacultyRepository facultyRepo,
        SubAdminRepository subAdminRepo,
        DomainAdminRepository domainAdminRepo
     ) {
        this.studentRepo = studentRepo;
        this.facultyRepo = facultyRepo;
        this.subAdminRepo = subAdminRepo;
        this.domainAdminRepo = domainAdminRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        BaseUser user =
            studentRepo.findByEmail(email).orElse(null);

        if (user == null)
            user = facultyRepo.findByEmail(email).orElse(null);

        if (user == null)
            user = subAdminRepo.findByEmail(email).orElse(null);

        if (user == null)
            user = domainAdminRepo.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
            );

        return new UsersPrinciple(user);

        // return new org.springframework.security.core.userdetails.User(
        //         user.getEmail(),
        //         user.getPassword(),
        //         List.of(new SimpleGrantedAuthority(user.getRole()))
        // );
    }






    // old code  

  
    // // Once created → cannot change → thread safe immutable 🔒
    // private final BaseUserService baseUserService;

    // // Prevents circular dependency issues 🔄 Spring creates beans in correct order.
    // // Dependency is mandatory , This is called Constructor Injection
    // @Autowired
    // public CustomUserDetailsService(BaseUserService baseUserService) {
    //     this.baseUserService = baseUserService;
    // }

    // @Override
    // public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    //     BaseUser user = baseUserService.findByEmail(email);
    //     return new UsersPrinciple(user);
    // }


    //----------------------------------

    // @Override
    // public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    //     BaseUser user = studentRepository.findByEmail(email).orElse(null);
    //     if (user == null)
    //         user = facultyRepository.findByEmail(email).orElse(null);

    //     if (user == null)
    //         user = subAdminRepository.findByEmail(email).orElse(null);

    //     if (user == null)
    //         user = domainAdminRepository.findByEmail(email).orElse(null);

    //     if (user == null)
    //         throw new UsernameNotFoundException("User not found with email: " + email);

    //     return new org.springframework.security.core.userdetails.User(
    //             user.getEmail(),
    //             user.getPassword(),
    //             List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
    //     );
    // }

    // @Override
    // public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    //     BaseUser baseUser = baseUserRepository.findByEmail(email);
    //     if (baseUser != null) {
    //         return  org.springframework.security.core.userdetails.User
    //                 .withUsername(baseUser.getEmail())
    //                 .password(baseUser.getPassword())
    //                 .roles(String.valueOf(baseUser.getRole()))
    //                 .build();

    //     }
    //     return    null;
    // }
    
}