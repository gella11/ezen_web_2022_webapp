
/* HTML 과 서블릿 통신*/


// 0. 로그인 버튼을 눌렀을 때, [ 여러번 실행 --> 함수 ]
// 함수정의 [ function 함수명(매개변수){} ]
// HTML 함수 실행 ---> 이벤트
	// onclick="함수명()" : 클릭했을 때 함수 호출
function login(){
			// 1. html 입력된 데이터 가져오기 [ DOM 객체 ]
			// 방법.
			// 1) document.querySelector("#id")
			// 2) document.getElementById("id")
let mid 		= document.querySelector('#mid').value
				//$("#name").value 제이쿼리식 문법	
let mpassword 	= document.querySelector('#mpassword').value
let loginconfirmbox = document.querySelector('#loginconfirmbox')	// div 라서 value 안씀
// 확인 alert(mid)
// 확인 alert(mpassword)

// 2. 변수 2개를 서블릿으로 보내자 [ JQUERY : 자바스크립트 라이브러리 ]
// 1) JQEURY 라이브러리 포함되어야 함 HEADER 맨 밑에 넣어둠
// 2) AJAX(비동기식 통신 기법) 
// $.ajax({속성명 = 값, 속성명 = 값 , 속성명 = 값})
	// url : '통신경로'
	// data : 전송할 데이터 {'키':값, '키':값, '키':값}
	// success: function(매개변수)
   $.ajax({
	 url : "/jspweb/member/login",	// 서블릿 주소
	 data : { "mid" : mid , "mpassword" : mpassword},
	 success : function(re){
		if(re === '1'){
			alert('로그인 성공')
			location.href='/jspweb/index.jsp'
		}else if(re === '2'){
			alert('로그인 실패')
			loginconfirmbox.innerHTML = '패스워드가 다릅니다.' // 해당 id에 문자열 넣기
		}else if(re === '3'){
			loginconfirmbox.innerHTML = '데이터베이스 오류'
		}else if(re === '0'){
			loginconfirmbox.innerHTML = '존재하지않는 아이디 입니다.'
		}
		}
	 });

}




/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/