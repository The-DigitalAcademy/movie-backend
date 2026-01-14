package com.movie.movie_app_backend.Repositories;

import com.movie.movie_app_backend.Models.FavouritesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriteRepository extends JpaRepository<FavouritesModel, Integer> {
}
