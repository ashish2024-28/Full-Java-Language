package com.demoproject.Security;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
    
    
    private String  secretKey = "";
    
    public JWTService (){
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = keyGen.generateKey();
            secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());

        } catch (NoSuchAlgorithmException e) {  throw new RuntimeException(e);      }
    }

    
    // process of jwt verify user using userLogin method (4.) call getKey method then 
    
    // return token and when same user login they send token so Start verifying token from => Security.java 
    
    // generateToken method call from BaseUserService
    public String generateToken(String email) {

        Map<String, Object> claims = new HashMap<>(); 
        return Jwts.builder()
                // 🔹 HEADER
                .header()
                    .add("typ", "JWT")
                    .add("alg", "HS256")
                    .add("app", "demo-project")   // custom header (optional)
                .and()

                // 🔹 PAYLOAD
                .claims()
                    .add(claims)
                    .subject(email)
                    .issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // 30 min
                .and()

                // 🔹 SIGNATURE
                .signWith(getKey()) // getKey method call
                .compact();
    }

    // getKey method call   
    private SecretKey getKey() {
        // byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        // return Keys.hmacShaKeyFor(keyBytes);
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
    
    public String extractUserName(String token) {
        // extract the username from jwt token
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver){
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser()
        .verifyWith(getKey())
        .build().
        parseSignedClaims(token).
        getPayload();
    }

    public boolean ValidateToken(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }

    
}
