<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="../css/signup.css">
	
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="webbox">
			
		<form class="signupform"action="/jspweb/member/signup" method="post">
		
		<h2 class="pagetitle"> 회원가입</h2>
		
		<h3 class="parttitle"> 기본정보 </h3>
		
		<table class="signuptable">
			<tr>
				<td class="col1"> 아이디* </td>
				<td class="col2"> <input type="text" name = "mid"  id="mid" onkeyup="mevent1()">  </td>
				<td class="col3"> </td>
			</tr>
			<tr>
				<td class="col1"> 비밀번호* </td>
				<td class="col2"> <input type="password" name = "mpassword" id="mpassword" onkeyup="mevent2()">  </td>
				<td rowspan="2" class="col3"> </td>
			</tr>
			<tr>
				<td class="col1"> 비밀번호 확인* </td>
				<td class="col2"> <input type="password" name = "mpasswordconfirm" id="mpasswordconfirm" onkeyup="mevent3()">  </td>
			</tr>		
			<tr>
				<td class="col1"> 이름* </td>
				<td class="col2"> <input type="text" 	 name = "mname" id="mname" onkeyup="mevent4()">  </td>
				<td class="col3"> </td>
			</tr>
			<tr>
				<td class="col1"> 전화번호* </td>
				<td class="col2"> <input type="text" 	 name = "mphone" id="mphone" onkeyup="mevent5()">  </td>
				<td class="col3"> </td>
			</tr>
			<tr>
				<td class="col1"> 이메일* </td>
				<td class="col2"> <input type="text" 	 name = "memail" id="memail" onkeyup="mevent6()">  </td>
				<td class="col3"> </td>
			</tr>
			<tr>
				<td rowspan="2" class="col1" > 주소 * </td>
				<td colspan="2" class="col2"> 
					<span>
						<input type="text" id="sample4_postcode" placeholder="우편번호" name="maddress1">
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
					</span>
					<span>
						<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="maddress2">
						<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="maddress3">
					</span>
				</td>
			</tr>
			<tr>
				<td class="col2"> <input type="text" id="sample4_detailAddress" placeholder="상세주소" name="maddress4"> </td>
				<td class="col3"> 사용중인 아이디 입니다. </td>
			</tr>
		</table>
		
		<h3 class="parttitle"> 이용약관 </h3>
		<span class="confirmbox">
			<textarea readonly="readonly">	</textarea>
			<input id="confirm1" type="checkbox" > <span> [필수] 이용약관 동의</span>
			<textarea readonly="readonly">	</textarea>
			<input id="confirm2" type="checkbox"> <span> [필수] 개인정보 수집 및 이용 동의</span>
		</span>
		
		
		<div class="signupbtnbox">
			<button type="reset">취소</button>
			<button type="button" onclick="formsubmit()">회원가입</button>
		</div>
			
			<!-- 아이디 	: <input type="text" 	 name = "mid">				<br>
			비밀번호 	: <input type="password" name = "mpassword">		<br>
			비밀번호확인	: <input type="password" name = "mpasswordconfirm">	<br>
			이름 	 	: <input type="text" 	 name = "mname">			<br>
			전화번호 	: <input type="text" 	 name = "mphone">			<br>
			이메일 	: <input type="text" 	 name = "memail">			<br>
			
			 카카오 우편  
			<input type="text" id="sample4_postcode" placeholder="우편번호" name="address1">
			<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" ><br>
			<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="address2">
			<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="address3">
			<span id="guide" style="color:#999;display:none"></span>
			<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="address4">
			
			 주소 		: <input type="text" 	 name = "maddress">			<br>
	
			<input type="submit" value="회원가입"> -->
			
		</form>
	</div>
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