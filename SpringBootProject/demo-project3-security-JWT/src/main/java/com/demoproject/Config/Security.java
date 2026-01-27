 package com.demoproject.Config;


import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.demoproject.Service.CustomUserDetailsService;






@Configuration //use anotation for define configration class
@EnableMethodSecurity // use anotation to tell springboot i add or handle the security
// Enables security on methods using annotations like:- > @PreAuthorize ,@PostAuthorize ,@RolesAllowed ,@Secured

@EnableWebSecurity  //WEB / HTTP level security
public class Security {



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){

        return httpSecurity
        .authorizeHttpRequests(auth -> auth
                 // 🔓 PUBLIC (NO LOGIN)
                .requestMatchers("/not/**","/home_page/**","/{domain}/login_profile/**",
                                "/{domain}/signUp/**","/test/**").permitAll()
                 // 🔐 ROLE BASED
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/{domain}/domainAdmin/**").hasAnyRole("ADMIN","DOMAIN_ADMIN")
                .requestMatchers("/{domain}/subadmin/**").hasAnyRole("ADMIN","SUB_ADMIN")
                .requestMatchers("/{domain}/faculty/**").hasAnyRole("ADMIN","FACULTY")
                .requestMatchers("/{domain}/student/**").hasAnyRole("ADMIN","STUDENT")
                .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults()) //pop aaye gaa, also acces for post man
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


    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    


}
