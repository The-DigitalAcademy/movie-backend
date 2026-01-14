package com.movie.movie_app_backend.Controllers;

import com.movie.movie_app_backend.DTO.MoviesDTO;
import com.movie.movie_app_backend.Models.MoviesModel;
import com.movie.movie_app_backend.Services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "http://localhost:4200") // Frontend access
@RequiredArgsConstructor
public class MoviesController {

    private final MovieService movieService;

    // ===== Bulk POST =====
    @PostMapping("/bulk")
    public ResponseEntity<List<MoviesModel>> createMoviesBulk(@RequestBody List<MoviesDTO> moviesDTO) {
        List<MoviesModel> movies = movieService.createMovies(moviesDTO);
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    // ===== Single POST =====
    @PostMapping
    public ResponseEntity<MoviesModel> createMovie(@RequestBody MoviesDTO movieDTO) {
        MoviesModel movie = movieService.createMovies(List.of(movieDTO)).get(0);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    // ===== GET all =====
    @GetMapping
    public ResponseEntity<List<MoviesModel>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    // ===== GET by id =====
    @GetMapping("/{id}")
    public ResponseEntity<MoviesModel> getMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    // ===== DELETE =====
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    // ===== UPDATE =====
    @PutMapping("/{id}")
    public ResponseEntity<MoviesModel> updateMovie(@PathVariable Integer id, @RequestBody MoviesDTO dto) {
        MoviesModel updated = movieService.updateMovie(id, dto);
        return ResponseEntity.ok(updated);
    }
}
