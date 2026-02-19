package com.demoproject.Cotroller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class test {
    
    @GetMapping
    public String testConroller() {
            return "Spring Boot Running Successfully";
    }





    



}
