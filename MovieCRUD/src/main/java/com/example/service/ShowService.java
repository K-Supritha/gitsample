package com.example.service;

import java.util.List;

import com.example.entity.Show;

public interface ShowService {

	Show showCreation(Show sho);

	Show getShowByShowId(int showId);

	List<Show> getAllShow();

	Show delete(int showId);

	Show updateShow(Show sho);

}