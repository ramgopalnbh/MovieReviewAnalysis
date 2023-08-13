package com.mra.repository;

import com.mra.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//public interface RatingRepository extends MongoRepository<Rating, Long> {
public interface RatingRepository extends JpaRepository<Rating, Long> {

    //custom finder method
    List<Rating> findByUserId(Long userId);
    List<Rating> findByMovieId(Long movieId);
}
