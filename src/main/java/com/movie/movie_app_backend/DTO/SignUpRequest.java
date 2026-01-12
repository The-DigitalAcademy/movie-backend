package com.movie.movie_app_backend.DTO;

import lombok.Data;

@Data
//Data sent from frontend during signup
public class SignUpRequest {

    private String username;
    private  String email;
    private String password;
}
