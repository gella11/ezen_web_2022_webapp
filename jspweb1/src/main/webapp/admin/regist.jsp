<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<div class="container"> <!-- 부트스트랩 -->
		<h3> 제품 등록</h3>
		<form>
			제품명 	: <input type="text" name="pname"> <br>
			설명		: <textarea rows="" cols="" name="pcomment"></textarea><br>
			할인율	: <input type="text" name="pdiscount"><br>
			카테고리	: <button type="button" onclick="pcategoryview()"> 카테고리 추가</button><br>
				<span class="pcategoryaddbox">	<!--  카테고리 추가 입력  -->
					
				</span>
				<div class="pcategorybox">	<!--  카테고리 목록  -->
				</div>
			상품대표이미지: <input type="file" id="pimg" name="pimg"> <br>
			<button type="reset"> 취소 </button> <br>
			<button type="button" onclick="regist()"> 등록 </button>
		</form>
	</div>
	
	<div> <!-- 폼에 등록된 첨부파일[이미지만] 미리보기 -->
		<img alt="" src="" id="pimgpre">
	</div>
	
	
	
	
<script src="../js/admin/regist.js" type="text/javascript"></script>


</body>
</html>

























