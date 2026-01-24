package com.digitaleducationrecord.app.Entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsersPrinciple implements UserDetails {

    private User user;

    public UsersPrinciple(User user){
        this.user = user;
    }

    public Role getRole() {
        return user.getRole();
    }

    // public String getDomain() {
    //     return user.getDomain();
    // }

    // 🔐 MOST IMPORTANT METHOD
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(
                new SimpleGrantedAuthority("ROLE_" + user.getRole().name())
        );
    }
    
    @Override
    public  String getPassword() {
        return user.getPassword();
        
    }
    
    @Override
    public String getUsername() {
        return user.getEmail();
        
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
