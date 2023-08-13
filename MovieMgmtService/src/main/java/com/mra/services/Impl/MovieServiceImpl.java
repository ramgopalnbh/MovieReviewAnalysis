package com.mra.services.Impl;

import com.mra.entities.Movie;
import com.mra.exception.ResourceNotFoundException;
import com.mra.repositories.MovieRepository;
import com.mra.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository repository;
    @Override
    public Movie addMovie(Movie movie) {
        return repository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    @Override
    public Optional<Movie> getMovie(Long movieId) {
        return Optional.ofNullable(repository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("Movie with given id not found on server..!!")));
    }
}
