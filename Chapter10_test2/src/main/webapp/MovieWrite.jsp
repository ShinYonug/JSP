<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" name="frm">
	<table>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" ></td>
		</tr>
		<tr>
			<th>가격</th>
			<td><input type="text" name="price" ></td>
		</tr>
		<tr>
			<th>감독</th>
			<td><input type="text" name="director" ></td>
		</tr>
		<tr>
			<th>배우</th>
			<td><input type="text" name="actor" ></td>
		</tr>
		<tr>
			<th>설명</th>
			<td><textarea cols="80" rows="10" name="synopsis"></textarea></td>
		</tr>
		<tr>
			<th>사진</th>
			<td><input type="file" name="poster"></td>
		</tr>
		<tr>	
		 	<td colspan="2">
			<input type="submit" value="전송">
			<input type="reset" value="취소">
			<input type="button" value="목록" onclick="location.href='MovieList.do'">
		</tr>
	</table>
</form>
</body>
</html>