package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seayan.controller.action.Action;
import com.seayan.controller.action.ActionFactory;

@WebServlet("/Employees.do")
public class EmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String command = request.getParameter("command");

		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
	

		if(action != null)
			action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
