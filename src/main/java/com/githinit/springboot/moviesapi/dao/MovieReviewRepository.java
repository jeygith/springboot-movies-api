package com.githinit.springboot.moviesapi.dao;

import com.githinit.springboot.moviesapi.entity.Movie;
import com.githinit.springboot.moviesapi.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieReviewRepository extends JpaRepository<Review, Integer> {

}
