package com.movie.movie_app_backend.exception;

public class UserLoginException extends RuntimeException {
    public UserLoginException() {
        super("Invalid Credentials");
    }
}
