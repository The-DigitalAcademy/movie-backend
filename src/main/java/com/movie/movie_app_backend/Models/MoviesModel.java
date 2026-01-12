package com.movie.movie_app_backend.Models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity(name = "Movies")
@EntityListeners(AuditingEntityListener.class)
public class MoviesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private String title;
    private String description;
    private Integer release_year;
    private Double rating;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenresModel genre;
}



