<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% request.setCharacterEncoding("utf-8"); %>
  <jsp:useBean id="movie" class="com.mission.javabeans.MovieBean"></jsp:useBean>
 <jsp:setProperty property="*" name="movie"/>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입력 완료된 정보</h1>
	<table border="1">
		<tr>
			<th>제목</th>
			<td><%= movie.getTitle()%></td>
		</tr>
		<tr>
			<th>가격</th>
			<td><%= movie.getPrice()%></td>
		</tr>
		<tr>
			<th>감독</th>
			<td><%= movie.getDirector()%></td>
		</tr>
		<tr>
			<th>출연배우</th>
			<td><%= movie.getActor()%></td>
		</tr>
		<tr>
			<th>시놉시스</th>
			<td><textarea><%= movie.getSynopsis()%></textarea></td>
		</tr>
		<tr>
			<th>장르</th>
			<td><%= movie.getGenre()%></td>
		</tr>
	
	</table>
</body>
</html>