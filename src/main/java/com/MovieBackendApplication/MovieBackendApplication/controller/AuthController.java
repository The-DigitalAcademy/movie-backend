package com.MovieBackendApplication.MovieBackendApplication.controller;

import com.MovieBackendApplication.MovieBackendApplication.dto.SignUpRequest;
import com.MovieBackendApplication.MovieBackendApplication.dto.AuthResponse;
import com.MovieBackendApplication.MovieBackendApplication.dto.LoginRequest;
import com.MovieBackendApplication.MovieBackendApplication.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Exposes REST APIs
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000") // Frontend access
public class AuthController {

    @Autowired
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // SIGNUP endpoint
    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignUpRequest request) {
        authService.signup(request);
        return ResponseEntity.ok(new AuthResponse("Signup successful"));
    }

    // LOGIN endpoint
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        authService.login(request);
        return ResponseEntity.ok(new AuthResponse("Login successful"));
    }
}
