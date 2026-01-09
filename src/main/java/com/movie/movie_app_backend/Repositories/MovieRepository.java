package com.movie.movie_app_backend.Repositories;

import com.movie.movie_app_backend.Models.MoviesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MoviesModel, Integer> {
}
