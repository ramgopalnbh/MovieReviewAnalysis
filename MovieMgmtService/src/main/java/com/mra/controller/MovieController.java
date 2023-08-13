package com.mra.controller;

import com.mra.entities.Movie;
import com.mra.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    //Add Movie
    @PostMapping("/")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        Movie movie1 =movieService.addMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie1);
    }

    //Get single movie
    @GetMapping("/{movieId}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable Long movieId){
        Optional<Movie> movie =movieService.getMovie(movieId);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    //Get All Movies
    @GetMapping("/")
    public ResponseEntity<List<Movie>> getMovies(){
        List<Movie> movies =movieService.getAllMovies();
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }
}
