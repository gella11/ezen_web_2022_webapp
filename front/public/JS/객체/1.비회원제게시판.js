/*
 	
 	css : class 명
 	js : id 명
 	[등록]
 		1.html input 태그에 입력된 데이터 호출
 		2.객체에 담기
 		3.글 등록 버튼을 눌렀을 때[마다 -> 함수] 1/2 실행한다.
 		4.게시물 여러개 저장할 공간 = 배열 선정 (원래 DB이지만 지금은 못씀) 새로고침하면 사라짐
 		5.글 등록이 완료될 때 마다 board객체를 배열에 저장한다. 
 			6.(추가기능) 글 등록 버튼 눌렀으면 쓴 글 input 초기화
 	[출력]
 		1. js 시작 될 때 / 새로운 글이 등록 될때 마다 [ 게시물 출력 ]
 		
 	[보기]
 		1.게시물 출력해서 제목을 클릭할때마다 [ 게시물 보기 ]
 			1. 내가 클릭한 게시물(???) : 매개변수 전달 [ 클릭한 게시물의 번호 (번호인 이유는 중복이 없는 속성으로 이용해얌. 즉 index)]
 		
 			
 			
 */
 // ★등록
 //	4. 배열 만들기 . 여러개  borad 객체를 저장할 배열 선언
 let boardlist = []
 // js가 실행될 때 함수 실행 // 처음에 무조건 
 	게시물출력()
 	
 	
 //	3. 함수 선언[글 등록 버튼을 클릭할 때 마다]
 function 글등록(){
	  // 1. html에서 입력된 데이터 가져와서 변수에 담기
	 let bwriter = document.getElementById('bwriter').value
	 let bpassword = document.getElementById('bpassword').value
	 
	 let btitle = document.getElementById('btitle').value
	 let bcontent = document.getElementById('bcontent').value
	 
	 //	2.객체에 담기
	 let board = {
		작성자 :  bwriter,
		비밀번호 : bpassword,	
	 	제목 : btitle,
		내용 : bcontent
		}
	//5. 객체를 배열에 저장한다.
	boardlist.push( board ) //배열명.push/(객체명)
	//3.테스트
	alert('글 등록 완료되었습니다')
	console.log( boardlist )
	//6. 추가기능
	bwriter = document.getElementById('bwriter').value=''
	bpassword = document.getElementById('bpassword').value=''
	btitle = document.getElementById('btitle').value=''
	bcontent = document.getElementById('bcontent').value=''
	// 7. 글 등록시 게시물출력 함수 호출 두 번째 호출
	게시물출력()
}

//	★출력1
// js에서 html 작성시 문자처리 주의
// js에서 작은 따옴표로 전체를 감싸고 안에를 큰따옴표로 씀. 아니면 백틱.달러 쓰기.
function 게시물출력(){
	let html ='<tr> <th>번호</th> <th>제목</th> <th>작성자</th> </tr>'
	
	//반복문
	for( let i = 0 ; i<boardlist.length ; i++){
		// i는 0부터 배열의 길이 까지 1씩 증가 
		html += '<tr><th> '+ i +' </th> <th><a href="#" onclick="게시물보기('+i+')">'+boardlist[i].제목 +'</a></th> <th>'+boardlist[i].작성자 +'</th> </tr>'
	}
	
	document.getElementById('boardlist').innerHTML=html
		
}


//	★보기
function 게시물보기(i){
	alert( i + '게시물 클릭했습니다.')
	document.getElementById('viewtitle').innerHTML = boardlist[i].제목
	document.getElementById('viewwriter').innerHTML = boardlist[i].작성자
	document.getElementById('viewcontent').innerHTML = boardlist[i].내용
}









