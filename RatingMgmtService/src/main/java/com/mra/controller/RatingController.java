package com.mra.controller;

import com.mra.entities.Rating;
import com.mra.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    RatingService ratingService;

    //creating rating
    @PostMapping("/")
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
        log.info("-----Inside add rating method");
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    //get all ratings
    @GetMapping("/")
    public ResponseEntity<List<Rating>> getAllRatings(){
        log.info("-----Inside get all ratings method");
        return ResponseEntity.status(HttpStatus.FOUND).body(ratingService.getAllRatings());
    }

    //get all ratings by userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable Long userId){
        log.info("-----Inside get all ratings method by userId");
        return ResponseEntity.status(HttpStatus.FOUND).body(ratingService.getAllRatingByUserId(userId));
    }

    //get all ratings by userId
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Rating>> getAllRatingsByMovieId(@PathVariable Long movieId){
        log.info("-----Inside get all ratings method by movieId");
        return ResponseEntity.status(HttpStatus.FOUND).body(ratingService.getAllRatingByMovieId(movieId));
    }
}
