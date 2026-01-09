package com.movie.movie_app_backend.Services;

import com.movie.movie_app_backend.Models.UsersModel;
import com.movie.movie_app_backend.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository UserRepository;

    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public List<UsersModel> getUsers() {
        return UserRepository.findAll();
    }

    public UsersModel addUser(UsersModel user) {
        return UserRepository.save(user);
    }


}

