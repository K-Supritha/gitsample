package com.example.controller;
import java.util.List;
import com.example.exceptions.IdNotFoundException;
import com.example.service.TheatreService;
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
import com.example.entity.Theatre;

@RestController
@RequestMapping("/theatres")
//@CrossOrigin("http://localhost:4200")
public class TheatreController {
	@Autowired
	TheatreService serviceobj;

	// Create Employee
	@PostMapping("/TheatreCreation")
	public ResponseEntity<String> theatreCreation(@RequestBody Theatre thea) {
		Theatre t = serviceobj.theatreCreation(thea);
		if (t == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("Theatre created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Get Particular Employee Data
	@GetMapping("/GetTheatre/{theatreId}")
	private ResponseEntity<Theatre> getTheatre(@PathVariable("theatreId") int theatreId) {
		Theatre t = serviceobj.getTheatreByTheatreId(theatreId);
		if (t == null) {
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		} else {
			return new ResponseEntity<Theatre>(t, new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Get All Employees Data
	@GetMapping("/GetAllTheatres")
	private ResponseEntity<List<Theatre>> getAllTheatre() {
		List<Theatre> thealist = serviceobj.getAllTheatre();
		return new ResponseEntity<List<Theatre>>(thealist, new HttpHeaders(), HttpStatus.OK);

	}

	// Updating Employee data
	@PutMapping("/UpdateTheatre")
	public ResponseEntity<String> updateTheatre(@RequestBody Theatre Thea) {
		Theatre t = serviceobj.updateTheatre(Thea);
		if (t == null) {
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Theatre updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	// Deleting Employee
	@DeleteMapping("/DeleteTheatre/{theatreId}")
	private ResponseEntity<String> delThea(@PathVariable("theatreId") int theatreId) {
		Theatre t = serviceobj.delete(theatreId);
		if (t == null) {
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Theatre deleted successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException t) {
		return new ResponseEntity<String>(t.getMessage(), HttpStatus.NOT_FOUND);
	}
}
