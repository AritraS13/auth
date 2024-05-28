package com.company.auth.controller;

import com.company.auth.model.User;
import com.company.auth.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class SignUpController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public SignUpController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User newUser) {
        if (userRepository.findByUsername(newUser.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        userRepository.save(newUser);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Pong");
    }
}
