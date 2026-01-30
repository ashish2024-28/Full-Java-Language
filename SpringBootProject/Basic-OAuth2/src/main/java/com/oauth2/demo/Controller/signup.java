package com.oauth2.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class signup
 {
        @GetMapping
    public String loginPage(){
        return "signup page";
    }
}
