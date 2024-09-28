package com.ssafy.sample.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieController
 */
@WebServlet("/movie")
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//톰캣 10버전부터는 post에서 한글 인코딩 안해도 문제 없음
//		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	
}
