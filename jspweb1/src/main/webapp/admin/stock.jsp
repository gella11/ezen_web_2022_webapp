<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<script src="http://code.jquery.com/jquery-latest.js"></script>

	<div class="container"> 
		<div class="row my-3">	<!-- b : row 하위태그 가로배치 -->
			<h3> 재고 관리 </h3>
			<div class="col-md-4"> <!-- b : form-select : width 100%  vs   col-md-4 : width 12/4 % -->
				<select class="cselect form-select">

				</select>
			</div>
			<div class="col-md-4"> <!-- b : col-md-숫자 12그리중 숫자만큼 사이즈 -->
				<select class="pselect form-select">
					<option> 제품명 선택 </option>
				</select>
			</div>
		</div>
		
		
		<div class="row my-3">	<!-- b : my-3 위아래 바깥여백[마진] -->
			<div class="col-md-6">
				<h3>재고 등록</h3>
				<table class="table"> <!-- b: table 테이블 형식 -->
					<tr> <td style="width: 20%;"> 카테고리번호 </td> 	<td class="rows"></td> </tr>
					<tr> <td style="width: 20%;"> 제품번호 </td> 		<td class="rows"></td> </tr>
					<tr> <td style="width: 20%;"> 제품명 </td> 		<td class="rows"></td> </tr>
					<tr> <td style="width: 20%;"> 사이즈 </td> 		<td class="rows"> <input type="text" class="psize form-control"> </td> </tr>
					<tr> <td style="width: 20%;"> 색상 </td> 			<td class="rows"> <input type="text" class="pcolor form-control"> </td> </tr>
					<tr> <td style="width: 20%;"> 재고수량 </td> 		<td class="rows"> <input type="text" class="pstock form-control"> </td> </tr>
					<tr> <td colspan="2"> <button onclick="setstock()"type="button" class="form-control">등록</button> </td> </tr>
				</table>
			</div>
			<div class="col-md-6">
				<h3>재고 출력</h3>
				<table class="table ccc">
				
				</table>
			</div>
		</div>
		
		
		
	</div>
	
	<script src="../js/admin/stock.js" type="text/javascript"></script>
	<!-- 부트스트랩 js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	 

</body>
</html>