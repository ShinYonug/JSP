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
<style type="text/css">
#b01 { font-weight: bold;}
table tr div { float:right;}
</style>
</head>
<body>
	<h2>정보 등록</h2>
	<form action="movieWriteForm.jsp" method="post">
		<table>
			<tr>
				<td id="b01">제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td id="b01">가격</td>
				<td><input type="text" name="price">원</td>
			</tr>
			<tr>
				<td id="b01">감독</td>
				<td><input type="text" name="director"></td>
			</tr>
			<tr>
				<td id="b01">출연배우</td>
				<td><input type="text" name="actor"></td>
			</tr>
			<tr>
				<td id="b01">시놉시스</td>
				<td><textarea cols="70" rows="20" name="synopsis"></textarea></td>
			</tr>
			<tr>
				<td id="b01">장르</td>
				<td>
					<select name="genre">
						<option value="성인영화" selected>성인영화</option>
						<option value="로맨스">로맨스</option>
						<option value="액션">액션</option>
						<option value="스릴러">스릴러</option>
						<option value="홍콩액션">홍콩액션</option>
						<option value="코미디">코미디</option>
						<option value="느와르">느와르</option>
						<option value="판타지">판타지</option>
						<option value="애니메이션">애니메이션</option>
					</select>
				</td>
			</tr>
			<tr >
					<td ><input   type="submit" value="확인" style="float:right;"><input  type="reset" value="취소" style="float:right;" ></td>
			</tr>
		</table>
	
	</form>
</body>
</html>