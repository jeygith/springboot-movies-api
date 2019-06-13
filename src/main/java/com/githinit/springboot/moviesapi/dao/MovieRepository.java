package com.githinit.springboot.moviesapi.dao;

import com.githinit.springboot.moviesapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
