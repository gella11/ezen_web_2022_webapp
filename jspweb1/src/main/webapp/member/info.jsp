<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/signup.css">
<title>Insert title here</title>
</head>
<body>

	<!-- 헤더 페이지 호출 -->
	<%@include file="../header.jsp" %>
	
	<!-- 섹션을 이용한 페이지 제어 -->
	<% 
		// include를 하면 ★★★★★ 해당 인크루드 변수 쓸 수 있음
		// header.jsp 파일의 변수 호출 가능
		if(loginid == null){response.sendRedirect("login.jsp");} 
	%>
	
	<div class="webbox">
			
		<form class="signupform"action="/jspweb/member/signup" method="post">
		<h2 class="pagetitle"> 회원정보 </h2>
		<h3 class="parttitle"> 기본정보 </h3>
		
		<table class="signuptable">
			<tr>
				<td class="col1" > 회원번호  </td>	<!-- name:form에서 사용 , id:js에서 사용  -->
				<td  class="col2" id="mno"> </td>
			</tr>
			<tr>
				<td class="col1" > 가입일  </td>	<!-- name:form에서 사용 , id:js에서 사용  -->
				<td class="col2" id="mdate"></td>
			</tr>
			<tr>
				<td class="col1" > 포인트  </td>	<!-- name:form에서 사용 , id:js에서 사용  -->
				<td class="col2" id="mpoint"> </td>
			</tr>
			<tr>
				<td class="col1" > 아이디  </td>	<!-- name:form에서 사용 , id:js에서 사용  -->
				<td class="col2" id="mid" ></td>
			</tr>
			<tr>
				<td class="col1" > 비밀번호  </td>
				<td class="col2"> <input readonly="readonly" type="password" 	name="mpassword" 		id="mpassword" 			onkeyup="mevent2()"> </td>
				<td class="col3"> <button type="button" > 수정 </button></td>
			</tr>	
			<tr>
				<td class="col1" > 이름  </td>
				<td class="col2"><input readonly="readonly" type="text" 		name="mname" 			id="mname" 				onkeyup="mevent4()"> </td>
				<td class="col3"><button type="button" onclick="updateaction()"> 수정 </button></td>
			</tr>
			<tr>
				<td class="col1" > 전화번호  </td>
				<td class="col2"> <input readonly="readonly" type="text" 		name="mphone" 			id="mphone" 			onkeyup="mevent5()"> </td>
				<td class="col3"><button type="button"> 수정 </button></td>
			</tr>
			<tr>
				<td class="col1" > 이메일  </td>
				<td class="col2"> <input readonly="readonly" type="text" 		name="memail" 			id="memail" 			onkeyup="mevent6()"> </td>
				<td class="col3"><button type="button"> 수정 </button></td>
			</tr>
			<tr>
				<td rowspan="2" class="col1" > 주소  </td>
				<td colspan="2" class="col2"> 
					<span>
						<input readonly="readonly" type="text" id="sample4_postcode" placeholder="우편번호" name="maddress1">
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
					</span>
					<span>
						<input readonly="readonly" type="text" id="sample4_roadAddress" placeholder="도로명주소" name="maddress2">
						<input readonly="readonly" type="text" id="sample4_jibunAddress" placeholder="지번주소" name="maddress3">
					</span>
				</td>
			</tr>
			<tr>
				<td class="col2"> <input readonly="readonly" type="text" id="sample4_detailAddress" placeholder="상세주소" name="maddress4"> </td>
				<td class="col3"><button type="button"> 수정 </button> </td>
			</tr>
		</table>		
		
		<div class="signupbtnbox">
			<button type="button" onclick="formsubmit()">회원탈퇴</button>
		</div>
		</form>
	</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<!--  본문  -->
	<div class="webbox">
		<h3> 회원 정보 </h3>
		
		<button onclick="viewdelete()"> 회원탈퇴 </button>
		<div id="deletebox"></div>
		
		<table>
			<tr>
				<td> 회원번호 </td> <td id="mno"> </td>
			</tr>
			<tr>
				<td> 아이디 </td> <td id="mid">  </td>
			</tr>
			<tr>
				<td> 이름 </td> <td id="mnmae">  </td>
			</tr>
			<tr>
				<td> 전화번호 </td> <td id="mphone"> </td>
			</tr>
			<tr>
				<td> 이메일 </td> <td id="memail"> </td>
			</tr>
			<tr>
				<td> 주소 </td> <td id="maddress"> </td>
			</tr>
			<tr>
				<td> 가입날짜 </td> <td id="mdate"> </td>
			</tr>
			<tr>
				<td> 포인트 </td> <td id="mpint">  </td>
			</tr>
		</table>
	</div>
	
	<div class="webbox">
		<h3> 회원 목록</h3>
		<table id="boardlisttable">
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>폰</th>
				<th>이메일</th>
				<th>주소</th>
				<th>날짜</th>
				<th>포인트</th>
			</tr>
		</table>
		
	</div>
	
	<script type="text/javascript" src="../js/member/info.js"></script>

</body>
</html>