<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 
<c:if test="${ empty loginUser}">
	<jsp:forward page='login.do'></jsp:forward>
</c:if>
뭐징 이게 흠 --%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 전용 페이지</h2>
	<form action="logout.do">
		<table>
			<tr>
				<td>안녕하세요.${loginUser.name }(${loginUser.userid} })</td>
			</tr>
			<tr>
				<td colspan="2" align ="center">
				<input type = "submit" value="로그아웃">
				<input type = "button" value="회원정보변경" onclick="location.href='memberUpdate.do?userid=${loginUser.userid}'">
			</tr>
			
		</table>
	
	</form>

</body>
</html>