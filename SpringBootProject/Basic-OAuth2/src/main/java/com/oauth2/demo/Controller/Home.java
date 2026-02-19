package com.oauth2.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Home {
    @GetMapping
    public String loginPage(){
        return "OAuth2";
    }

    public String LoginOrSingup(){
        return "OAuth2";
    }

    
}
