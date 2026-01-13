package com.movie.movie_app_backend.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MoviesDTO {

    private String url;
    private String primaryTitle;
    private String originalTitle;
    private String type;
    private String description;
    private String primaryImage;
    private String trailer;
    private String contentRating;

    private Integer startYear;
    private Integer endYear;
    private LocalDate releaseDate;

    private Long budget;
    private Long grossWorldwide;
    private Integer runtimeMinutes;

    private Double averageRating;
    private Integer numVotes;
    private Integer metascore;

    private Boolean isAdult;

    // ====== Lists as Strings ======
    private List<String> genres;
    private List<String> interests;
    private List<String> countriesOfOrigin;
    private List<String> externalLinks;
    private List<String> spokenLanguages;
    private List<String> filmingLocations;
    private List<String> thumbnails;
    private List<String> productionCompanies;
}
