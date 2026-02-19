package com.demoproject.Cotroller.CsrfSessionId;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/not")
public class basic {
    
    @GetMapping("/session")
    public String getSessionId(HttpServletRequest request){
        return "Session Id : " 
        + request.getSession().getId() + "\n, " 
        + request.changeSessionId() + "\n ,"
        + request.getAuthType() + "\n, " 
        + request.isRequestedSessionIdFromCookie()+ "\n ,"
        + request.getContentType()+ "\n,  "
        + request.getContextPath()+ "\n,  ........ more" ;
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfSession(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf") ;
    }

}
