package com.movie.movie_app_backend.Repositories;

import com.movie.movie_app_backend.Models.GenresModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<GenresModel, Integer> {
}
