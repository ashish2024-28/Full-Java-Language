 package com.demoproject.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestTemplate;

import com.demoproject.Service.CustomUserDetailsService;

import lombok.extern.slf4j.Slf4j;





@Slf4j
@Configuration //use anotation for define configration class
@EnableMethodSecurity // use anotation to tell springboot i add or handle the security
// Enables security on methods using annotations like:- > @PreAuthorize ,@PostAuthorize ,@RolesAllowed ,@Secured

@EnableWebSecurity  //WEB / HTTP level security
public class Security {

    @Autowired     // JWT -> Validation start 1
    private JwtFilter jwtFilter;
    @Autowired
    private OAuth2SuccessHandeler oAuth2SuccessHandeler;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){

        return httpSecurity
        .authorizeHttpRequests(auth -> auth
                 // 🔓 PUBLIC (NO LOGIN)
                .requestMatchers("/not/**","/home_page/**","/{domain}/login_profile/**",
                                "/{domain}/signUp/**","/test/**","/oauth2/google/**").permitAll()
                 // 🔐 ROLE BASED
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/{domain}/domainAdmin/**").hasAnyRole("ADMIN","DOMAIN_ADMIN")
                .requestMatchers("/{domain}/subadmin/**").hasAnyRole("ADMIN","SUB_ADMIN")
                .requestMatchers("/{domain}/faculty/**").hasAnyRole("ADMIN","FACULTY")
                .requestMatchers("/{domain}/student/**").hasAnyRole("ADMIN","STUDENT")
                .anyRequest().authenticated()
        )
        // .oauth2Login(Customizer.withDefaults())
        .oauth2Login(oauth2 -> oauth2
            .failureHandler(
            (request,response,exception)->{
                log.error("oauth2 error : {}", exception.getMessage());
            })
            .successHandler(oAuth2SuccessHandeler)
        )
        
        // .httpBasic(Customizer.withDefaults()) //pop aaye gaa, also  optional (Postman testing)
        // .formLogin(Customizer.withDefaults()) // html form aaye gaa
        // .formLogin(form -> form.disable()) // html form aaye gaa

        // .formLogin(form -> form
        //     .loginPage("/login")          // custom login page
        //     .defaultSuccessUrl("/profile", true)
        //     .permitAll()

        // .logout(logout -> logout
        //     .logoutSuccessUrl("/login?logout")
        // );
        .csrf(csrf -> csrf.disable()) // not use this one becuse csrf provide security which no any one hit apis except get
        .sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )

        // after returning tken from JWTServer.java.
        // If Again Same user login or go to any other APIs so 
        // only send token not username&password so,start step: 1 pass jwtFilter so go to JwtFilter.java 

        // JWT -> Validation start 1
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

        .build();

    }

   
    @Bean("bcryptEncoder")
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // ✅ SO Conclusion : This method is correct because spring manage the dependencies and controle
    // ✅ SO Conclusion : Neeche wala method isliya sahi hai kyunki spring khud dependendencies control karta hai, tum nahi
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(CustomUserDetailsService customUserDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    // process how to work jwt so tell to AuthenticationManager hold first jwt create token then start
    // process of jwt start first(1.) go to loginpage -> Controller
    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
        
    }

    
    @Bean
    public RestTemplate restTemplate (){
        return new RestTemplate();
    }


}
