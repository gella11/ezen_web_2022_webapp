

//let mid = document.querySelector("#mid");
// 스크립트가 먼저 실행이 되니 섹션에 아무것도 없어서 undefined가 뜸
// alert(mid.innerHTML);

// 회원 정보 호출
// 회원 정보 호출
// 회원 정보 호출
$.ajax({
	url: "/jspweb/member/info",
	success : function(result){
		// .parse
		// 통신된 json형식의 문자타입을 json 타입으로 형변환
		let member = JSON.parse(result)
		
		//alert(member.maddress)
		
		document.querySelector("#mno").innerHTML = member.mno;
		document.querySelector("#mid").innerHTML = member.mid;
		document.querySelector("#mnmae").innerHTML = member.mnmae;
		document.querySelector("#mphone").innerHTML = member.mphone;
		document.querySelector("#memail").innerHTML = member.memail;
		document.querySelector("#maddress").innerHTML = member.maddress;
		document.querySelector("#mdate").innerHTML = member.mdate;
		document.querySelector("#mpint").innerHTML = member.mpint;
		
		
		}
})

// 모든 회원 호출
// 모든 회원 호출
// 모든 회원 호출
	$.ajax({
		url : "/jspweb/member/infolist",
		success : function(result){
			let memberlist = JSON.parse(result)
			// 1. tag 가져오기
			let table = document.querySelector("#memberlisttable")
			//alert(table)
			// 2. table에 넣을 html 문자열
			let tag ='<tr>'+
					'<th> 번호 </th>'+
					'<th>아이디</th>'+
					'<th>이름</th>'+
					'<th>폰</th>'+
					'<th>이메일</th>'+
					'<th>주소</th>'+
					'<th>날짜</th>'+
					'<th>포인트</th>'+
					'</tr>';
			// 2. tag 값 넣기
			for( let i = 0; i<memberlist.length ; i++){
				// 3.해당 인덱스의 객체 호출
				let m = memberlist[i]
				tag +='<tr>'+
					'<td> '+m.mno+' </td>'+
					'<td> '+m.mid+'</td>'+
					'<td> '+m.mname+'</td>'+
					'<td> '+m.mphone+'</td>'+
					'<td> '+m.memail+'</td>'+
					'<td> '+m.maddress+'</td>'+
					'<td> '+m.mdate+'</td>'+
					'<td> '+m.mpint+'</td>'
					'</tr>';
			}
			// html 문자열을 table에 넣어주기
			table.innerHTML = tag
		}
	})

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











