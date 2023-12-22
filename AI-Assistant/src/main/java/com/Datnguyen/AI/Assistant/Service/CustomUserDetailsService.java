//package com.Datnguyen.AI.Assistant.Service;
//
//import com.Datnguyen.AI.Assistant.Entity.UserEntity;
//import com.Datnguyen.AI.Assistant.Repository.UserJDBCRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserJDBCRepo userJDBCRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserEntity user = userJDBCRepo.foundUser(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
//
//        return org.springframework.security.core.userdetails.User
//                .withUsername(user.getUsername())
//                .password(user.getPassword())
//                .roles("USER")
//                .build();
//    }
//}
