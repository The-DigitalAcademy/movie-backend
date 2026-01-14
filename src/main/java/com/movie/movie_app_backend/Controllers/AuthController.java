package com.movie.movie_app_backend.Controllers;

import com.movie.movie_app_backend.Models.UsersModel;
import com.movie.movie_app_backend.DTO.SignUpRequest;
import com.movie.movie_app_backend.DTO.AuthResponse;
import com.movie.movie_app_backend.DTO.LoginRequest;
import com.movie.movie_app_backend.Services.AuthService;
import com.movie.movie_app_backend.exception.UserLoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Exposes REST APIs
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200") // Frontend access
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
    public Object login(@RequestBody LoginRequest request) {
        UsersModel user = authService.login(request);

        if(user == null) {
            throw new UserLoginException();
        }
        user.setPassword(null);
        return ResponseEntity.ok(user);
    }
}
