package com.githinit.springboot.moviesapi.controller;


import com.githinit.springboot.moviesapi.entity.Movie;
import com.githinit.springboot.moviesapi.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {
    // inject movie service

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
}
