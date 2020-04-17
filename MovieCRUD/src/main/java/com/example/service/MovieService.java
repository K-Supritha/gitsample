package com.example.service;

import java.util.List;

import com.example.entity.Movie;

public interface MovieService {

	Movie movieCreation(Movie mov);

	Movie getMovieByMovieId(int movieId);

	List<Movie> getAllMovie();

	Movie delete(int movieId);

	Movie updateMovie(Movie mov);

}