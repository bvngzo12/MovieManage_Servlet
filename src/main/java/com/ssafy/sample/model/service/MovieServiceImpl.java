package com.ssafy.sample.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.dto.Movie;
import com.ssafy.sample.model.dao.*;


public class MovieServiceImpl implements MovieService {
	
	MovieDao movieDao = new MovieDaoImpl();
	
	@Override
	public List<Movie> selectAll() throws SQLException {
		return movieDao.selectAll();
	}

	@Override
	public Movie selectByCode(String code) throws SQLException {
		return movieDao.selectByCode(code);
	}

	@Override
	public int insert(Movie movie) throws SQLException {
		return movieDao.insert(movie);
	}

	@Override
	public int deleteByCode(String code) throws SQLException {
		return movieDao.deleteByCode(code);
	}

	@Override
	public int update(Movie movie) throws SQLException {
		return movieDao.update(movie);
	}

}
