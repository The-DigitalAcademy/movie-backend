package com.movie.movie_app_backend.Services;

import com.movie.movie_app_backend.DTO.MoviesDTO;
import com.movie.movie_app_backend.Models.MoviesModel; // <-- use your existing model
import com.movie.movie_app_backend.Repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    // ===== Bulk create movies =====
    public List<MoviesModel> createMovies(List<MoviesDTO> moviesDTO) {
        List<MoviesModel> movies = moviesDTO.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
        return movieRepository.saveAll(movies);
    }

    // ===== Convert DTO to Entity =====
    private MoviesModel convertToEntity(MoviesDTO dto) {
        MoviesModel movie = new MoviesModel();
        movie.setUrl(dto.getUrl());
        movie.setPrimaryTitle(dto.getPrimaryTitle());
        movie.setOriginalTitle(dto.getOriginalTitle());
        movie.setType(dto.getType());
        movie.setDescription(dto.getDescription());
        movie.setPrimaryImage(dto.getPrimaryImage());
        movie.setTrailer(dto.getTrailer());
        movie.setContentRating(dto.getContentRating());
        movie.setStartYear(dto.getStartYear());
        movie.setEndYear(dto.getEndYear());
        movie.setReleaseDate(dto.getReleaseDate());
        movie.setBudget(dto.getBudget());
        movie.setGrossWorldwide(dto.getGrossWorldwide());
        movie.setRuntimeMinutes(dto.getRuntimeMinutes());
        movie.setAverageRating(dto.getAverageRating());
        movie.setNumVotes(dto.getNumVotes());
        movie.setMetascore(dto.getMetascore());
        movie.setIsAdult(dto.getIsAdult());
        movie.setGenres(dto.getGenres());
        movie.setInterests(dto.getInterests());
        movie.setCountriesOfOrigin(dto.getCountriesOfOrigin());
        movie.setExternalLinks(dto.getExternalLinks());
        movie.setSpokenLanguages(dto.getSpokenLanguages());
        movie.setFilmingLocations(dto.getFilmingLocations());
        movie.setThumbnails(dto.getThumbnails());
        movie.setProductionCompanies(dto.getProductionCompanies());
        return movie;
    }

    // ===== Other CRUD methods =====
    public List<MoviesModel> getAllMovies() {
        return movieRepository.findAll();
    }

    public MoviesModel getMovieById(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id " + id));
    }

    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }

    public MoviesModel updateMovie(Integer id, MoviesDTO dto) {
        MoviesModel existing = getMovieById(id);
        MoviesModel updated = convertToEntity(dto);
        updated.setId(existing.getId());
        return movieRepository.save(updated);
    }
}
