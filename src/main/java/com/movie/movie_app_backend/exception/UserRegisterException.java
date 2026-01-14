package com.movie.movie_app_backend.exception;

public class UserRegisterException extends RuntimeException {
    public UserRegisterException() {
        super("Email already exists");
    }
}
