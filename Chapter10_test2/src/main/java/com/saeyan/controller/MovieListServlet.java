package com.saeyan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MovieDAO;
import com.saeyan.dto.MovieVO;

/**
 * Servlet implementation class MovieListServlet
 */
@WebServlet("/MovieList.do")
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDAO mDao = MovieDAO.getInstance();
		List<MovieVO> vo = mDao.SellectAllMovies();
		request.setAttribute("MovieList", vo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("MovieList.jsp");
		dispatcher.forward(request, response);
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
