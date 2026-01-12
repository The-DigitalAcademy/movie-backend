package com.movie.movie_app_backend.Services;

import com.movie.movie_app_backend.DTO.LoginRequest;
import com.movie.movie_app_backend.DTO.SignUpRequest;
import com.movie.movie_app_backend.DTO.UsersLoginDTO;
import com.movie.movie_app_backend.Models.UsersModel;
import com.movie.movie_app_backend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private final UserRepository UserRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository UserRepository, PasswordEncoder passwordEncoder){
        this.UserRepository = UserRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    public void signup(SignUpRequest request){
//        // to prevent duplicate accounts
//        if(UserRepository.existsByEmail(request.getEmail())){
//            throw new RuntimeException("Email already exists");
//        }
//        //Creating a new user
//        UsersModel user = new UsersModel();
//        user.setUsername(request.getUsername());
//        user.setEmail(request.getEmail());
//
//        // Encrypt password before saving
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//
//    }

    // LOGIN logic
    public void login(UsersLoginDTO request) {

        // Find user by email
        UsersModel user = UserRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        // Compare raw password with encrypted one
        if (!request.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
