<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>정보 수정</h1>
	<form method="post"  encType="multipart/form-data" name="frm">
		<input type="hidden" name="code" value="${Movie.code }">
		<input type="hidden" name="nonmakeImg" value="${Movie.poster }">     <!-- //why? -->
	<table>
		<tr>
			<td>
				<c:choose>
					<c:when test="${empty Movie.poster }">
						<img src="images/noimage.gif">
					</c:when>
					<c:otherwise>
						<img src="images.${Movie.poster }">
					</c:otherwise>
				</c:choose>
			</td>
			<td>
				<table>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" value="${Movie.title }"></td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input type="text" name="price" value="${Movie.price}"></td>
					</tr>
					<tr>
						<th>감독</th>
						<td><input type="text" name="director" value="${Movie.director }"></td>
					</tr>
					<tr>
						<th>배우</th>
						<td><input type="text" name="actor" value="${Movie.actor}"></td>
					</tr>
					<tr>
						<th>설명</th>
						<td><input type="text" name="synopsis" value="${Movie.synopsis }"></td>
					</tr>
					<tr>
						<th>사진</th>
						<td><input type="file" name="poster" ></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
		<br>
		<input type="submit" value="저장">
		<input type="button" value="목록" onclick="location.href='MovieList.do'">
	</form>
</body>
</html>