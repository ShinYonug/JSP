<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    response.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>검색 엔진 정보 페이지</h1><br>
	<h2>검색 엔진을 선택하세요</h2><br>
		<form action="WebSite.jsp" method="post">
			<select name="site" >
				<option value="http://www.naver.com">네이버</option>
				<option value="http://www.daum.net">다음</option>
				<option value="http://www.nate.com">네이트</option>
			</select>
					<input type="submit" value="확인" ></submit>
		</form>
</body>
</html>