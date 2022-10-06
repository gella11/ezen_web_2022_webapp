<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 게시판 글쓰기 </h3>	
	<form action="/jspweb/board/board"  method="post">	
		제목 		: <input type="text" 	 name = "title">			<br>
		내용 	 	: <input type="text" 	 name = "content">			<br>
		이름 		: <input type="text" 	 name = "bname">			<br>
		비밀번호 	: <input type="password" name = "bpassword">		<br>
		<input type="submit" value="글등록">
	</form>

</body>
</html>