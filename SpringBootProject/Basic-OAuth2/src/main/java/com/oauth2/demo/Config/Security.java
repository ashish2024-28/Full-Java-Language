package com.oauth2.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


import lombok.extern.slf4j.Slf4j;

@Configuration 
@EnableMethodSecurity 

@Slf4j
@EnableWebSecurity  //WEB / HTTP level security
public class Security {

    // for OAuth2 -> step 1: add depndency (security-oauth2-client)
    // step 2: create configuratin class (anyname) -> add Bean of SecurityFilterChain 
    // and in sFC -> Default => oauth2Login(Customizer.withDefaults())

    // step 3: go to application.properties add 

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){

    //     return httpSecurity
    //     .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
    //     .oauth2Login(Customizer.withDefaults())

        
    //     .build();

    // }
    
    @Autowired
    private OAuth2SuccessHandeler oAuth2SuccessHandeler;


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

       return http
            .csrf(csrf -> csrf.disable()) // not use this one becuse csrf provide security which no any one hit apis except get
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            .authorizeHttpRequests(auth -> auth
                // .requestMatchers().authenticated()
                .anyRequest().permitAll()
            )
            // .oauth2Login(Customizer.withDefaults())
            
            .oauth2Login(oauth2 -> oauth2
                .failureHandler(
                (request,response,exception)->{
                    log.error("oauth2 error : {}", exception.getMessage());
                })
                .successHandler(oAuth2SuccessHandeler)
            )
            .build();

    }


}
