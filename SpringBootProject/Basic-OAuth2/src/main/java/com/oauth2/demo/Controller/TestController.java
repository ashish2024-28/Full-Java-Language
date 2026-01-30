package com.oauth2.demo.Controller;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/me")
    public Map<String, Object> me(Authentication authentication) {

        OAuth2User user = (OAuth2User) authentication.getPrincipal();

        return user.getAttributes();
    }
}
