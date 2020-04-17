package com.example.controller;

import java.util.List;

import com.example.exceptions.IdNotFoundException;
import com.example.service.MovieService;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Movie;

@RestController
@RequestMapping("/movies")
//@CrossOrigin("http://localhost:4200")
public class MovieController {
	@Autowired
	MovieService serviceobj;

	// Create Movie
	@PostMapping("/MovieCreation")
	public ResponseEntity<String> movieCreation(@RequestBody Movie mov) {
		Movie e = serviceobj.movieCreation(mov);
		if (e == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("Movie created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Get Particular Movie Data
	@GetMapping("/GetMovie/{movieId}")
	private ResponseEntity<Movie> getMovie(@PathVariable("movieId") int movieId) {
		Movie e = serviceobj.getMovieByMovieId(movieId);
		if (e == null) {
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		} else {
			return new ResponseEntity<Movie>(e, new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Get All Movies Data
	@GetMapping("/GetAllMovies")
	private ResponseEntity<List<Movie>> getAllMovie() {
		List<Movie> movlist = serviceobj.getAllMovie();
		return new ResponseEntity<List<Movie>>(movlist, new HttpHeaders(), HttpStatus.OK);

	}

	// Updating Movie data
	@PutMapping("/UpdateMovie")
	public ResponseEntity<String> updateMovie(@RequestBody Movie mov) {
		Movie e = serviceobj.updateMovie(mov);
		if (e == null) {
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Movie updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Deleting Movie
	@DeleteMapping("/DeleteMovie/{movieId}")
	private ResponseEntity<String> delMov(@PathVariable("movieId") int movieId) {
		Movie e = serviceobj.delete(movieId);
		if (e == null) {
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Movie deleted successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
