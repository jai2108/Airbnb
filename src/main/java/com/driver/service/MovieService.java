package com.driver.service;

import com.driver.model.Director;
import com.driver.model.Movie;
import com.driver.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie){
     movieRepository.addMovie(movie);
    }

    public void addDirector( Director director){
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movieName, String directorName){

        movieRepository.addMovieDirectorPair(movieName,directorName);
    }

    public Movie getMovieByName(String movieName){

        Movie movie = movieRepository.getMovieByName(movieName);
        return movie;
    }
}
