package com.example.service;

import java.util.List;


import com.example.entity.Theatre;

public interface TheatreService {

	Theatre theatreCreation(Theatre Thea);

	Theatre getTheatreByTheatreId(int theatreId);

	List<Theatre> getAllTheatre();

	Theatre delete(int theatreId);

	Theatre updateTheatre(Theatre Thea);

}
