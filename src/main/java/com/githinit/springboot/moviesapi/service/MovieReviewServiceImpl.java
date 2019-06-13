package com.githinit.springboot.moviesapi.service;

import com.githinit.springboot.moviesapi.dao.MovieReviewRepository;
import com.githinit.springboot.moviesapi.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieReviewServiceImpl implements MovieReviewService {

    private MovieReviewRepository movieReviewRepository;

    public MovieReviewServiceImpl(MovieReviewRepository movieReviewRepository) {
        this.movieReviewRepository = movieReviewRepository;
    }

    @Override
    public List<Review> findAll() {
        return movieReviewRepository.findAll();
    }

    @Override
    public Review findById(int id) {

        Optional<Review> result = movieReviewRepository.findById(id);

        Review review = null;

        if (result.isPresent()) {
            review = result.get();
        } else {
            throw new RuntimeException("Movie not found - " + id);
        }

        return review;
    }

    @Override
    public void save(Review review) {
        movieReviewRepository.save(review);
    }


    @Override
    public void deleteById(int id) {
        movieReviewRepository.deleteById(id);
    }

}
