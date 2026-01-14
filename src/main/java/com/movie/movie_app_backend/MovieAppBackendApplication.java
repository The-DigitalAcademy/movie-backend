package com.movie.movie_app_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MovieAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieAppBackendApplication.class, args);
	}

}
