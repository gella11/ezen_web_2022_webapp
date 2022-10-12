

//let mid = document.querySelector("#mid");
// 스크립트가 먼저 실행이 되니 섹션에 아무것도 없어서 undefined가 뜸
// alert(mid.innerHTML);

/* ---------------- 회원정보 호출 -------------- */
function getmember(){
	$.ajax({
		url : "/jspweb/member/info" , 	// 서블릿 URL
	 	success : function( result ) {
			// HTTP 스트림( 바이트단위 ) json형식의 문자열 타입을 JSON 타입으로 형변환 
			let member = JSON.parse( result )
			document.querySelector("#mno").innerHTML = member.mno
			document.querySelector("#mid").innerHTML = member.mid
			document.querySelector("#mname").innerHTML = member.mname
			document.querySelector("#mphone").innerHTML = member.mphone
			document.querySelector("#memail").innerHTML = member.memail
			document.querySelector("#maddress").innerHTML = member.maddress
			document.querySelector("#mdate").innerHTML = member.mdate
			document.querySelector("#mpoint").innerHTML = member.mpoint
			getmemberlist(); // 모든 회원 함수 호출


			document.querySelector("#mname").value = member.mname
			document.querySelector("#mphone").value = member.mphone
			document.querySelector("#memail").value = member.memail

			document.querySelector("#sample4_postcode").value = member.maddress.split(",")[0]
			document.querySelector("#sample4_roadAddress").value = member.maddress.split(",")[1]
			document.querySelector("#sample4_jibunAddress").value = member.maddress.split(",")[2]
			document.querySelector("#sample4_detailAddress").value = member.maddress.split(",")[3]

			// getmemberlist(); // 모든 회원 함수 호출
		}
	});
}
/* ---------------- 모든 회원 호출 -------------- */
function getmemberlist(){
	$.ajax({
		url : "/jspweb/member/infolist", 
		success : function( result ){
			let memberlist = JSON.parse( result )
			// 1. tag 가져오기
			let table =  document.querySelector("#memeberlisttable")
			// 2. table 에 넣을 제목 셋팅 
			let tag = 
				'<tr>'+
					'<th> 번호 </th>	<th> 아이디 </th><th> 이름 </th>'+
					'<th> 연락처 </th><th> 이메일 </th><th> 주소 </th>'+
					'<th> 날짜 </th>	<th> 포인트 </th>'+
				'</tr>';
			//3. tag 값 넣기 
			for( let i = 0 ; i < memberlist.length ; i++ ){
				// 4. 해당 인덱스의 객체호출 
				let m = memberlist[i]
				// 5.해당 객체의 정보를  tag변수 누적 더하기 [ html 출력 ]  
				tag +=  
					'<tr>'+
						'<td> '+m.mno+' </td> 		<td> '+m.mid+' </td>'+
						'<td> '+m.mname+' </td> 	<td> '+m.mphone+' </td>'+
						'<td> '+m.memail+' </td>	<td> '+m.maddress+' </td>'+
						'<td> '+m.mdate+' </td> 	<td> '+m.mpoint+' </td>'+
					'</tr>';
			}
			// 6. html 문자열을 table 에 넣어주기 
			table.innerHTML = tag
		}
	})
}

// 회원 탈퇴
// 회원 탈퇴
// 회원 탈퇴
function viewdelete(){
	// 1. tag 가져온다
	let deletebox = document.querySelector("#deletebox")
	// 2. tag에 넣을 html 문자열 구성
	let tag = 
			'<span> ! 참말로 탈퇴할겨? 비밀번호 입력하셔</span>'+
			'<input type="password" id="mpassword">'+
			'<button onclick="mdelete()"> 확인 </button>'
	// 3. tag에 html 넣기
	deletebox.innerHTML = tag
}


/* 자바 스크립트
	선언 ))) let 객체명 = {속성명 : 값}
	호출 ))) 객체명.속성명
*/

function mdelete(){
	// 1.tag 입력된 비밀번호 가져오기
	let mpassword = document.querySelector("#mpassword").value
	// 2. ajax를 이용한 회원탈퇴 처리
	$.ajax({
		url:"http://localhost:8080/jspweb/member/memberdelete",
		data:{"mpassword" : mpassword},
		success : function(result){
			if(result=='true') {
				alert('탈퇴 성공')
				 location.href = '/jspweb/member/logout.jsp'
			}else{
				alert('동일하지 않은 정보 입니다.')}
		}
	})
}


let buttons =  document.querySelectorAll('button')  // 현재 페이지의 모든 버튼 호출

function updateaction(){
	let mname  = document.querySelector('#mname')
	if( buttons[1].innerHTML === '확인' ){
		$.ajax({
			url : "http://localhost:8080/jspweb/member/update" ,
			data : { "mname" : mname.value } , 
			success : function( re ){ 
				if( re === 'true'){
					alert('수정성공')
				}else{
					alert('수정실패')
				}
			}
		})
		buttons[1].innerHTML = '수정'
		mname.readOnly = true;	// 수정모드 설정 
		//location.href = 'url' ; // 페이지 이동
		location.reload() ; 	// 현재 페이지 새로고침
	}else{
		alert('수정후 확인 버튼 클릭시 수정이 완료됩니다.')
		mname.readOnly = false;	// 수정모드 제거 
		buttons[1].innerHTML = '확인'
	}
}








