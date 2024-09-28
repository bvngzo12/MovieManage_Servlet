package com.ssafy.sample.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.dto.Movie;
import com.ssafy.sample.model.service.MovieService;
import com.ssafy.sample.model.service.MovieServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/movie.do")
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieService movieService = new MovieServiceImpl();
	private String uri = "index.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) {
		try {
			String act = request.getParameter("act");
			
			if("init".equals(act)) {
				uri = "index.jsp";
			}else if("list".equals(act)) {
				uri = movieList(request, response);
			}
			else if("registform".equals(act)) {
				uri = movieRegistForm(request, response);
			}else if("regist".equals(act)) {
				uri = movieRegist(request, response);
			}else if("detail".equals(act)) {
				uri = movieDetail(request, response);
			}else if("update".equals(act)) {
				uri = updateMovie(request, response);
			}else if("delete".equals(act)) {
				uri = deleteMovie(request, response);
			}else if("deleteSelected".equals(act)) {
				uri = deleteSelected(request, response);
			}
			

			if(uri.startsWith("redirect")) {
				uri = uri.substring(uri.indexOf(":")+1);
				sendRedirect(request,response,uri);
			}else {
				forward(request,response, uri);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}

	private String deleteSelected(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String[] code = request.getParameterValues("chk");		
		
		for(String c : code) {
			movieService.deleteByCode(c);
		}
		
		return "redirect:/movie.do?act=list";
	}

	private String deleteMovie(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String code = request.getParameter("code");		
		movieService.deleteByCode(code);
		
		return "redirect:/movie.do?act=list";
	}

	private String updateMovie(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String code = request.getParameter("code");
		String title = request.getParameter("title");
		int time = Integer.parseInt(request.getParameter("time"));
		String director = request.getParameter("director");
		String genre = request.getParameter("genre");
		
		Movie movie = new Movie(code,title,time,director,genre);
		
		movieService.update(movie);
		
		return "redirect:/movie.do?act=list";
	}

	private String movieDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String code = request.getParameter("code");
		Movie movie = movieService.selectByCode(code);
		
		request.setAttribute("movie", movie);
		return "/movie/detail.jsp";
	}

	private String movieRegist(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String code = request.getParameter("code");
		String title = request.getParameter("title");
		int time = Integer.parseInt(request.getParameter("time"));
		String director = request.getParameter("director");
		String genre = request.getParameter("genre");
		
		Movie movie = new Movie(code,title,time,director,genre);
		movieService.insert(movie);
		
		return "redirect:/movie.do?act=list";
	}

	private String movieRegistForm(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/movie/regist.jsp";
	}


	private String movieList(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		List<Movie> list = movieService.selectAll();
		request.setAttribute("movies", list);
		return "/movie/list.jsp";
	}
	
	private void sendRedirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath()+path);
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	
	
}
