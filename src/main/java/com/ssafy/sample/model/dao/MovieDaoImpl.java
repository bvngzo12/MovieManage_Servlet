package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.sample.dto.Movie;
import com.ssafy.sample.util.DBUtil;

public class MovieDaoImpl implements MovieDao {
	
	@Override
	public List<Movie> selectAll() throws SQLException {
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "select mcode as code, mtitle as title, mtime as time, mdirector as director, mgenre as genre from movies";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		List<Movie> list = new ArrayList();
		while(rs.next()) {
			String code = rs.getString("code");
			String title = rs.getString("title");
			int time = rs.getInt("time");
			String director = rs.getString("director");
			String genre = rs.getString("genre");
			
			Movie movie = new Movie(code,title,time,director,genre);
			list.add(movie);
		}
		DBUtil.getInstance().close(conn);
		
		return list;
	}

	@Override
	public Movie selectByCode(String code) throws SQLException {
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "select mcode as code, mtitle as title, mtime as time, mdirector as director, mgenre as genre from movies where mcode = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, code);
		ResultSet rs = pstmt.executeQuery();
		
		Movie movie = null;
		
		if(rs.next()) {
			String target_code = rs.getString("code");
			String title = rs.getString("title");
			int time = rs.getInt("time");
			String director = rs.getString("director");
			String genre = rs.getString("genre");
			
			movie = new Movie(target_code,title,time,director,genre);
		}
		
		DBUtil.getInstance().close(conn);
		return movie;
	}

	@Override
	public int insert(Movie product) throws SQLException {
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "insert into movies values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, product.getCode());
		pstmt.setString(2, product.getTitle());
		pstmt.setInt(3, product.getTime());
		pstmt.setString(4, product.getDirector());
		pstmt.setString(5, product.getGenre());
		
		int res = pstmt.executeUpdate();
		DBUtil.getInstance().close(conn, pstmt);
		return res;
	}

	@Override
	public int deleteByCode(String code) throws SQLException {
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "delete from movies where mcode = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, code);
		
		int res = pstmt.executeUpdate();
		DBUtil.getInstance().close(conn, pstmt);
		return res;
	}

	@Override
	public int update(Movie product) throws SQLException {
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "update movies set mtitle = ?, mtime = ?, mdirector = ?, mgenre = ? where mcode = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(5, product.getCode());
		pstmt.setString(1, product.getTitle());
		pstmt.setInt(2, product.getTime());
		pstmt.setString(3, product.getDirector());
		pstmt.setString(4, product.getGenre());
		
		int res = pstmt.executeUpdate();
		DBUtil.getInstance().close(conn, pstmt);
		return res;
	}

}
