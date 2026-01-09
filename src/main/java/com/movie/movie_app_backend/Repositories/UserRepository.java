package com.movie.movie_app_backend.Repositories;

import com.movie.movie_app_backend.Models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsersModel, Integer> {
}
