package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Show;
import com.example.dao.ShowDaoImpl;

@Service
@Transactional
public class ShowServiceImpl implements ShowService 
{
@Autowired
ShowDaoImpl dao;


@Override
public Show showCreation(Show sho) {
	return dao.showCreation(sho);
}

@Override
public Show getShowByShowId(int showId) 
{
return dao.getShowByShowId(showId);
}

@Override
public List<Show> getAllShow() 
{
return dao.getAllShow();
}

@Override
public Show delete(int showId) 
{
	return dao.deleteByShowId(showId);
}

@Override
public Show updateShow(Show sho) {
	return dao.updateShow(sho);	
}

}
