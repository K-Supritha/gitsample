package com.example.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Movie;
@Repository
public class MovieDaoImpl implements MovieDao {

	@PersistenceContext	
	 EntityManager mo;
	
	@Override
	public Movie movieCreation(Movie mov) {
		// TODO Auto-generated method stub
		Movie e=mo.merge(mov);
		return e;
	}
	
	@Override
	public Movie getMovieByMovieId(int movieId) {
		
		return mo.find(Movie.class,movieId);
	}
	
	@Override
	public List<Movie> getAllMovie() {
		Query q=mo.createQuery("select m from Movie m");
		List<Movie> movlist=q.getResultList();
		return movlist;
	}
	
	@Override
	public Movie updateMovie(Movie mov) {
		Movie e=mo.find(Movie.class,mov.getMovieId());
		if(e!=null)
		{
			e.setMovieId(mov.getMovieId());
			e.setMovieName(mov.getMovieName());
			e.setMovieGenre(mov.getMovieGenre());
			e.setMovieDirector(mov.getMovieDirector());
			e.setMovieLength(mov.getMovieLength());
			e.setLanguages(mov.getLanguages());
			e.setMovieReleaseDate(mov.getMovieReleaseDate());
		}
		return e;
			
	}
	@Override	
	public Movie deleteByMovieId(int movieId) {
		Movie e=mo.find(Movie.class,movieId);
		if(e!=null)
			{mo.remove(e);
			}
        return e;
	}
}
