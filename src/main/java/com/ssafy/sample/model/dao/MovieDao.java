package com.ssafy.sample.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.dto.Movie;

public interface MovieDao {

	/**
	 * 영화 전체 목록 조회
	 */
	List<Movie> selectAll() throws SQLException;
	
	/**
	 * 영화 상세 조회
	 */
	Movie selectByCode(String code) throws SQLException;
	
	/**
	 * 영화 정보 추가
	 */
	int insert(Movie product) throws SQLException;
	
	/**
	 * 영화 정보 삭제
	 */
	int deleteByCode(String code) throws SQLException;

	/**
	 * 영화 정보 수정
	 */
	int update(Movie product) throws SQLException;
}
