package com.example.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.example.entity.Theatre;
@Repository
public class TheatreDaoImpl implements TheatreDao {
	@PersistenceContext	
	 EntityManager th;
	@Override
	public Theatre theatreCreation(Theatre thea) {
		// TODO Auto-generated method stub
		Theatre t=th.merge(thea);
		return t;
	}
	@Override
	public Theatre getTheatreByTheatreId(int theatreId) {
		return th.find(Theatre.class,theatreId);
	}
	@Override
	public List<Theatre> getAllTheatre() {
		Query q=th.createQuery("select m from Theatre m");
		List<Theatre> thealist=q.getResultList();
		return thealist;
	}
	@Override
	public Theatre updateTheatre(Theatre thea) {
		Theatre t=th.find(Theatre.class,thea.getTheatreId());
		if(t!=null)
		{
			t.setTheatreId(thea.getTheatreId());
			t.setTheatreName(thea.getTheatreName());
			t.setTheatreCity(thea.getTheatreCity());
			t.setManagerName(thea.getManagerName());
			t.setManagerContact(thea.getManagerContact());
			//t.setManagerContact(thea.getManagerContact());
			//e.setPhonenumber(Thea.getPhonenumber());
			//e.setCompany(Thea.getCompany());
		}
		return t;
			
	}
	@Override	
	public Theatre deleteByTheatreId(int theatreId) {
		Theatre t=th.find(Theatre.class,theatreId);
		if(t!=null)
			{th.remove(t);
			}
        return t;
	}
}
