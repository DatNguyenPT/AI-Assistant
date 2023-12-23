//package com.Datnguyen.AI.Assistant.Config;
//
//import com.Datnguyen.AI.Assistant.Entity.UserEntity;
//import com.Datnguyen.AI.Assistant.Repository.UserJDBCRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//
//@Component
//public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {
//    @Autowired
//    private UserJDBCRepo userJDBCRepo;
//    @Autowired
//    private PasswordEncoder encoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String password = authentication.getCredentials().toString();
//        UserEntity user = userJDBCRepo.foundUser(username).orElseThrow(() ->
//                new UsernameNotFoundException("User Not Found"));
//        if(encoder.matches(password, user.getPassword())){
//            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
//        }else{
//            throw new BadCredentialsException("Invalid Password");
//        }
//    }
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
