package com.githinit.springboot.moviesapi.controller;

import com.githinit.springboot.moviesapi.entity.Movie;
import com.githinit.springboot.moviesapi.entity.Review;
import com.githinit.springboot.moviesapi.service.MovieReviewService;
import com.githinit.springboot.moviesapi.service.MovieService;
import com.githinit.springboot.moviesapi.service.UserService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/movies/{id}")

public class MovieReviewController {

    private MovieService movieService;

    private MovieReviewService movieReviewService;

    private UserService userService;

    public MovieReviewController(MovieService movieService, MovieReviewService movieReviewService, UserService userService) {
        this.movieService = movieService;
        this.movieReviewService = movieReviewService;
        this.userService = userService;
    }

    // expose /movies get method to fetch movies

    @GetMapping("/reviews")
    public List<Review> findAll(@PathVariable int id) {

        return movieReviewService.findAll(id);

    }

    // add new movie
    @PostMapping("/reviews")
    public Movie addReview(@PathVariable int id, @RequestBody Review review, OAuth2Authentication auth) {

        review.setId(0);
        review.setCreatedAt(getTimestamp());

        return movieReviewService.save(id, review, auth);
    }


    //  update movie reviews
    @PutMapping("/reviews")
    public Movie updateReview(@PathVariable int id, @RequestBody Review review, OAuth2Authentication auth) {

        return movieReviewService.save(id, review, auth);

    }

    // delete review by id
    @DeleteMapping("/reviews/{reviewId}")
    public String deleteReview(@PathVariable int id, @PathVariable int reviewId, OAuth2Authentication auth) {

        return movieReviewService.deleteById(id, reviewId, auth);

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
