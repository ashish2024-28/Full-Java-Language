 package com.demoproject.Config;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
 import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.core.userdetails.User;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.security.provisioning.InMemoryUserDetailsManager;
 import org.springframework.security.web.SecurityFilterChain;

import com.demoproject.Service.CustomUserDetailsService;


 @EnableMethodSecurity // use anotation to tell springboot i add or handle the security
 @Configuration //use anotation for define configration class
 public class Security {

    @Autowired
    private CustomUserDetailsService userDetailsService;

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
         httpSecurity
//             .authorizeHttpRequests(auth -> auth
//  //                .requestMatchers("{domain}/login_profile/**").permitAll()
//                 // .requestMatchers("/home/university/**","{domain}/login_profile/**").permitAll()
//                 .requestMatchers("/home/university/**").permitAll()
//                 .requestMatchers("/admin/**").hasRole("ADMIN")
//                 .requestMatchers("/{domain}/domainAdmin/**").hasAnyRole("ADMIN","DOMAIN_ADMIN")
//                 .requestMatchers("/{domain}/subadmin/**").hasAnyRole("ADMIN","SUB_ADMIN")
//                 .requestMatchers("/{domain}/faculty/**").hasAnyRole("ADMIN","FACULTY")
//                 .requestMatchers("/{domain}/student/**").hasAnyRole("ADMIN","STUDENT").anyRequest().authenticated()
//             )
//             .httpBasic(Customizer.withDefaults())
//            .formLogin(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable());


            return httpSecurity.build();

     }


  // create for demo
 //    @Bean
//    UserDetailsService userDetailsService (){
//       UserDetails user1 = User.withUsername("admin").password(passwordEncoder.encode("12345")).roles("Admin").build();
//       UserDetails user2 = User.withUsername("dAdmin").password(passwordEncoder.encode("12345")).roles("DomainAdmin").build();
//       UserDetails user3 = User.withUsername("sAdmin").password(passwordEncoder.encode("12345")).roles("SubAdmin").build();
//       UserDetails user4 = User.withUsername("faculty").password(passwordEncoder.encode("12345")).roles("Faculty").build();
//       UserDetails user5 = User.withUsername("student").password(passwordEncoder.encode("12345")).roles("Student").build();
//       UserDetails user6 = User.withUsername("personal").password(passwordEncoder.encode("12345")).roles("Personal").build();
//
//       return new InMemoryUserDetailsManager(user1,user2,user3,user4,user5,user6);
//    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // @Bean
    // public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
    //     return httpSecurity.getSharedObject(AuthenticationManager.class)
    //         .userDetailsService(userDetailsService)
    //         .passwordEncoder(passwordEncoder())
    //         .build();
    // }



 }
