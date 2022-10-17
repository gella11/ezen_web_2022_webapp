<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<h3> 게시판 글쓰기 </h3>	
		
		제목 		: <input type="text" 	 id = "btitle">			<br>
		내용 	 	: <input type="text" 	 id = "bcontent">		<br>
		이름 		: <input type="text" 	 id = "bname">			<br>
		비밀번호 	: <input type="password" id = "bpassword">		<br>
		<input type="submit" onclick="registration()" value="글등록">
	
	
	
	<div >
		<h3> 글 목록</h3>
		<table id="boardlist">
		</table>
	</div>
	<div >
		<h3> 해당 글</h3>
		<table id="view">
			
		</table>
	</div>
	
	
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="../js/board.js"></script>
	
	
	
</body>
</html>