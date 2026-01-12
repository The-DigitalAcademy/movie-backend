package com.MovieBackendApplication.MovieBackendApplication.model;

import jakarta.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    private String name; // Role name

    public Role(){}
    public Role(String name){this.name = name;}

    public String getName() {return name;}
}
