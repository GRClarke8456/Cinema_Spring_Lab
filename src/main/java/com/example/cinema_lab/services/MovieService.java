package com.example.cinema_lab.services;

import com.example.cinema_lab.models.Movie;
import com.example.cinema_lab.models.Reply;
import com.example.cinema_lab.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;


    private ArrayList<Movie> movies;


    public List<Movie> displayAllCurrentMovieListings(){
        return movieRepository.findAll();
    }

    public Optional<Movie> findMovieById(int id){
        return movieRepository.findById(id);
    }

//    public Reply addNewMovie(Movie movieListing, int id){
//        Movie movie = movieRepository.findById(id).get();
//        this.movies.add(movieListing);
//        movieRepository.save(movie);
//        return new Reply("Add a new movie");
//    }

//    Review's code
    public Movie saveNewMovie(Movie movie){
        movieRepository.save(movie);
        return movie;
    }




}