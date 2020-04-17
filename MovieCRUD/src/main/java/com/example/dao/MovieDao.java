package com.example.dao;

import java.util.List;

import com.example.entity.Movie;

public interface MovieDao {

	Movie deleteByMovieId(int movieId);

	List<Movie> getAllMovie();

	Movie getMovieByMovieId(int movieId);

	Movie movieCreation(Movie mov);

	Movie updateMovie(Movie mov);
}
