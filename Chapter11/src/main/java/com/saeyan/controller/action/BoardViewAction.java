package com.saeyan.controller.action;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardViewAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
								throws ServerException, IOException, ServletException{
		String url = "/board/boardView.jsp";
		int result = 0 ;
		String num = request.getParameter("num");
		BoardDAO bDao = BoardDAO.getInstance();
		
		result = bDao.updateReadCount(num);

		BoardVO vo = bDao.SelectOneBoardByNum(num);
		request.setAttribute("board", vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}
}