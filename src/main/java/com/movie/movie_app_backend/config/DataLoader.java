package com.movie.movie_app_backend.config;

import com.movie.movie_app_backend.Models.Role;
import com.movie.movie_app_backend.Repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component //Runs once when the app starts
public class DataLoader implements CommandLineRunner {
    private final RoleRepository roleRepository;
    public DataLoader (RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }
    @Override
    public void run (String... args){
        //Create ROLE_USER if it doesn't work
        roleRepository.findByName("ROLE_USER")
                .orElseGet(() -> roleRepository.save(new Role("ROLE_USER")));
    }
}
