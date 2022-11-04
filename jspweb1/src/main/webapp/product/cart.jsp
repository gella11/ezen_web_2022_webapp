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
		<table class="table cart_table">
		</table>
		
		<button type="button" onclick="">선택삭제</button>
		<button type="button" onclick="">전체삭제</button>
		<button type="button" onclick="">쇼핑하기</button>
		<button type="button" onclick="requestPay()">결제하기</button>
			
	</div>
	
	
	<!-- 아임포트 결제 API iamport.payment.js -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>	
	<script type="text/javascript" src="/jspweb/js/product/cart.js"></script>
	

</body>
</html>