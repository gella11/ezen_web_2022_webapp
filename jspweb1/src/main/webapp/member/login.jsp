<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head profile="http://www.w3.org/2005/10/profile">
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	
	<%@include file="../header.jsp" %>
	<div class="webbox">
		<h3> 로그인 페이지[form (동기식) 전송] </h3>			
		<!-- <form action="/jspweb/member/login" method="post">	
			아이디 	: <input type="text" 	 name = "mid">				<br>
			비밀번호 	: <input type="password" name = "mpassword">		<br>
			<input type="submit" value="로그인">
		</form> -->
		
		<h3> 로그인 페이지[js ajax(비동기식)전송] </h3>	
			아이디 	: <input type="text" 	 id = "mid">				<br>
			비밀번호 	: <input type="password" id = "mpassword">			<br>
			<div id="loginconfirmbox"> </div>
			<input type="submit" onclick="login()" value="로그인">
			
		<ul>
			<li> <a href="signup.jsp">회원가입</a> </li>
			<li> <a href="findid.jsp">아이디찾기</a> </li>
			<li> <a href="findpassword.jsp">비밀번호찾기</a> </li>
		</ul>
			
	</div>
	<script  src="../../Jquery/prettify.js"></script>
	<script  src="../Jquery/jquery.multiselect.js"></script>
	<script type="text/javascript" src="../js/member/login.js"></script>
	
</body>
</html>