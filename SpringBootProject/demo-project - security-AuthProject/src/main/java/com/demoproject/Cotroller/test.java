package com.demoproject.Cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    
    @GetMapping("/test")
    public String testConroller() {
            return "Backend Connected Successfully";
}

}
