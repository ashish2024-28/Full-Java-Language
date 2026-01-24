package com.demoproject.Service;

// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demoproject.Repository.BaseUserRepository;

@Service
// public class UsersService implements UserDetailsService {
public class BaseUserService  {
    
    private BaseUserRepository userRepository;

    // @Autowired
    // private PasswordEncoder PasswordEncoder;

    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     return userRepository.findByUsername(username);
    // }

    // public BaseUser createUsers(BaseUser baseUser){
    //     // user.setPassword(PasswordEncoder.encode(user.getPassword()));
    //     return userRepository.save(baseUser);
    // }


}
