// package com.demoproject;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;

// import com.demoproject.Entity.User;
// import com.demoproject.Repository.UserRepository;

// public class CoustomUserDetailsService implements UserDetailsService{

//      @Autowired
//     private UserRepository userRepository;




//       @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         User user = userRepository.findByUsername(username);
//         if (user != null) {
//             return  org.springframework.security.core.userdetails.User
//                     .withUsername(user.getUsername())
//                     .password(user.getPassword())
//                     .roles(String.valueOf(user.getRole()))
//                     .build();
            
//         }

//         throw new UsernameNotFoundException("user not found with user gamil: "+ username);

//     }
// }
