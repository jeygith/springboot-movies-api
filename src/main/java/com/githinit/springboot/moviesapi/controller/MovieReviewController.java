package com.githinit.springboot.moviesapi.controller;

import com.githinit.springboot.moviesapi.entity.Movie;
import com.githinit.springboot.moviesapi.entity.Review;
import com.githinit.springboot.moviesapi.entity.User;
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

        Movie movie = movieService.findById(id);

        List<Review> reviews = movie.getReviews();

        return reviews;
    }

    // add new movie
    @PostMapping("/reviews")
    public Movie addReview(@PathVariable int id, @RequestBody Review review, OAuth2Authentication auth) {

        System.out.println(auth.getPrincipal().toString());

        User user = userService.findByUsername(auth.getPrincipal().toString());

        System.out.println("user: " + user);

        Movie movie = movieService.findById(id);

        review.setUser(user);
        review.setCreatedAt(getTimestamp());
        review.setUpdatedAt(getTimestamp());

        movie.addReview(review);
        movie.setUpdatedAt(getTimestamp());

        movieService.save(movie);

        return movie;
    }


    // add new movie
    @PutMapping("/reviews")
    public Movie updateReview(@PathVariable int id, @RequestBody Review review, OAuth2Authentication auth) {


        User user = userService.findByUsername(auth.getPrincipal().toString());

        Review movieReview = movieReviewService.findById(review.getId());

        if (movieReview.getUser().getId() != user.getId()) {
            System.out.println("error in review ownership");
            throw new RuntimeException("User does not own this review");
        }


        review.setUser(user);
        review.setCreatedAt(getTimestamp());
        review.setUpdatedAt(getTimestamp());

        movieReviewService.save(review);
        System.out.println("\nid: " + id);

        Movie movie = movieService.findById(id);


        return movie;
    }

    // delete review by id
    @DeleteMapping("/reviews/{reviewId}")
    public String deleteReview(@PathVariable int id, @PathVariable int reviewId, OAuth2Authentication auth) {

        System.out.println(reviewId);

        User user = userService.findByUsername(auth.getPrincipal().toString());

        Review movieReview = movieReviewService.findById(reviewId);

        if (movieReview.getUser().getId() != user.getId()) {
            System.out.println("error in review ownership");
            throw new RuntimeException("User does not own this review");
        }
        movieReviewService.deleteById(id);

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
