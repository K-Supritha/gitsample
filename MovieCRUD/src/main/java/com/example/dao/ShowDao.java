package com.example.dao;

import java.util.List;

import com.example.entity.Show;

public interface ShowDao {

	Show deleteByShowId(int showId);

	List<Show> getAllShow();

	Show getShowByShowId(int showId);

	Show showCreation(Show sho);

	Show updateShow(Show sho);
}
