package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Movie;
import com.example.dao.MovieDaoImpl;

@Service
@Transactional
public class MovieServiceImpl implements MovieService 
{
@Autowired
MovieDaoImpl dao;

/* (non-Javadoc)
 * @see com.example.service.EmployeeService#EmployeeCreation(com.example.entity.Employee)
 */
@Override
public Movie movieCreation(Movie mov) {
	return dao.movieCreation(mov);
}

/* (non-Javadoc)
 * @see com.example.service.EmployeeService#getEmployeeById(int)
 */
@Override
public Movie getMovieByMovieId(int movieId) 
{
return dao.getMovieByMovieId(movieId);
}

/* (non-Javadoc)
 * @see com.example.service.EmployeeService#getAllEmployee()
 */
@Override
public List<Movie> getAllMovie() 
{
return dao.getAllMovie();
}

/* (non-Javadoc)
 * @see com.example.service.EmployeeService#delete(int)
 */
@Override
public Movie delete(int movieId) 
{
	return dao.deleteByMovieId(movieId);
}

/* (non-Javadoc)
 * @see com.example.service.EmployeeService#UpdateEmployee(com.example.entity.Employee)
 */
@Override
public Movie updateMovie(Movie mov) {
	return dao.updateMovie(mov);	
}

}