<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>띠용띠용</title>

	<!-- 뷰포트 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<!--  사용자 정의 css 호출 -->
	<!--  헤더는 모든 페이지에 들어가는 것이기 때문에 절대경로를 써야함 프로젝트부터 써야함 -->
	<link rel="stylesheet" href="/jspweb/css/header.css">
	
	<!-- 폰트 어썸 [ 아이콘 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
	
	
</head>
<body>

	<div class="webbox"> <!-- 상단 헤더 -->
		<div class="hd_top">
			<div><!--  로고 -->
				<span class="hd_title">
					<a href="/jspweb/index.jsp">Ezen shop</a>
				</span>
			</div>
			
			<!--  세션 호출  [JSP방식] 템플릿 마다 다름-->
			<!--  세션 호출  [JSP방식] 템플릿 마다 다름-->
			<!--  세션 호출  [JSP방식] 템플릿 마다 다름-->
			<%
				// JSP 스크립트 태그 ( 태그안에 JAVA 문법 작성 가능 )
				// JSP 세션 객체 제공
				// 형변환
				String loginid = (String)session.getAttribute("mid");
			%>
			
			
			<ul class="hd_sub"><!--  상단 메뉴 -->
			<% if(loginid == null){ // 세션이 없다 --> 로그인 안햇다 %>
				<li> <a href="/jspweb/member/login.jsp" > 로그인 </a> </li>
				<li> <a href="/jspweb/member/signup.jsp" > 회원가입 </a> </li>
			<%}else{ // 세션이 존재한다. --> 로그인 했다. %>
				<li> <%=loginid %>님 안녕하세요 <li>
				<li> <a href="/jspweb/member/logout.jsp"> 로그아웃 </a> </li>
			<%	} %>
				<li> <a href="/jspweb/member/info.jsp" > 마이쇼핑</a> </li>
				<li> <a href="#" > 고객센터 </a> </li>	
			</ul>
		</div>	
	
		
		<ul class="hd_menu"><!-- 하단 헤더 -->
			<li> <a href="#">BIG SIZE</a> </li>
			<li> <a href="#">1+1 이벤트</a> </li>
			<li> <a href="#">아우터</a> </li>
			<li> <a href="#">상의</a> </li>
			<li> <a href="#">바지</a> </li>
			<li> <a href="#">슈즈</a> </li>
			<li> <a href="#">악세사리</a> </li>
			<li> <a href="#">BEST</a> </li>
			<li> <a href="#">트레이닝</a> </li>
			<li> <a href="#">50% 할인</a> </li>
			<li> <a href="#">MUSCLE-FIT</a> </li>
			<li class = "searchbox">
				<span>
					<input>
					<i class="fas fa-search"></i>
				</span>
				<i class="fas fa-cart-plus"></i>
			</li>
		</ul>
	</div>
	
	<!-- JQUERY 라이브러리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	
</body>
</html>


<!-- 
	
	<div>	: 레이아웃, 박스권, 구역[block 한 줄 차지]
	<span>	: inline 한 줄 차지xxxx
	<ul>	: 글머리 리스트 순서x
	

 -->