package com.movie.movie_app_backend.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "movies")
public class MoviesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Integer auto-increment
    private Integer id;

    private String url;
    private String primaryTitle;
    private String originalTitle;
    private String type;
    private String description;
    private String primaryImage;
    private String trailer;
    private String contentRating;

    private Integer startYear;
    private Integer endYear;
    private LocalDate releaseDate;

    private Long budget;
    private Long grossWorldwide;
    private Integer runtimeMinutes;

    private Double averageRating;
    private Integer numVotes;
    private Integer metascore;

    private Boolean isAdult;

    // ====== Lists stored as JSON (Postgres support) ======
    @ElementCollection
    @CollectionTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genre")
    private List<String> genres;

    @ElementCollection
    @CollectionTable(name = "movie_interests", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "interest")
    private List<String> interests;

    @ElementCollection
    @CollectionTable(name = "movie_countries", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "country")
    private List<String> countriesOfOrigin;

    @ElementCollection
    @CollectionTable(name = "movie_links", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "link")
    private List<String> externalLinks;

    @ElementCollection
    @CollectionTable(name = "movie_languages", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "language")
    private List<String> spokenLanguages;

    @ElementCollection
    @CollectionTable(name = "movie_locations", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "location")
    private List<String> filmingLocations;

    @ElementCollection
    @CollectionTable(name = "movie_thumbnails", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "thumbnail")
    private List<String> thumbnails;

    @ElementCollection
    @CollectionTable(name = "movie_production_companies", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "company")
    private List<String> productionCompanies;
}
