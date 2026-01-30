package com.oauth2.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.oauth2.demo.Entity.User;

@Service
public class CustomOAuth2UserService
        implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest request)
            throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate =
                new DefaultOAuth2UserService();

        OAuth2User oauthUser = delegate.loadUser(request);

        String provider = request.getClientRegistration()
                                 .getRegistrationId(); // google/github

        String email;
        String name;
        String providerId;

        if (provider.equals("google")) {
            email = oauthUser.getAttribute("email");
            name = oauthUser.getAttribute("name");
            providerId = oauthUser.getAttribute("sub");
        } else { // github
            email = oauthUser.getAttribute("email");
            name = oauthUser.getAttribute("name");
            providerId = String.valueOf(oauthUser.getAttribute("id"));
        }

        // 🔥 SAVE TO DATABASE
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            User user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setProvider(provider.toUpperCase());
            user.setProviderId(providerId);

            userRepository.save(user);
        }

        return oauthUser;
    }
}
