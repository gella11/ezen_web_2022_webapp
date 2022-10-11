<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file ="../header.jsp" %>
	<%
		// JSP 스크립트 태그[ JAVA 작성 공간]
		// 세션 삭제 session.invalidate();
		// 장바구니 등 나머지도 날라가는 경우 있음.
		// session.invalidate();
		
		// 특정 세션만 삭제
		session.setAttribute("mid", null);
		
		// 페이지 전환
		response.sendRedirect("/jspweb/index.jsp");
	%>
	<!-- 
	<div class="webbox">
		<h3> 로그아웃 되었습니다.</h3>
		<a href="/jspweb/index.jsp">메인 </a>
	</div>
	 -->
	





</body>
</html>