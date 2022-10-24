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
	
	<div class="container"> <!--  b : bootstrap -->
		
		
		
		
		<!-- 지도를 표시할 div 입니다 -->
		<div id="map" style="width:100%;height:350px;"></div>
		
		<div class="detailbox">
		</div>
		
		
		
		<div class="row">
			<div class="col-sm-3">
				<input type="text" class="form-control addrinput">
			</div>
			<div class="col-sm-1">
				<button type="button" class="btn" onclick="addrsearch()"> 검색 </button>
			</div>
		</div>
		
		<table class="table"> <!--  b : bootstrap -->
			<tr> <th>약국명</th> <th>전화번호</th> <th>주소</th> </tr>			
		</table>
		
		<table class="searchcontent">
			
		</table>
	</div>
	

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=232e511f43104b6727a63ad4c57f1dec&libraries=services"></script>
	<script type="text/javascript" src="../js/board/api.js"></script>
</body>
</html>

<!-- 

	

 -->