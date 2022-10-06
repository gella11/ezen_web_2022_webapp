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
	<form action="/jspweb/member/signup" method="post">	
		아이디 	: <input type="text" 	 name = "mid">				<br>
		비밀번호 	: <input type="password" name = "mpassword">		<br>
		비밀번호확인	: <input type="password" name = "mpasswordconfirm">	<br>
		이름 	 	: <input type="text" 	 name = "mname">			<br>
		전화번호 	: <input type="text" 	 name = "mphone">			<br>
		이메일 	: <input type="text" 	 name = "memail">			<br>
		
		<!--  카카오 우편   -->
		<input type="text" id="sample4_postcode" placeholder="우편번호" name="address1">
		<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" ><br>
		<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="address2">
		<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="address3">
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="address4">
		
		<!--  주소 		: <input type="text" 	 name = "maddress">			<br> -->

		<input type="submit" value="회원가입">
	</form>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="../js/member/signup.js"></script>	
	
	


</body>
</html>

<!-- 

	<form> 폼(양식) : 전송기능
		속성
			1. action = "전송을 받을 URL"
			2. method = "전송방식"
				HTTP 전송 메소드
				get  방식
					get --- >> 서블릿(java) doget 메소드
				post 방식
					post --- >> 서블릿(java) dopost 메소드
				
				get 			vs 				post
				변수 URL 표시						변수 URL표시 x
				보안 낮음							보안 높음 [ 회원가입 , 로그인 ]
				캐시(기록)있음						캐시(기록) 없음
				다음 접속시 빠름						다음 접속 속도 똑같음
				[제품상세페이지],유출상관없는 것들			[회원가입,로그인]
				
 -->