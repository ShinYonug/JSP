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

@WebServlet("/MovieUpdate.do")
public class MovieUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String code = request.getParameter("code");   //코드값을 불러와서 코드에 저장한 후
		MovieDAO mDao = MovieDAO.getInstance();    // 다오 싱글톤으로  인스턴스를 생성하고
	    MovieVO vo = mDao.SelectByCode(code);      // 코드값의 데이터를 호출하는 메소드
	    
	    request.setAttribute("Movie", vo);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("MovieUpdate.jsp");
	   dispatcher.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType="UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		String code = multi.getParameter("code");
		String title = multi.getParameter("title");
		int price = Integer.parseInt(multi.getParameter("price"));
		String director = multi.getParameter("director");
		String actor = multi.getParameter("actor");
		String poster = multi.getParameter("poster");
		String synopsis = multi.getParameter("synopsis");
		if(poster == null)
			poster = multi.getParameter("nonmakeImg");
		
		MovieVO vo = new MovieVO();
		vo.setCode(Integer.parseInt(code));
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setDirector(director);
		vo.setActor(actor);
		vo.setPoster(poster);
		vo.setSynopsis(synopsis);

		MovieDAO mDao = MovieDAO.getInstance();
		int result = mDao.UpdateMovie(vo);
		if(result == 1)
			response.sendRedirect("MovieList.do");
		else
			response.sendRedirect("MovieUpdate.do "); // jsp 로 바로 보내면 code 값이 뭔지를 모르기에 서블릿으로 보내서 vo값을 가지고 jsp로 이동ㅎ나다
		
		
	}

}
