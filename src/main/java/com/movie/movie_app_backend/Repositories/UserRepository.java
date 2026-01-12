package com.movie.movie_app_backend.Repositories;

import com.movie.movie_app_backend.Models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UsersModel, Integer> {
    boolean existsByEmail(String email); // Used during signup
    Optional<UsersModel> findByEmail(String email); // used during login
}

