<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jspweb/css/productview.css">
<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>

		<!-- 헤더 페이지 호출 -->
		<%@include file="../header.jsp" %>
	
		<%
			// 자바를 작성할 수 있는 태그[서블릿]
			// 1. 경로에 있는 pno request 요청
			int pno = Integer.parseInt(request.getParameter("pno"));
			// 2. 로그인된 회원정보 호출
			Object object = session.getAttribute("mid");
			String mid = null;
			if(object != null){ // 로그인 했다.
				mid = (String)object;
			}
		%>
	
		<input type="text" value="<%=pno%>" class="pno">
		<input type="text" value="<%=mid%>" class="mid">
		<div class="container">
			<div class="row">
				<!-- 대표 이미지 -->
				<div class="col-md-6">
					<img class="pimg" alt="" src="/jspweb/img/아우터.jpg">
				</div>
				<div class="col-md-6">										<!-- 상표 정보 -->
					<div class="infobox">
							<h4 class="pname"> 미라클 라이트 경량 잠바</h4>								<!-- 제품명 -->
							<div class="pcomment"> 디자인대비 소매랑 넥라인 끝부분 마감 디테일이 아쉬워요</div>	<!-- 제품 설명 -->
						<div class="pricebox">									<!--  가격  할인적용 -->
							<span class="pdiscount">30%</span>
							<span class="pprice">30,000</span>
							<span class="psale">21,000</span>
						</div>
						<div class="sizebox">
							<span> [FREE ,XL , L , M , S]</span>
						</div>
						
						<!-- 제품 옵션 -->
						<table class="table info_t">
							<tr> <td>배송구분</td> <td>2,500원( 50,000원 이상 구매시 무료 )</td> </tr>
							<tr> <td>카드혜택</td> <td>무이자 할부</td> </tr>
							<tr> <td>적립혜택</td> <td>300(1%)</td> </tr>
							<tr> <td>부위</td> 
								<td>
									<select class="cselect">									<!-- 색상 선택 -->
										
									</select>
								</td>
							</tr>
							
							<tr> <td>등급</td>									<!-- 사이즈 선택 -->
								<td>
									<select class="sselect">
										
									</select>
								</td>
							</tr>
						</table>
						
						<!-- 선택된 제품 목록 -->
						<table class="table select_t">
							<tr>
								<th width="60%">상품명/옵션</th>
								<th width="25%">수량</th>
								<th width="15%">가격</th>
							</tr>
							<tr>
								<td>
									<span> 미라클 경량 점퍼</span>
									<br>
									<span> -블랙 / FREE </span>
								</td>
								<td class="row g-0">
									<div class="col-md-3 amountinput">
										<input class="form-control" value="1">
									</div>
									<div class="col-md-4">
										<button class="amount_btn"> ▲ </button>
										<button class="amount_btn"> ▼ </button>
									</div>
									<div class="col-md-1">
										<button class="cancel_btn"> x </button>
									</div>
								</td>
								<td>
									<span class="pricebox"> 20,000원 </span><br>
									<span class="pointbox"> (포인트)200 </span>
								</td>
							</tr>
						</table>
						
						<!-- 총 상품 가격 -->
						<div class="row">
							<div class="col-md-6"> 총 상품 금액</div>
							<div class="col-md-6 totalprice"> 0원 </div>
						</div>
						
						<!-- 장바구니 / 찜하기 / 바로구매 -->
						<div class="btnbox">
							<button id="btn1"> 바로 구매 </button>
							<button id="btn2"> 장바구니 담기 </button>
							<button id="btn3" class="btnlike"> 찜하기 ☆ </button>	<!-- 로그인 전용 -->
						</div>
					</div>
				</div>
			</div>		
		</div>
		
		<script src="../js/product/productview.js" type="text/javascript"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	
</body>
</html>



					<!-- <div class="pricebox">									 가격 할인없음
						<span>30,000원</span>
					</div> -->