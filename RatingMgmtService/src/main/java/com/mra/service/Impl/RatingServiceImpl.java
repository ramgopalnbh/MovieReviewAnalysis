package com.mra.service.Impl;

import com.mra.entities.Rating;
import com.mra.repository.RatingRepository;
import com.mra.service.RatingService;
import com.mra.service.SequenceGeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    SequenceGeneratorService generatorService;
    @Override
    public Rating createRating(Rating rating) {
        log.info("-----Inside add rating method");
//        if(rating.getRatingId() ==null)
//            rating.setRatingId(generatorService.getNextSequence("MRA_Rating"));
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        log.info("-----Inside get all ratings method");
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllRatingByUserId(Long userId) {
        log.info("-----Inside get all ratings method by userId");
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingByMovieId(Long movieId) {
        log.info("-----Inside get all ratings method by movieId");
        return ratingRepository.findByMovieId(movieId);
    }
}
