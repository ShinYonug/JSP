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

	<h1>�˻� ���� ���� ������</h1><br>
	<h2>�˻� ������ �����ϼ���</h2><br>
		<form action="WebSite.jsp" method="post">
			<select name="site" >
				<option value="http://www.naver.com">���̹�</option>
				<option value="http://www.daum.net">����</option>
				<option value="http://www.nate.com">����Ʈ</option>
			</select>
					<input type="submit" value="Ȯ��" ></submit>
		</form>
</body>
</html>