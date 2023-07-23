package com.driver.repository;

import com.driver.model.Director;
import com.driver.model.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movieDb = new HashMap<>();
    HashMap<String,Director> directorDb = new HashMap<>();

    HashMap<String,String> movieDirectorDb = new HashMap<>();
    public void addMovie(Movie movie){
      String key = movie.getName();
      movieDb.put(key,movie);
    }

    public void addDirector( Director director){
        String key = director.getName();
        directorDb.put(key,director);
    }

    public void addMovieDirectorPair(String movieName, String directorName){
       movieDirectorDb.put(movieName,directorName);
    }

    public Movie getMovieByName(String movieName){

        Movie movie = movieDb.get(movieName);
        return movie;
    }
}
