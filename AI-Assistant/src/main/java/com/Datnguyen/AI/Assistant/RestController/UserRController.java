package com.Datnguyen.AI.Assistant.RestController;

import com.Datnguyen.AI.Assistant.Entity.UserEntity;
import com.Datnguyen.AI.Assistant.Repository.UserJDBCRepo;
import com.Datnguyen.AI.Assistant.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class UserRController {
    private UserService userService;
    private UserJDBCRepo userJDBCRepo;
    private PasswordEncoder passwordEncoder; // Use PasswordEncoder directly

    public UserRController(UserService userService, UserJDBCRepo userJDBCRepo, PasswordEncoder passwordEncoder){
        this.userService = userService;
        this.userJDBCRepo = userJDBCRepo;
        this.passwordEncoder = passwordEncoder; // Inject PasswordEncoder directly
    }

    @PostMapping(value = "/createnewuser")
    public ResponseEntity<UserEntity> createUser(@RequestBody @Valid UserEntity newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword())); // hashing
        userJDBCRepo.save(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

//    @PostMapping(value = "/login")
//    public ResponseEntity<?> login(@RequestParam String loginname, @RequestParam String password) {
//        // Authenticate the user
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginname, password));
//
//        // Set the authentication in the SecurityContext
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        if (authentication.isAuthenticated()) {
//            // The user is authenticated, you can proceed with further actions
//            // (e.g., generate a token, return user details, etc.)
//            UserEntity user = userService.login(loginname, password);
//            return new ResponseEntity<>(user, HttpStatus.OK);
//        } else {
//            // Authentication failed
//            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
//        }
//    }
}
