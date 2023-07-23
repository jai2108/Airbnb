package com.driver.controller;

import com.driver.model.Director;
import com.driver.model.Movie;
import com.driver.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")

public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
      movieService.addMovie(movie);
      return new ResponseEntity<>("Added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName") String movieName,
                                                       @RequestParam ("directorName") String directorName){
        movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>("Updated successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){

        Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }



}
