<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="SelectServlet">
	<span style="float: left; margin-right:20px">
	<label for="job">직업</label>
	<select id="job" name="job" size="1">
		<option value=""> 선택하세요</option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
	</select>
	</span>
	
	<label for="interest" style="float: left;">관심분야</label>
	<select id="interest" name="interest" size='5'	multiple="multiple">
		<option value="에스프레소">에스프레소</option>
		<option value="1">1</option> 
		<option value="2">2</option> 
		<option value="3">3</option> 
		<option value="4">4</option> 
		<option value="5">5</option>
		 
	</select>
	<br><br>
	<input type="submit" value="전송" style="float:right; margin-right:50px">
</form>
</body>
</html>