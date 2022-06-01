package unit05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		
		PrintWriter out = response.getWriter()	;
		out.print("<html><body>");
		out.print("당신이 입력한 정보입니다.<br>");
		out.println("아 이 디 : ");
		out.println(id);
		out.println("<br>나 이 :");
		out.println(age);
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");   //이전 페이지로 돌아감
		out.print("</body></html>");
		out.close()	;
		
	
	}

}
