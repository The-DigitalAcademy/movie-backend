package com.MovieBackendApplication.MovieBackendApplication.service;

import com.MovieBackendApplication.MovieBackendApplication.dto.LoginRequest;
import com.MovieBackendApplication.MovieBackendApplication.dto.SignUpRequest;
import com.MovieBackendApplication.MovieBackendApplication.model.Role;
import com.MovieBackendApplication.MovieBackendApplication.model.User;
import com.MovieBackendApplication.MovieBackendApplication.repository.RoleRepository;
import  com.MovieBackendApplication.MovieBackendApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void signup(SignUpRequest request){
        // to prevent duplicate accounts
        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        //Creating a new user
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        // Encrypt password before saving
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Assign default role
        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Role not found"));

        user.getRoles().add(userRole);

        userRepository.save(user);
    }

    // LOGIN logic
    public void login(LoginRequest request) {

        // Find user by email
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        // Compare raw password with encrypted one
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
