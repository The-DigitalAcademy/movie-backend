package com.movie.movie_app_backend.Services;

import com.movie.movie_app_backend.DTO.LoginRequest;
import com.movie.movie_app_backend.DTO.SignUpRequest;
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

    public void signup(SignUpRequest request){
        // to prevent duplicate accounts
        if(UserRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        //Creating a new user
        UsersModel user = new UsersModel();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        // Encrypt password before saving
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        try {
            UserRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // LOGIN logic
    public UsersModel login(LoginRequest request) {

        // Find user by email
        UsersModel user = UserRepository.findByEmail(request.getEmail());

        if(user == null){
            return null;
        }

        // Compare raw password with hashed one
        boolean passwordMatches = passwordEncoder.matches(request.getPassword(), user.getPassword());


            if (!passwordMatches) {
                throw new RuntimeException("Invalid credentials");
            }

            return user;

    }
}
