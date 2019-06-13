package com.githinit.springboot.moviesapi.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {

    // define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "genre_name")
    private String genreName;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "deleted_at")
    private Timestamp deleted_at;

    @OneToMany
    @JoinColumn(name = "genre_id")
    private List<Movie> movies;


    // define constructors

    public Genre() {
    }

    public Genre(String genreName, String description, Timestamp created_at, Timestamp deleted_at, List<Movie> movies) {
        this.genreName = genreName;
        this.description = description;
        this.created_at = created_at;
        this.deleted_at = deleted_at;
        this.movies = movies;
    }

//define getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Timestamp deleted_at) {
        this.deleted_at = deleted_at;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

// define tostring method


    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genreName='" + genreName + '\'' +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                ", deleted_at=" + deleted_at +
                ", movies=" + movies +
                '}';
    }
}
