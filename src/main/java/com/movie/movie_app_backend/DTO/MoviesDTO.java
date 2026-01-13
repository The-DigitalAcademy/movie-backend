package com.movie.movie_app_backend.DTO;

import lombok.Data;

@Data
public class MoviesDTO {
    private String title;
    private String description;
    private String release_date;
    private Double rating;
    private Integer genre_id;
}
