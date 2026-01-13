package com.movie.movie_app_backend.Controllers;

import com.movie.movie_app_backend.Models.GenresModel;
import com.movie.movie_app_backend.Services.GenreService;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/genres")
public class GenresController {
    @Autowired
    private final GenreService service;

    public GenresController(GenreService service) {
        this.service = service;
    }

    @GetMapping
    public Object getAllGenres() {
        return service.getGenres();
    }

    @PostMapping
    public Object createGenres(@RequestBody GenresModel genre) {
        return service.addGenre(genre);
    }


}
