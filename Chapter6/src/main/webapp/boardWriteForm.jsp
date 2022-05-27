<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
request.setCharacterEncoding("UTF-8");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table { border: 1px solid;}
td{ border: 1px solid;}
#box{
	width: 100px;
	font-weight: bold;
	background-color: #e5e5e5;
	text-align: center;
}

</style>

</head>
<body>
	<h1>게시판 글쓰기</h1>
	<form method="post" action="boardWrite.jsp">
		<table>
			<tr>
				<td id="box">작성자</td>
				<td><input type="text" name="name" size="35"></td>
			</tr>
			<tr>
				<td id="box">비밀번호</td>
				<td><input type="password" name="pass" size="35"></td>
			</tr>
			<tr>
				<td id="box">이메일</td>
				<td><input type="text" name="email" size="35"></td>
			</tr>
			<tr>
				<td id="box">글 제목</td>
				<td><input type="text" name="title" size="45"></td>
			</tr>
			<tr>
				<td id="box">글 내용</td>
				<td><textarea cols="60" rows="16" name="content"></textarea></td>
			</tr>
			

		</table>
			<input type="submit" value="등록">
			<input type="reset" value="다시작성">
			
	</form>
</body>
</html>
