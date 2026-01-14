package com.movie.movie_app_backend.Controllers;

import com.movie.movie_app_backend.Models.FavouritesModel;
import com.movie.movie_app_backend.Services.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/favourites")
@CrossOrigin(origins = "http://localhost:4200") // Frontend access
public class FavouritesController {
    @Autowired
    private final FavouriteService service;

    public FavouritesController(FavouriteService service) {
        this.service = service;
    }

    @GetMapping
    public Object getAllFavourites() {
        return service.getFavourites();
    }

    @PostMapping
    public Object createFavourites(@RequestBody FavouritesModel favourite) {
        return service.addFavourite(favourite);
    }



}
