package com.MovieBackendApplication.MovieBackendApplication.model;

import jakarta .persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity // the class becomes a database table called "User"
@Table(name = "users")
public class User {

    @Id // Primary Key
    @GeneratedValue // Auto-generated ID
    private Long id;
    private String username;

    @Column(unique = true)
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER) // A user can have many roles (User, Admin)
    private Set<Role> roles = new HashSet<>();

    //Getters and Setters
    public Long getId(){return id;}
    public String getUsername(){return username;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public Set<Role> getRoles() {return roles;}

    public void setUsername(String username) {this.username = username;}
    public void setEmail(String email) {this.email = email;}
    public void setPassword(String password) {this.password = password;}
}
