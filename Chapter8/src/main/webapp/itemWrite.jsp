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
	
	String sql  = "select * from item";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
</style>
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">입력 완료된 정보</h2>
	<table border="1"  class="table" style="width:1000px; margin:0 auto;" >
		<tr >>
			<td width="10"><b>상품</b></td> 
			<td width="20"><b>갸격</b></td>
			<td width="40"><b>설명</b></td>
		</tr>
<%
request.setCharacterEncoding("UTF-8");

String name = request.getParameter("name");
String price = request.getParameter("price");
String description = request.getParameter("description");

try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url,uid,pass);
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	
	while(rs.next()){
%>
	
		<tr class="table-primary">
			<td><%= rs.getString(1) %> </td>
			<td><%= rs.getInt(2) %> </td>
			<td><%= rs.getString(3) %> </td>
		</tr>
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