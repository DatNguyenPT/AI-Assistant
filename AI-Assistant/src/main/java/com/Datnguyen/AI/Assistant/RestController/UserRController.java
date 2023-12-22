package com.Datnguyen.AI.Assistant.RestController;

import com.Datnguyen.AI.Assistant.Entity.UserEntity;
import com.Datnguyen.AI.Assistant.Repository.UserJDBCRepo;
import com.Datnguyen.AI.Assistant.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class UserRController {
    private UserService userService;
    private PasswordEncoder encoder;
    private UserJDBCRepo userJDBCRepo;
    public UserRController(UserService userService, UserJDBCRepo userJDBCRepo, PasswordEncoder encoder){
        this.userService = userService;
        this.userJDBCRepo = userJDBCRepo;
        this.encoder = encoder;
    }

    @PostMapping(value = "/createnewuser")
    public ResponseEntity<UserEntity> createUser(@RequestBody @Valid UserEntity newUser) {
        newUser.setPassword(encoder.encode(newUser.getPassword())); // hashing
        userJDBCRepo.save(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestParam String loginname, @RequestParam String password) {
        UserEntity user = userService.login(loginname, password);

        if (user != null) {
            // Use the PasswordEncoder to check if the provided password matches the stored hashed password
            if (encoder.matches(password, user.getPassword())) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid password", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("No existing account", HttpStatus.BAD_REQUEST);
        }
    }
}
