 package com.demoproject.Config;


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

import com.demoproject.Service.CustomUserDetailsService;






@Configuration //use anotation for define configration class
@EnableMethodSecurity // use anotation to tell springboot i add or handle the security
// Enables security on methods using annotations like:- > @PreAuthorize ,@PostAuthorize ,@RolesAllowed ,@Secured

//     @EnableMethodSecurity
// @Service
// public class StudentService {

//     @PreAuthorize("hasRole('ADMIN')")
//     public void deleteStudent(Long id) {
//         // only ADMIN can delete
//     }

//     @PreAuthorize("hasAnyRole('FACULTY','ADMIN')")
//     public void updateMarks() {
//     }
// }

@EnableWebSecurity  //WEB / HTTP level security
public class Security {

    // @Autowired
    // PasswordEncoder passwordEncoder;
    // @Autowired
    // private CustomUserDetailsService customUserDetailsService;
// Constructor Injection (final) — ✅ BEST PRACTICE -> How it works
// Spring: 1. Sees constructor parameters 2. Injects dependencies before object is created 3. Object is fully ready & immutable
    // | Feature                  | `@Autowired` Field | Constructor (`final`) |
    // | ------------------------ | ------------------ | --------------------- |
    // | Immutability             | ❌ No               | ✅ Yes                 |
    // | Null safety              | ❌ Risk             | ✅ Guaranteed          |
    // | Testability              | ❌ Hard             | ✅ Easy                |
    // | Security 7 compatibility | ❌ Risky            | ✅ Required            |
    // | Clean code               | ❌                  | ✅                     |
    // | Production ready         | ❌                  | ✅                     |
    // When is @Autowired OK? -> Only for: Optional dependencies, Legacy code , Quick demos
    // ❌ Never use it in Security / Core Config classes

    // private final UserDetailsService userDetailsService;
    // private final CustomUserDetailsService customUserDetailsService;
    // private final PasswordEncoder passwordEncoder;

    // // public Security(UserDetailsService userDetailsService,PasswordEncoder passwordEncoder) {
    // public Security(CustomUserDetailsService customUserDetailsService,PasswordEncoder passwordEncoder) {
    //     this.customUserDetailsService = customUserDetailsService;
    //     this.passwordEncoder = passwordEncoder;
    // }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){

        return httpSecurity
        .authorizeHttpRequests(auth -> auth
                 // 🔓 PUBLIC (NO LOGIN)
                .requestMatchers("/not/**","/home_page/**","/{domain}/login_profile/**","/{domain}/signUp/**","/test/**").permitAll()
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

    // @Bean
    // public UserDetailsService userDetailsService(){
    //     return new CustomUserDetailsService();
    // }


    // ✅ Correct Way (Spring Security 7 / Boot 4)  
    // 🔑 DaoAuthenticationProvider must be created via constructor injection
    // @Bean
    // public AuthenticationProvider authenticationProvider() {
        //         DaoAuthenticationProvider provider = new DaoAuthenticationProvider(customUserDetailsService);
        //         provider.setPasswordEncoder(passwordEncoder());
        //     return provider;
        // }
    // ✅ SO Conclusion : This method is correct because spring manage the dependencies and controle
    // ✅ SO Conclusion : Neeche wala method isliya sahi hai kyunki spring khud dependendencies control karta hai, tum nahi
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(CustomUserDetailsService customUserDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }



    

    // | Old (Security 5/6)                | New (Security 7) |
    // | --------------------------------- | ---------------- |
    // | `new DaoAuthenticationProvider()` | ❌ removed        |
    // | `setUserDetailsService()`         | ❌ removed        |
    // | `setPasswordEncoder()`            | ❌ removed        |
    // | Constructor injection             | ✅ mandatory      |


    // @Bean
    // public DaoAuthenticationProvider daoAuthenticationProvider(){
    //     DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    //     authenticationProvider.setUserDetailsService(userDetailsService());
    //     authenticationProvider.setPasswordEncoder(passwordEncoder());

    //     return authenticationProvider;
    // }



   // create only for demo or learning 
    // @Bean
    // UserDetailsService userDetailsService (){
    //     UserDetails user1 = User.withUsername("admin").password(passwordEncoder.encode("12345")).roles("ADMIN").build();
    //     UserDetails user2 = User.withUsername("dAdmin").password(passwordEncoder.encode("12345")).roles("DOMAIN_ADMIN").build();
    //     UserDetails user3 = User.withUsername("sAdmin").password(passwordEncoder.encode("12345")).roles("SUB_ADMIN").build();
    //     UserDetails user4 = User.withUsername("faculty").password(passwordEncoder.encode("12345")).roles("FACULTY").build();
    //     UserDetails user5 = User.withUsername("student").password(passwordEncoder.encode("12345")).roles("STUDENT").build();

    //     // return new InMemoryUserDetailsManager(user5);
    //     return new InMemoryUserDetailsManager(user1,user2,user3,user4,user5);
    // }







}
