<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.PrintWriter" %>
<%!
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "scott";
	String pass = "tiger";
	
	String sql  = "select * from employee";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
 <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<table class="table">
	  <thead>
      <tr>
        <th>이름</th>
        <th>주소</th>
        <th>SSN</th>
      </tr>
    </thead>
<%
request.setCharacterEncoding("UTF-8");

String name = request.getParameter("name");
String address = request.getParameter("address");
String ssn = request.getParameter("ssn");

try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url,uid,pass);
	pstmt = conn.prepareStatement(sql);
// 	pstmt.setString(1, name);
// 	pstmt.setString(2, address);
// 	pstmt.setString(3, ssn);
// 	pstmt.executeUpdate();
	rs = pstmt.executeQuery(sql);
	/* while(rs.next()){
		out.println("<tr>");
		out.println("<td>" + rs.getString("name") + "</td>");
		out.println("<td>" + rs.getString("address") + "</td>");
		out.println("<td>" + rs.getString("ssn") + "</td>");
		out.println("</tr>");
	} */
	while(rs.next()){
%>
	<tbody>
		<tr class="table-primary">
			<td><%= rs.getString(1) %> </td>
			<td><%= rs.getString(2) %> </td>
			<td><%= rs.getString(3) %> </td>
		</tr>	
	</tbody>
<%
	}
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}catch(Exception e){
		e.printStackTrace();
	}
}
%>
	</table>
</body>
</html>