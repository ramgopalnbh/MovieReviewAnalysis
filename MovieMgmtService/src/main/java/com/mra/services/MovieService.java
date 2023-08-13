package com.mra.services;

import com.mra.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    //add movie
    public Movie addMovie(Movie movie);

    //get all movies
    public List<Movie> getAllMovies();

    //get movie by id
    public Optional<Movie> getMovie(Long movieId);
}
