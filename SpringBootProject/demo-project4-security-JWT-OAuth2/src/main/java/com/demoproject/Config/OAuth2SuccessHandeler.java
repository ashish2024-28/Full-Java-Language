package com.demoproject.Config;

import java.io.IOException;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;


@Component
public class OAuth2SuccessHandeler implements AuthenticationSuccessHandler {
    
    private final AuthService authService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public OAuth2SuccessHandeler(@org.springframework.context.annotation.Lazy AuthService authService) {
        this.authService = authService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, 
                                        Authentication authentication) throws IOException {
        
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String registrationId = token.getAuthorizedClientRegistrationId();

        // Try to extract domain from request URI or referer
        String domain = extractDomainFromRequest(request);

        ResponseEntity<?> loginResponse = authService.handleOAuth2LoginRequest(oAuth2User, registrationId, domain);

        response.setStatus(loginResponse.getStatusCode().value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(objectMapper.writeValueAsString(loginResponse.getBody()));
    }

    private String extractDomainFromRequest(HttpServletRequest request) {
        // Logic: if URI is /google/login, we might not find it. 
        // Often stored in a cookie or session before redirecting to Google.
        // For now, let's look at the URI or return null.
        String uri = request.getRequestURI(); 
        return null; // Replace with your logic if needed
    }
}




// @Component
// @RequiredArgsConstructor
// public class OAuth2SuccessHandeler implements AuthenticationSuccessHandler {
    
//     private AuthService authService;
        
//     public OAuth2SuccessHandeler(AuthService authService) {
//         this.authService = authService;
//     }

    
//     @Override
//     public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//         OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
//         OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();

//         String registrationId = token.getAuthorizedClientRegistrationId();        

//        ResponseEntity <?> loginResponse = authService.handleOAuth2LoginRequest(oAuth2User, registrationId);

//        response.setStatus(loginResponse.getStatusCode().value());
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.getWriter().write((int) loginResponse.getBody());
//     } 
    


// }
