package com.MovieBackendApplication.MovieBackendApplication.repository;

import com.MovieBackendApplication.MovieBackendApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>{
    boolean existsByEmail(String email); // Used during signup
    Optional<User>findByEmail(String email); // used during login
}
