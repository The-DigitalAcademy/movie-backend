package com.movie.movie_app_backend.Services;

import com.movie.movie_app_backend.Models.FavouritesModel;
import com.movie.movie_app_backend.Repositories.FavouriteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteService {
        private final FavouriteRepository FavouriteRepository;

    public FavouriteService(FavouriteRepository FavouriteRepository) {
        this.FavouriteRepository = FavouriteRepository;
    }

    public List<FavouritesModel> getFavourites() {
        return FavouriteRepository.findAll();
    }

    public FavouritesModel addFavourite(FavouritesModel favourite) {
        return FavouriteRepository.save(favourite);
    }
}
