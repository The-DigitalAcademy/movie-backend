package com.movie.movie_app_backend.DTO;

import lombok.Data;

@Data

public class LoginRequest {
    private String email;
    private String password;
}
