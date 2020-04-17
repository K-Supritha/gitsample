package com.example.dao;

import java.util.List;


import com.example.entity.Theatre;

public interface TheatreDao {

 Theatre deleteByTheatreId(int theatreId);

	List<Theatre> getAllTheatre();

	Theatre getTheatreByTheatreId(int theatreId);

	Theatre theatreCreation(Theatre thea);

	Theatre updateTheatre(Theatre thea);
}
