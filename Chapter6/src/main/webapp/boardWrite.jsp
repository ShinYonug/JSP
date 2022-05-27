<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
 request.setCharacterEncoding("UTF-8");
 %>   
 <jsp:useBean id="BoardBean" class="com.mission.javabeans.BoardBean" />
<jsp:setProperty name="BoardBean" property="*" />
<jsp:setProperty name="BoardBeans" property="*" type="textarea">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table tr td:first-child {font-weight :bold;}
td { border: 1px solid;}
table { border : 1px solid;}
</style>
</head>
<body>
	<h2>입력 완료된 정보</h2>
	<table>
		<tr>
			<td>작성자</td>
			<td><jsp:getProperty property="name" name="BoardBean"/></td>
			<td><%= BoardBean.getName() %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><jsp:getProperty property="pass" name="BoardBean"/></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><jsp:getProperty property="email" name="BoardBean"/></td>
		</tr>
		<tr>
			<td>글제목</td>
			<td><jsp:getProperty property="title" name="BoardBean"/></td>
		</tr>
		<tr>
			<td>글내용</td>
			<td><jsp:getProperty property="content" name="BoardBeans"/></td>
		</tr>
	</table>

</body>
</html>