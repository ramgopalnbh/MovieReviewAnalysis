package com.mra.services.Impl;

import com.mra.entities.Movie;
import com.mra.entities.Rating;
import com.mra.entities.User;
import com.mra.exceptions.ResourceNotFoundException;
import com.mra.external.services.MovieService;
import com.mra.repositories.UserRepository;
import com.mra.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UseServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    RestTemplate restTemplate;
    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
    @Autowired
    private MovieService movieService;

    @Override
    public Optional<User> getUser(Long userId) {
        //get user from database with the help of user repository
        User user =repository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("Resource not found on server at userId: "+userId));
        //fetch rating of above user from RATING SERVICE
        Rating[] ratingsOfUser =restTemplate.getForObject("http://RatingMgmtService/rating/user/"+user.getUserId(), Rating[].class);
        log.info("Getting Object {} : "+ratingsOfUser);

        List<Rating> ratingsList = Arrays.stream(ratingsOfUser).toList();
        List<Rating> ratings =ratingsList.stream().map(rating -> {
            //api call to movie service to get the movie
            //ResponseEntity<Movie> forEntity =restTemplate.getForEntity("http://MovieMgmtService/movie/"+rating.getMovieId(), Movie.class);
            Movie movie =movieService.getMovie(rating.getMovieId());
            //Movie movie =forEntity.getBody();
            //log.info("Response status code {}: "+forEntity.getStatusCode());
            //set the movie to rating
            rating.setMovie(movie);
            //return the rating
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratings);
        return Optional.of(user);
    }
}
