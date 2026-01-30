package com.oauth2.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.oauth2.demo.Service.CustomOAuth2UserService;

@Configuration 
@EnableMethodSecurity 


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
    private CustomOAuth2UserService customOAuth2UserService;
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login").permitAll()
                .anyRequest().authenticated()
            )
            .oauth2Login(oauth -> oauth
                .userInfoEndpoint(userInfo ->
                    userInfo.userService(customOAuth2UserService)
                )
            );

        return http.build();
    }


}
