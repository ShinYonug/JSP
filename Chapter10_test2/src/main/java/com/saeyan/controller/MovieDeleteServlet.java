package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MovieDAO;
import com.saeyan.dto.MovieVO;

@WebServlet("/MovieDelete.do")
public class MovieDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String code = request.getParameter("code");
		MovieDAO mDao = MovieDAO.getInstance();
		MovieVO vo = mDao.DeleteMovie(code);

		request.setAttribute("Movie", vo);
		response.sendRedirect("MovieList.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//post 로 넘어오는 경우는 데이터를 post로 넘기는 경우이기에
	
	}

}
