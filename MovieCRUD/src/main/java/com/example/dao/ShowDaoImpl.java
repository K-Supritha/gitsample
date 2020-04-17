package com.example.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Show;
@Repository
public class ShowDaoImpl implements ShowDao {

	@PersistenceContext	
	 EntityManager sh;
	
	@Override
	public Show showCreation(Show sho) {
		// TODO Auto-generated method stub
		Show s=sh.merge(sho);
		return s;
	}
	
	@Override
	public Show getShowByShowId(int showId) {
		
		return sh.find(Show.class,showId);
	}
	
	@Override
	public List<Show> getAllShow() {
		Query q=sh.createQuery("select m from Show m");
		List<Show> sholist=q.getResultList();
		return sholist;
	}
	
	@Override
	public Show updateShow(Show sho) {
		Show s=sh.find(Show.class,sho.getShowId());
		if(s!=null)
		{
			s.setShowId(sho.getShowId());
			s.setShowStartTime(sho.getShowStartTime());
			s.setShowEndTime(sho.getShowEndTime());
			s.setShowName(sho.getShowName());
		}
		return s;
		
	}
	@Override	
	public Show deleteByShowId(int showId) {
		Show s=sh.find(Show.class,showId);
		if(s!=null)
			{sh.remove(s);
			}
        return s;
	}
}