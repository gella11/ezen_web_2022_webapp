<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file="../header.jsp" %>
	<!-- 로그인한 회원 아이디 숨기기 -->
	<input type="hidden" class="mid" value="<%=loginid%>">
	
	
	<div class="webbox">
		<h3> 채팅 </h3>
		
		<div class="contentbox"> </div><!-- 받은 메시지 출력 구역 -->
		
		<textarea rows="" cols="" class="msgbox" onkeyup="enterkey()"></textarea>
		
		<button type="button" onclick="send()"> 보내기 </button>
	
	</div>
	
	<script type="text/javascript" src="../js/board/chatting.js"></script>
	

</body>
</html>