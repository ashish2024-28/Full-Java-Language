package com.demoproject.Entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsersPrinciple implements UserDetails {

    private BaseUser baseUser;

    public UsersPrinciple(BaseUser baseUser){
        this.baseUser = baseUser;
    }

    public Role getRole() {
        return baseUser.getRole();
    }

    public String getDomain() {
        return baseUser.getDomain();
    }

    // 🔐 MOST IMPORTANT METHOD
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(
                new SimpleGrantedAuthority("ROLE_" + baseUser.getRole().name())
        );
    }
    
    @Override
    public  String getPassword() {
        return baseUser.getPassword();
        
    }
    
    @Override
    public String getUsername() {
        return baseUser.getEmail();
        
    }
    
    // 👇 REQUIRED BY SPRING SECURITY

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


// Login form
//    ↓
// DaoAuthenticationProvider
//    ↓
// CustomUserDetailsService
//    ↓
// BaseUserService
//    ↓
// Student / Faculty / Admin table
//    ↓
// UsersPrinciple
//    ↓
// ROLE based access
