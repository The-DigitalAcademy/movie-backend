package com.movie.movie_app_backend.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "favourites")
public class FavouritesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private MoviesModel movie;

    private String userEmail; // or any user identifier
}
