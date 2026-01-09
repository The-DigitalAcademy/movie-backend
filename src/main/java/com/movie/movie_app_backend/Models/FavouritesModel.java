package com.movie.movie_app_backend.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "Favourites")
public class FavouritesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime Created_at;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MoviesModel movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersModel User;

}
