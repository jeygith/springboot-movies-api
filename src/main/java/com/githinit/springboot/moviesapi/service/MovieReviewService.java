package com.githinit.springboot.moviesapi.service;

import com.githinit.springboot.moviesapi.entity.Movie;
import com.githinit.springboot.moviesapi.entity.Review;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.List;

public interface MovieReviewService {

    public List<Review> findAll(int id);

    public Review findById(int id);

    public Movie save(int id, Review review, OAuth2Authentication auth);

    public String deleteById(int id, int reviewId, OAuth2Authentication auth);


}
