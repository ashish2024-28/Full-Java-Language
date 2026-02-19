package com.demoproject.Config;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import com.demoproject.Entity.AuthProviderType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthUtil {
    
    // check/fetch Provider Type 
    public AuthProviderType getProviderTypeFromRegistrationId(String registrationId){
        return switch (registrationId.toLowerCase()){
            case "google" -> AuthProviderType.GOOGLE;
            case "github" -> AuthProviderType.GITHUB;
            case "email" -> AuthProviderType.EMAIL;
            default -> throw new IllegalArgumentException("Unsupported OAuth2 Provider : " + registrationId);
        };
    }

    // check/fetch ProviderId 
    public String getProviderIdFromOAuth2User(OAuth2User oAuth2User, String registrationId) {
    Object idAttribute = switch (registrationId.toLowerCase()) {
        case "google" -> oAuth2User.getAttribute("sub");
        case "github" -> oAuth2User.getAttribute("id");
        default -> throw new IllegalArgumentException("Unsupported Provider: " + registrationId);
    };

    if (idAttribute == null) {
        throw new IllegalArgumentException("ProviderId not found for " + registrationId);
    }

    // Convert to String safely regardless of it being Integer, Long, or String
    return String.valueOf(idAttribute);
}
    // public String getProviderIdFromOAuth2User(OAuth2User oAuth2User, String registrationId){
    //     String providerId = switch (registrationId.toLowerCase()){
    //         case "google" -> (String) oAuth2User.getAttribute("sub");
    //         // GitHub returns 'id' as an Integer or Long, so .toString() is necessary
    //         case "github" -> String.valueOf(oAuth2User.getAttribute("id"));
    //         default -> {
    //             log.error("Unsupported OAuth2 Provider : {}", registrationId);
    //             throw new IllegalArgumentException("Unsupported OAuth2 Provider : " + registrationId);
    //         }
    //     };
        
    //     if(providerId == null || providerId.isBlank()){
    //         log.error("Unnable to determine providerId for provider : {}", registrationId);
    //         throw new IllegalArgumentException("Unnable to determine providerId for OAuth2 login ");
    //     }
    //     return providerId;
    // }


    public String getUserEmailFromOAuth2User(OAuth2User oAuth2User, String registrationId, String providerId){
        String email = oAuth2User.getAttribute("email");
        if(email != null && !email.isBlank()){
            return email;
        }

        return switch (registrationId.toLowerCase()){
            case "google" -> oAuth2User.getAttribute("sub");
            case "github" -> oAuth2User.getAttribute("id").toString();
            default -> providerId;
        };
    }

}
