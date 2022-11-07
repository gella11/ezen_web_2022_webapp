<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jspweb/css/main.css">
	
</head>
<body>
	
	<%@include file="header.jsp" %>
	
	<!--  대문 [이미지 슬라이드 - 캐러셀 ] -->				<!-- carousel-fade : 덮어쓰기 -->
	<div id="carouselExampleControls" class="carousel slide " data-bs-ride="carousel" data-bs-interval="1000">
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="/jspweb/img/shopmain.jpg" class="d-block w-100" alt="...">
	    </div>
	    <div class="carousel-item">
	      <img src="/jspweb/img/shopmain.jpg" class="d-block w-100" alt="...">
	    </div>
	    <div class="carousel-item">
	      <img src="/jspweb/img/shopmain.jpg" class="d-block w-100" alt="...">
	    </div>
	  </div>
	  <!-- 왼쪽 버튼 -->
	  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Previous</span>
	  </button>
	  <!-- 오른쪽 버튼 -->
	  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Next</span>
	  </button>
	</div>	
	
	
	
	<!-- 제품 출력 -->
	<div class="container">				<!-- container : 부트스트랩 -->
	
	<h6 class="box_title"> Cow Cow </h6>
		<div class="itemlist">						<!-- 일정구역 -->
			
			
			
			<!-- 제품 출력 구역 -->
			
			
			
			
						
			
		</div>
	</div>
	
	<script src="js/admin/main.js" type="text/javascript"></script>
	
	
	
	

</body>
</html>























