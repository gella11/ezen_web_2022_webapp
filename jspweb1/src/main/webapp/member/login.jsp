<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3> 회원가입 페이지 </h3>	
	<form action="/jspweb/member/login" method="post">	
		아이디 	: <input type="text" 	 name = "mid">				<br>
		비밀번호 	: <input type="password" name = "mpassword">		<br>
		<input type="submit" value="로그인">
	</form>
	
</body>
</html>