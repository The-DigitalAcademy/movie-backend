package com.movie.movie_app_backend.Services;

import com.movie.movie_app_backend.Models.MoviesModel;
import com.movie.movie_app_backend.Repositories.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository MovieRepository;

    public MovieService(MovieRepository MovieRepository) {
        this.MovieRepository = MovieRepository;
    }

    public List<MoviesModel> getMovies() {
        return MovieRepository.findAll();
    }

    public MoviesModel addMovie(MoviesModel movie) {
        return MovieRepository.save(movie);
    }
}