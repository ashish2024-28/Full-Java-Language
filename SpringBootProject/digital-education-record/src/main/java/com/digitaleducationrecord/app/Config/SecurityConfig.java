package com.digitaleducationrecord.app.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.digitaleducationrecord.app.Service.CustomUserDetailsService;

@Configuration //use anotation for define configration class
@EnableWebSecurity  //WEB HTTP level security -> // Enables security on methods using annotations like:- > @PreAuthorize ,@PostAuthorize ,@RolesAllowed ,@Secured
@EnableMethodSecurity // use anotation to tell springboot i add or handle the security
public class SecurityConfig {


    // let assume step wise -> step: 1
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        return httpSecurity
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/home/**").permitAll()
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                    // .requestMatchers("/")
                )
                .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .build();
    }
    // let assume step wise -> step: 2
    @Bean("BCryptEncoder")
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // let assume step wise -> step: 3
    // first create 2 file which let any name(CustomUserDetailsService, UsersPrinciple)
    // 1. CustomUserDetailsService implements UserDetailsService <- in Service Folder
    // 2. UsersPrinciple implements UserDetails <- in Entity or Model Folder
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(CustomUserDetailsService customUserDetailsService, PasswordEncoder passwordEncoder){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }
}

// Login form
//    ↓
// DaoAuthenticationProvider
//    ↓
// CustomUserDetailsService
//    ↓
// UserService
//    ↓
// Check User : Student / Faculty / Admin table
//    ↓
// UsersPrinciple
//    ↓
// ROLE based access