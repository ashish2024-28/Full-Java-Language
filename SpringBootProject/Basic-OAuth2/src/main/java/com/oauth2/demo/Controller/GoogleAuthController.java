// package com.oauth2.demo.Controller;

// import java.net.http.HttpHeaders;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.client.RestTemplate;

// import com.oauth2.demo.Entity.User;
// import com.oauth2.demo.Service.UserRepository;


// @RestController
// @RequestMapping("/auth/google")
// public class GoogleAuthController {
    
//     // value set from application.properties
//     @Value("spring.security.oauth2.client.registration.google.client-id")
//     private String clientId ;
//     @Value("spring.security.oauth2.client.registration.google.client-secret")
//     private String clientSecret ;

//     @Autowired
//     private RestTemplate restTemplate;
//     @Autowired
//     private PasswordEncoder passwordEncoder;
//     @Autowired
//     private UserRepository userRepository;


//     @GetMapping("/callback")
//     public ResponseEntity<?> handleGoogleCallback(@RequestParam String code){
//         try {
//             // 1. Exchange auth code for token
//             String tokenEndpoint = "http://oauth2.googleapis.com/token"; 

//             Map<String, String> params = new HashMap<>();
//             params.put("code",code);
//             params.put("client_id",clientId);
//             params.put("client_secret",clientSecret);
//             params.put("redirect_url","https://developers.google.com/oauthplayground");
//             params.put("grant_type","authorization_code");

//             HttpHeaders header = new HttpHeaders();
//             header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//             HttpEntity<Map<String, String>> request = new HttpEntity<>(params, header);
//             ResponseEntity<Map> tokenResponse = restTemplate.postForEntity(tokenEndpoint, request, Map.class);
//             String idToken = (String) tokenResponse.getBody().get("id_token");
//             String userInfoUrl = "https://oauth2.googleapis.com/token=" + idToken;
//             ResponseEntity<Map> userInfoResponse = restTemplate.getForEntity(userInfoUrl, Map.class);

//             if(userInfoResponse.getStatusCode() == HttpStatus.OK){
//                 Map<String, Object> userInfo = userInfoResponse.getBody();                
//                 String email = (String) userInfo().get("enail"); 
//                 UserDetails userDetails = customUserDetailsService.loadUserByUsername(email); 
//                 if(userDetails == null){
//                     User user = new User();
//                     user.setEmail(email);
//                     user.setName(email);
//                     // random password
//                     user.setPassword(passwordEncoder.encode(UUID.randomUUID().toString()));
//                     userRepository.save(user);
                    
//                 }

//             }
            

//         } catch (Exception e) {

//         }
//     }

// }
