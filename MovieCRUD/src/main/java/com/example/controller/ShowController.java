package com.example.controller;

import java.util.List;

import com.example.exceptions.IdNotFoundException;
import com.example.service.ShowService;

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
import com.example.entity.Show;

@RestController
@RequestMapping("/shows")
//@CrossOrigin("http://localhost:4200")
public class ShowController {
	@Autowired
	ShowService serviceobj;

	// Create Show
	@PostMapping("/ShowCreation")
	public ResponseEntity<String> showCreation(@RequestBody Show sho) {
		Show s = serviceobj.showCreation(sho);
		if (s == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("Show created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Get Particular Show Data
	@GetMapping("/GetShow/{showId}")
	private ResponseEntity<Show> getShow(@PathVariable("showId") int showId) {
		Show s = serviceobj.getShowByShowId(showId);
		if (s == null) {
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		} else {
			return new ResponseEntity<Show>(s, new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Get All Shows Data
	@GetMapping("/GetAllShows")
	private ResponseEntity<List<Show>> getAllShow() {
		List<Show> sholist = serviceobj.getAllShow();
		return new ResponseEntity<List<Show>>(sholist, new HttpHeaders(), HttpStatus.OK);

	}

	// Updating Show data
	@PutMapping("/UpdateShow")
	public ResponseEntity<String> updateShow(@RequestBody Show sho) {
		Show s = serviceobj.updateShow(sho);
		if (s == null) {
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Show updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Deleting Show
	@DeleteMapping("/DeleteShow/{showId}")
	private ResponseEntity<String> delSho(@PathVariable("showId") int showId) {
		Show s = serviceobj.delete(showId);
		if (s == null) {
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Show deleted successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException s) {
		return new ResponseEntity<String>(s.getMessage(), HttpStatus.NOT_FOUND);
	}
}