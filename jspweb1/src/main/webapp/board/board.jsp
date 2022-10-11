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
	<form action="/jspweb/board/board"  method="get">	
		제목 		: <input type="text" 	 name = "title">			<br>
		내용 	 	: <input type="text" 	 name = "content">			<br>
		이름 		: <input type="text" 	 name = "bname">			<br>
		비밀번호 	: <input type="password" name = "bpassword">		<br>
		<input type="submit" onclick="registration"value="글등록">
	</form>
	
	
	<div >
		<h3> 글 목록</h3>
		<table id="boardlisttable">
			
		</table>
		
	</div>
</body>
</html>