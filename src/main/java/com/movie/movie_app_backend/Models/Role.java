package com.movie.movie_app_backend.Models;

import jakarta.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue
    private int id;
    private String name; // Role name

    public Role(){}
    public Role(String name){this.name = name;}

    public String getName() {return name;}
}
