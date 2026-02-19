// package com.demoproject.Cotroller;

// import java.util.Map;
// import java.util.UUID;

// import org.springframework.http.HttpHeaders;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.util.LinkedMultiValueMap;
// import org.springframework.util.MultiValueMap;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.client.RestTemplate;

// import com.demoproject.Entity.Role;
// import com.demoproject.Entity.Student;
// import com.demoproject.Repository.StudentRepository;
// import com.demoproject.Service.CustomUserDetailsService;

// import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @RestController
// @RequestMapping("/auth/google")
// public class GoogleAuthController {
    
//     // value set from application.properties
//     @Value("${spring.security.oauth2.client.registration.google.client-id}")
//     private String clientId ;
//     @Value("${spring.security.oauth2.client.registration.google.client-secret}")
//     private String clientSecret ;

//     @Autowired
//     private RestTemplate restTemplate;
//     @Autowired
//     private CustomUserDetailsService customUserDetailsService;
//     @Autowired
//     private PasswordEncoder passwordEncoder;
//     @Autowired
//     private StudentRepository studentRepository;


//     @GetMapping("/callback")
//     public ResponseEntity<?> handleGoogleCallback(@RequestParam("code") String code){
//         try {
//             // 1. Exchange auth code for token
//             String tokenEndpoint = "https://oauth2.googleapis.com/token";

// //            2 Preparing token request
//             MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//             params.add("code", code);
//             params.add("client_id", clientId);
//             params.add("client_secret", clientSecret);
//             // IMPORTANT: This must match the URI you used to get the 'code'
//             params.add("redirect_uri","https://developers.google.com/oauthplayground");
//             params.add("grant_type", "authorization_code");

//             HttpHeaders header = new HttpHeaders();
//             header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

//             HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, header);
            
//             // Exchange code for Access Token and ID Token
//             ResponseEntity<Map> tokenResponse = restTemplate.postForEntity(tokenEndpoint, request, Map.class);

//             String idToken = (String) tokenResponse.getBody().get("id_token");
//             String userInfoUrl = "https://oauth2.googleapis.com/tokeninfo?id_token=" + idToken;

//             System.out.println("sdfsdfsaaf: "+idToken);

//             ResponseEntity<Map> userInfoResponse = restTemplate.getForEntity(userInfoUrl, Map.class);

//             if(userInfoResponse.getStatusCode() == HttpStatus.OK){
//                 Map<String, Object> userInfo = userInfoResponse.getBody();                
//                 String email = (String) userInfo.get("email");
//                 UserDetails userDetails = customUserDetailsService.loadUserByUsername(email); 
//                 if(userDetails == null){
//                     Student user = new Student();
//                     user.setEmail(email);
//                     user.setName(email);
//                     // random password
//                     user.setPassword(passwordEncoder.encode(UUID.randomUUID().toString()));
//                     user.setRole(Role.STUDENT);
//                     studentRepository.save(user);

//                     userDetails = customUserDetailsService.loadUserByUsername(email); 
//                     return ResponseEntity.ok("Welcome " + email);
//                 }
//                 UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, userDetails.getAuthorities());
//                 SecurityContextHolder.getContext().setAuthentication(authentication);

//                 return ResponseEntity.status(HttpStatus.OK).build();
                
//             }
//             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            
            
//         } catch (Exception e) {
//             System.out.println(e);
//             System.out.println(e.getMessage());
//             log.error("Exception occur " + e);
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

//         }

//     }

// }