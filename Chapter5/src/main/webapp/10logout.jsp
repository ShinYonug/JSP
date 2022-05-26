<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
session.invalidate();
%>
<script>
	alert("로그 아웃 되었습니다.");
	location.href="10loginForm.jsp";     //자바스크립트에서 페이지 이동할때 쓰는 식 location.href="";
</script>

</body>
</html>