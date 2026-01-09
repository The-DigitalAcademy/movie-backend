package com.movie.movie_app_backend.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsersLoginDTO {
    private String username;
    private String email;
    private String password;
}

