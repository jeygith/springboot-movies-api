package com.githinit.springboot.moviesapi.controller;


import com.githinit.springboot.moviesapi.entity.Movie;
import com.githinit.springboot.moviesapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {
    // inject movie service

    @Autowired
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    // expose /movies get method to fetch movies

    @GetMapping("/movies")
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    // /movies/{id} find movie by id

    @GetMapping("/movies/{id}")
    public Movie find(@PathVariable int id) {
        return movieService.findById(id);
    }


    // add new movie
    @PostMapping("/movies")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public Movie addMovie(@RequestBody Movie movie) {
        movie.setId(0);

        movie.setCreatedAt(getTimestamp());

        movie.setUpdatedAt(getTimestamp());

        movieService.save(movie);

        return movie;
    }

    // update movie
    @PutMapping("/movies")
    public Movie updateMovie(@RequestBody Movie movie) {

        movie.setUpdatedAt(getTimestamp());

        movieService.save(movie);

        return movie;
    }


    // delete movie by id
    @DeleteMapping("/movies/{id}")
    public String deleteMovie(@PathVariable int id) {

        movieService.deleteById(id);
        return "Deleted movie id - " + id;

    }


    private Timestamp getTimestamp() {
        Date date = new Date();

        long time = date.getTime();
        System.out.println("Time in Milliseconds: " + time);

        Timestamp ts = new Timestamp(time);
        System.out.println("Current Time Stamp: " + ts);
        return ts;
    }

}
