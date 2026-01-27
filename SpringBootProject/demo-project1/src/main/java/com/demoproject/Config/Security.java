// package com.demoproject.Config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;


// @EnableMethodSecurity
// @Configuration
// public class Security {
    
//     private PasswordEncoder passwordEncoder;

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
//         httpSecurity
//             .authorizeHttpRequests(auth -> auth
// //                .requestMatchers("{domain}/login_profile/**").permitAll()
//                 .requestMatchers("/home/university/**").permitAll()
//                 .requestMatchers("/admin/**").hasAllRoles("Admin")
//                 .requestMatchers("/{domain}/domainAdmin/**").hasAllRoles("DomainAdmin")
//                 .requestMatchers("/{domain}/subadmin/**").hasAllRoles("SubAdmin")
//                 .requestMatchers("/{domain}/faculty/**").hasAllRoles("Faculty")
//                 .requestMatchers("/{domain}/student/**").hasAllRoles("Student").anyRequest().authenticated()
//             )
//             .formLogin(Customizer.withDefaults())
//             .csrf(csrf -> csrf.disable());


//             return httpSecurity.build();

//     }


//  // create for demo
// //    @Bean
//    UserDetailsService userDetailsService (){
//       UserDetails user1 = User.withUsername("admin").password(passwordEncoder.encode("12345")).roles("Admin").build();
//       UserDetails user2 = User.withUsername("dAdmin").password(passwordEncoder.encode("12345")).roles("DomainAdmin").build();
//       UserDetails user3 = User.withUsername("sAdmin").password(passwordEncoder.encode("12345")).roles("SubAdmin").build();
//       UserDetails user4 = User.withUsername("faculty").password(passwordEncoder.encode("12345")).roles("Faculty").build();
//       UserDetails user5 = User.withUsername("student").password(passwordEncoder.encode("12345")).roles("Student").build();
//       UserDetails user6 = User.withUsername("personal").password(passwordEncoder.encode("12345")).roles("Personal").build();
      
//       return new InMemoryUserDetailsManager(user1,user2,user3,user4,user5,user6);
//    }


//     @Bean
//     public PasswordEncoder PasswordEncoder(){
//         return new BCryptPasswordEncoder();
//     }



// }
