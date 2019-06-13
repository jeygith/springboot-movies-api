package com.githinit.springboot.moviesapi.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "movies")
public class Movie {

    // create fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "plot")
    private String plot;

    @Column(name = "image")
    private String image;

    @Column(name = "country")
    private String country;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "deleted_at")
    private Timestamp deleted_at;



    // create constructors

    public Movie() {
    }

    public Movie(String name, String plot, String image, String country, Timestamp created_at, Timestamp deleted_at) {
        this.name = name;
        this.plot = plot;
        this.image = image;
        this.country = country;
        this.created_at = created_at;
        this.deleted_at = deleted_at;
    }

// create getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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



    // create tostring method


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", plot='" + plot + '\'' +
                ", image='" + image + '\'' +
                ", country='" + country + '\'' +
                ", created_at=" + created_at +
                ", deleted_at=" + deleted_at +
                '}';
    }
}
