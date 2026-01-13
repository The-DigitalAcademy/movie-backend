package com.movie.movie_app_backend.Services;

import com.movie.movie_app_backend.Models.GenresModel;
import com.movie.movie_app_backend.Repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private final GenreRepository GenreRepository;

    public GenreService(GenreRepository GenreRepository) {
        this.GenreRepository = GenreRepository;
    }

    public List<GenresModel> getGenres() {
        return GenreRepository.findAll();
    }

    public GenresModel getGenreById(int id) { return GenreRepository.findById(id).orElse(null); }

    public GenresModel addGenre(GenresModel genre) {
        return GenreRepository.save(genre);
    }
}
