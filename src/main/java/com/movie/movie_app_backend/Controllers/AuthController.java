package com.movie.movie_app_backend.Controllers;

import com.movie.movie_app_backend.DTO.SignUpRequest;
import com.movie.movie_app_backend.DTO.AuthResponse;
import com.movie.movie_app_backend.DTO.UsersLoginDTO;
import com.movie.movie_app_backend.Services.AuthService;
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
    public ResponseEntity<AuthResponse> login(@RequestBody UsersLoginDTO request) {
        authService.login(request);
        return ResponseEntity.ok(new AuthResponse("Login successful"));
    }
}
