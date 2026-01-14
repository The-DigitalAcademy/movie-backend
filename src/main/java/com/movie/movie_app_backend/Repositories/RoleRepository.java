package com.movie.movie_app_backend.Repositories;

import com.movie.movie_app_backend.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository <Role, Long> {
    Optional<Role>findByName (String name);
}
