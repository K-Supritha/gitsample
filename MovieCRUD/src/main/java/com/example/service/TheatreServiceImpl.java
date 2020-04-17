package com.example.service;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Theatre;
import com.example.dao.TheatreDaoImpl;
@Service
@Transactional
public class TheatreServiceImpl implements TheatreService 
{
@Autowired
TheatreDaoImpl dao;


@Override
public Theatre theatreCreation(Theatre thea) {
	return dao.theatreCreation(thea);
}


@Override
public Theatre getTheatreByTheatreId(int theatreId) 
{
return dao.getTheatreByTheatreId(theatreId);
}


@Override
public List<Theatre> getAllTheatre() 
{
return dao.getAllTheatre();
}


@Override
public Theatre delete(int theatreId) 
{
	return dao.deleteByTheatreId(theatreId);
}

@Override
public Theatre updateTheatre(Theatre thea) {
	return dao.updateTheatre(thea);	
}

}
