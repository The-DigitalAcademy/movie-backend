package com.MovieBackendApplication.MovieBackendApplication.config;

import com.MovieBackendApplication.MovieBackendApplication.model.Role;
import com.MovieBackendApplication.MovieBackendApplication.repository.RoleRepository;
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
