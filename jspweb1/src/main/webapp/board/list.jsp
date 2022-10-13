<%@page import="model.dao.MemberDao"%>
<%@page import="model.dto.BoardDto"%>
<%@page import="model.dao.BoardDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
	<!-- 헤더 페이지 호출 -->
	<%@include file="../header.jsp" %>
	
	<div class="webbox"> 
		<a href="write.jsp"> 글쓰기 </a>
		
		<!--  JSP로 테이블 표시 [html(JSP) >>> 서블릿x >>> dao -->
		<!--  JSP로 테이블 표시 [html(JSP) >>> 서블릿x >>> dao -->
		<!--  JSP로 테이블 표시 [html(JSP) >>> 서블릿x >>> dao -->		
		<%-- <table>
			<tr>
				<th>번호</th> <th>제목</th> <th>작성자</th>
			</tr>
			
			<% // 스크립트 태그 : html에 java를 작성할 수 있는 공간
				ArrayList<BoardDto> list = BoardDao.getInstance().getlist();
				for( int i = 0; i < list.size(); i++ ){
		         %>   
		            <tr>
		               <td> <%= list.get(i).getBno() %> </td>
		               <td> <%= list.get(i).getBtitle() %> </td>
		               <td> <%= list.get(i).getMno() %> </td>
		            </tr>
		         <%
		         }      // <%= : 표현식(호출)
		         %>
		</table> --%>
		
		
		<!--  JS 로 테이블 표시 [html(JSP) >>> js    >>> 서블릿 >>>  dao -->
		<!--  JS 로 테이블 표시 [html(JSP) >>> js    >>> 서블릿 >>>  dao -->
		<!--  JS 로 테이블 표시 [html(JSP) >>> js    >>> 서블릿 >>>  dao -->
		<table class="btable">
			<tr>
				<th> 번호 </th> <th> 제목 </th> <th>작성자</th> 
				<th> 작성일 </th> <th> 조회수 </th>
			</tr>
		</table>
		<script type="text/javascript" src="../js/board/list.js"></script>
</body>
</html>