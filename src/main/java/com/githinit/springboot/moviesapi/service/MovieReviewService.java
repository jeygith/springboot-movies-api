package com.githinit.springboot.moviesapi.service;

import com.githinit.springboot.moviesapi.entity.Review;

import java.util.List;

public interface MovieReviewService {

    public List<Review> findAll();

    public Review findById(int id);

    public void save(Review review);

    public void deleteById(int id);
}
