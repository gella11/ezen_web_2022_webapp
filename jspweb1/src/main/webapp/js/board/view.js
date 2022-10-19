/*
	value 		: input select textarea
								* textarea 는 innerHtml 도 됨. 예외임 특별한 놈임
	innerHtml	: div table span 태그 사이
 */

// 댓글 리스트 출력
function rlist(){
	$.ajax({
		url:"/jspweb/reply/rlist",
		data : {"type" : "reply"},
		success : function(re){
			let replylist = JSON.parse(re)
			
			let html = ''
			
			for(let i = 0 ; i<replylist.length; i++){
				let reply = replylist[i]
				
				//대댓글 호출 = rno
				$.ajax({
					url:"/jspweb/reply/rlist",
					data : {"type" : "rereply" , "rno" : reply.rno},
					async : false,
					success : function(re){
						let rereplylist = JSON.parse(re)
							html += '<div>' +
										+ '<span>'+reply.rcontent+'</span>' 	 
										+ '<span>'+reply.rdate+'</span>' 		 
										+ '<span>'+reply.mid+'</span>' 		 
										+ '<button type="button" onclick="rereplyview('+reply.rno+')"> 답글 </button>'  
										+ '<div class="reply'+reply.rno+'"> </div>'
							for(let j = 0 ; j<rereplylist.length; j++){
							let rereply = rereplylist[j]
							html += '<div style="margin : 30px;">' 				 
										+ '<span>'+rereply.rcontent+'</span>' 	 
										+ '<span>'+rereply.rdate+'</span>' 		 
										+ '<span>'+rereply.mid+'</span>' 			 	 
									+ '</div>'
							}
							html += '</div>'
						}
					})
				}
			document.querySelector('.replylist').innerHTML = html
		}
	})
}

// 댓글 입력시 인풋박스 등장
function rereplyview(rno){
	let replydiv = document.querySelector('.reply'+rno)	
	replydiv.innerHTML = '<input type="text" class="rerecontent'+rno+'" > <button onclick="rereplywrite('+rno+')">답글등록</button>'
}

// 대댓글 value 저장
function rereplywrite(rno){
	let rcontent = document.querySelector('.rerecontent'+rno).value
	$.ajax({
		url:"/jspweb/reply/rwrite",
		data : {"rcontent" : rcontent , "rno" : rno , "type" : "rereply"},	// type은 같은 서블릿 기능
		type : "POST",
		success : function(re){
			if( re == 1){
				alert('대댓글 작성')
				location.reload()
			}else if( re == 0) {
				alert('로그인이 필요합니다.')
				location.href='../member/login.jsp'
			}else{
				alert('대댓글 등록 실패!!!')
			}
		}
	})
}

// 댓글 value 저장
function rwrite(){
	let rcontent = document.querySelector(".rcontent").value
	$.ajax({
		url:"/jspweb/reply/rwrite",
		data : {"rcontent" : rcontent , "type" : "reply"},
		type : "POST",						// get방식은 기본값
		success : function(re){
			if( re == 1){
				alert('댓글 작성')
				location.reload()
			}else if( re == 0) {
				alert('로그인이 필요합니다.')
				location.href='../member/login.jsp'
			}else{
				alert('댓글 등록 실패!!!')
			}
		}
	})
}






bview()
// 선택 그 보기
function bview(bno){
	$.ajax({
		url:"/jspweb/board/view",
		async : false, 			// ★★★★★★★ 동기식. 싱그로나이즈. 이 함수가 실행되고 끝날 때 까지 다른 함수 웨이팅
		data:{"bno" : bno},
		success : function(re){
			let board = JSON.parse(re)
			console.log(board)
			
			document.querySelector('.bno').innerHTML = board.bno
			document.querySelector('.btitle').innerHTML = board.btitle
			document.querySelector('.bcontent').innerHTML = board.bcontent
			document.querySelector('.mid').innerHTML = board.mid
			
			console.log(board.bfile) // null
			
			if(board.bfile){	// null undefined 0 false
				// let filelink = '<a href="../board/filedownload">' +board.bfile+ '</a>'
				let filelink = '<a href="http://localhost:8081/jspweb/board/filedownload?bfile='+board.bfile+'"> '+board.bfile+'</a>'
				document.querySelector('.bfile').innerHTML = filelink
			}else{
				//alert('첨부된 파일은 없습니다.')
			}
			
			// 본인 글 삭제
			let btnbox = document.querySelector('.btnbox')
			if(board.btnaction == true){
				// 삭제 버튼 활성화
				let deletebtn = '<button onclick="bdelete('+board.bno+')"> 삭제 </button>'
				btnbox.innerHTML += deletebtn
				// 수정 버튼 활성화
				let updatebtn = '<button> <a href="../member/update.jsp"> 수정 </a> </button>'
				btnbox.innerHTML += updatebtn
			}
			//////// 댓 글 출 력 ////////////
			rlist()
		}		
	})	
}
// 선택 글 삭제
function bdelete(bno){
	$.ajax({
		url:"/jspweb/board/bdelete",
		data : {"bno" : bno},
		success : function(re){
			if(re === 'true'){
				alert('글 삭제했습니다.')
				location.href="../board/list.jsp"
			}
			else{
				alert('작성하신 글이 아닙니다.')
			}
		}
	})
}