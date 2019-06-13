package com.githinit.springboot.moviesapi.service;

import com.githinit.springboot.moviesapi.dao.MovieRepository;
import com.githinit.springboot.moviesapi.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovieService {

    public List<Movie> findAll();

    public Movie findById(int id);

    public void save(Movie movie);

    public void deleteById(int id);
}
