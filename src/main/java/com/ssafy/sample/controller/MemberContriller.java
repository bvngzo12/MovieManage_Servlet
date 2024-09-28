package com.ssafy.sample.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.ssafy.sample.dto.Member;
import com.ssafy.sample.model.service.MemberService;
import com.ssafy.sample.model.service.MemberServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member.do")
public class MemberContriller extends HttpServlet {
	private MemberService memberService = new MemberServiceImpl();
	private String uri = "index.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) {
		try {
			String act = request.getParameter("act");
			
			if("init".equals(act)) {
				uri = "index.jsp";
			}else if("loginform".equals(act)) {
				uri = loginform(request, response);
			}else if("login".equals(act)) {
				uri = login(request, response);
			}else if("logout".equals(act)) {
				uri = logout(request, response);
			}
			
			//////////////////////////////////////////////

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

	private String logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return "redirect:/member.do?act=loginform";
	}

	private String loginform(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/member/login.jsp";
	}

	private String login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String saved = request.getParameter("save");
		
		Member mem = memberService.login(id, pw);
		
		if(mem != null) {
			request.getSession().setAttribute("member", mem);
			if(saved != null) {
				Cookie cookie = new Cookie("idsaved",id);
				cookie.setMaxAge(60*60*24*3);
				response.addCookie(cookie);
			}else {
				Cookie[] cookies = request.getCookies();
				for (Cookie cookie : cookies) {
					if(cookie.getName().equals("idsaved")) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
						break;
					}
				}
			}
		}
		
		return "redirect:/member.do?act=init";
	}

	private void sendRedirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath()+path);
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
