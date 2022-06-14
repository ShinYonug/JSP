package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.MovieDAO;
import com.saeyan.dto.MovieVO;

@WebServlet("/MovieWrite.do")
public class MovieWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		RequestDispatcher dispacher = request.getRequestDispatcher("MovieWrite.jsp");
		dispacher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	request.setCharacterEncoding("utf-8");
	ServletContext context = getServletContext(); // 서블릿 컨텍스트를 불러와서 컨텍스트에 저장
	String path= context.getRealPath("upload"); // 컨텍스트 안에실경로를 저장
	String encType = "UTF-8";// 인코딩 타입
	int sizeLimit = 20 * 1024 * 1024;//사진 최대사이즈
	
	MultipartRequest multi = new MultipartRequest(request, path, sizeLimit,  encType, new DefaultFileRenamePolicy());
	String title= multi.getParameter("title");
	int price = Integer.parseInt(multi.getParameter("price"));
	String director = multi.getParameter("director");
	String actor = multi.getParameter("actor");
	String poster = multi.getParameter("poster");
	String synopsis = multi.getParameter("synopsis");
	
	MovieVO vo = new MovieVO();
	vo.setTitle(title);
	vo.setPrice(price);
	vo.setDirector(director);
	vo.setActor(actor);
	vo.setPoster(poster);
	vo.setSynopsis(synopsis);
	
	MovieDAO mDao = MovieDAO.getInstance();
	int result = mDao.inserMovie(vo);
	if( result == 1) { response.sendRedirect("MovieList.do");}
	else { response.sendRedirect("MovieWrite.do");
	}
		
	
	}
}
