package com.mra.service;

import com.mra.entities.Rating;

import java.util.List;

public interface RatingService {
    //create rating
    Rating createRating(Rating rating);

    //get all rating
    List<Rating> getAllRatings();

    //get all ratings by userId
    List<Rating> getAllRatingByUserId(Long userId);

    //get all rating by movie
    List<Rating> getAllRatingByMovieId(Long movieId);
}
