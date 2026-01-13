package com.movie.movie_app_backend.Controllers;


import com.movie.movie_app_backend.DTO.MoviesDTO;
import com.movie.movie_app_backend.Models.MoviesModel;
import com.movie.movie_app_backend.Services.GenreService;
import com.movie.movie_app_backend.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/movies")
public class MoviesController {
    private final MovieService service;
    private final GenreService genreService;
    private final MoviesModel moviesModel;

    @Autowired
    public MoviesController(MovieService service, GenreService genreService) {
        this.service = service;
        this.genreService = genreService;
        moviesModel = new MoviesModel();
    }

    @GetMapping
    public Object getAllMovies() {
        return service.getMovies();
    }

    @PostMapping
    public Object createMovies(@RequestBody MoviesDTO movies) {
        var genres = genreService.getGenreById(movies.getGenre_id());

        if(genres == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre not found");
        }
        moviesModel.setGenre(genres);
        moviesModel.setTitle(movies.getTitle());
        moviesModel.setDescription(movies.getDescription());
        moviesModel.setRating(movies.getRating());
        moviesModel.setRelease_year(moviesModel.getRelease_year());

        service.addMovie(moviesModel);
        return moviesModel;
    }

}
