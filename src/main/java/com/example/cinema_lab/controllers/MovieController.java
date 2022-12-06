package com.example.cinema_lab.controllers;

import com.example.cinema_lab.models.Movie;
import com.example.cinema_lab.models.Reply;
import com.example.cinema_lab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;


    @PostMapping
    public ResponseEntity<Reply> newMovie(@RequestBody Movie movie, @PathVariable int id){
        Reply reply = movieService.addNewMovie(movie, id);
        return new ResponseEntity<>(reply, HttpStatus.CREATED);
    }

    @GetMapping("/listings")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.displayAllCurrentMovieListings();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findMovieById (@PathVariable int id){
        Optional<Movie> movie = movieService.findMovieById(id);
        if (movie.isPresent()){
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
