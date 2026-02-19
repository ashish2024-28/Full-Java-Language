package com.demoproject.Security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// only send token not username&password so,start step: 2 pass jwtFilter so go to JwtFilter.java 

// JWT -> Validation start 3  => create a JwtFilter class 

@Component
// @Component → Spring will auto-create this class
// OncePerRequestFilter → ✅ Runs only once per request, ❌ Not multiple times
public class JwtFilter extends OncePerRequestFilter  {

    @Autowired //📌 This class: Generates JW, Extracts usernam, Validates token
    private JWTService jwtService;

    @Autowired
    private ApplicationContext context;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
         FilterChain filterChain) throws ServletException, IOException {

            // step: 2.1 get token (Header exists) from user
            // Bearer eafdghdfsyf.8sdfs68sdfsf0s.dfsdf9sdfdf7d8f67sdfsf <- token
            String authHeader = request.getHeader("Authorization");
            String token = null;
            // username -> email
            String username = null;

            // step: 2.2 check the token not null and startwith "Bearer ". and take token , and extractUSername(get username/email). 
            if(authHeader != null && authHeader.startsWith("Bearer ")){
                token = authHeader.substring(7);
                // call method
                username = jwtService.extractUserName(token); 
            }

            // step: 2.3 check the username not null and User is not already authenticated .
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){ 
                // get the data from DB based on username(email)  
                UserDetails userDetails = context.getBean(CustomUserDetailsService.class).loadUserByUsername(username);

                // step: 2.4 check / ValidateToken both true username and userDetails.getusername() and token not expire
                if(jwtService.ValidateToken(token,userDetails)){
                    // create new authentication object 
                    UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource());
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
            filterChain.doFilter(request, response);

    }




}
