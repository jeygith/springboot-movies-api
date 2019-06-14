package com.githinit.springboot.moviesapi.service;

import com.githinit.springboot.moviesapi.dao.MovieReviewRepository;
import com.githinit.springboot.moviesapi.entity.Movie;
import com.githinit.springboot.moviesapi.entity.Review;
import com.githinit.springboot.moviesapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MovieReviewServiceImpl implements MovieReviewService {

    @Autowired
    private MovieReviewRepository movieReviewRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;


    public MovieReviewServiceImpl(MovieReviewRepository movieReviewRepository, UserService userService) {

    }

    @Override
    public List<Review> findAll(int id) {

        Movie movie = movieService.findById(id);

        List<Review> reviews = movie.getReviews();

        return reviews;

        // return movieReviewRepository.findAll();
    }

    @Override
    public Review findById(int id) {

        Optional<Review> result = movieReviewRepository.findById(id);

        Review review = null;

        if (result.isPresent()) {
            review = result.get();
        } else {
            throw new RuntimeException("Movie Review not found - " + id);
        }

        return review;
    }

    @Override
    public Movie save(int id, Review review, OAuth2Authentication auth) {
        User user = userService.findByUsername(auth.getPrincipal().toString());

        Review movieReview = this.findById(review.getId());

        if (movieReview.getUser().getId() != user.getId()) {
            System.out.println("error in review ownership");
            throw new RuntimeException("User does not own this review");
        }

        review.setUser(user);
        review.setUpdatedAt(getTimestamp());

        movieReviewRepository.save(review);
        System.out.println("\nid: " + id);

        Movie movie = movieService.findById(id);

        return movie;
    }


    @Override
    public String deleteById(int id, int reviewId, OAuth2Authentication auth) {
        System.out.println(reviewId);

        User user = userService.findByUsername(auth.getPrincipal().toString());

        Review movieReview = this.findById(reviewId);

        if (movieReview.getUser().getId() != user.getId()) {
            System.out.println("error in review ownership");
            throw new RuntimeException("User does not own this review");
        }
        movieReviewRepository.deleteById(id);

        return "Deleted movie review id - " + reviewId;
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
