package org.example.blog_platform.controller;

import lombok.RequiredArgsConstructor;
import org.example.blog_platform.model.Role;
import org.example.blog_platform.model.User;
import org.example.blog_platform.repository.RoleRepository;
import org.example.blog_platform.security.JwtTokenUtil;
import org.example.blog_platform.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final JwtTokenUtil jwtTokenUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if(userService.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("USER").orElseThrow();
        user.getRoles().add(userRole);
        User savedUser = userService.save(user);
        String token = jwtTokenUtil.generateToken(savedUser.getUsername());
        return ResponseEntity.ok().body("Bearer " + token);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        User user = userService.findByUsername(loginRequest.getUsername()).orElseThrow();
        if(passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            String token = jwtTokenUtil.generateToken(user.getUsername());
            return ResponseEntity.ok().body("Bearer " + token);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}