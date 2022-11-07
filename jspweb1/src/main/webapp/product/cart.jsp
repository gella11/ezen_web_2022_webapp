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
	<div class="container">
		<table class="table cart_t">
			
		</table>
		
		<button type="button" onclick="">선택삭제</button>
		<button type="button" onclick="">전체삭제</button>
		<button type="button" onclick="">쇼핑하기</button>
		<button type="button" onclick="payload()">결제하기</button>
			
	</div>
	
	
	
	<script type="text/javascript" src="../js/product/cart.js"></script>
	

</body>
</html>