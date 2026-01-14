package com.movie.movie_app_backend.Controllers;


import com.movie.movie_app_backend.Models.UsersModel;
import com.movie.movie_app_backend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private final UserService service;

    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsersModel> getAllCategories() {
        return service.getUsers();
    }

    @PostMapping
    public UsersModel createCategories(@RequestBody UsersModel user) {
        return service.addUser(user);
    }

}
