list()

function registration(){
	$.ajax({
		url : "/비동기게시판/비동기게시판/board",
		success : function(re){
			alert(re)
			location.href="http://localhost:8080/%EB%B9%84%EB%8F%99%EA%B8%B0%EA%B2%8C%EC%8B%9C%ED%8C%90/jsp/board.jsp"
			list()
		}
	})
}



function list(){
	console.log("찍히긴 하니?")
	$.ajax({
		url:"/비동기게시판/비동기게시판/boardlist",
		success : function(result){
			let boardlist = JSON.parse(result)
			console.log(boardlist)
			// 1. tag 가져오기
			let table = document.querySelector("#boardlist")
			// 2. table에 넣을 html 문자열
			let tag ='<tr>'+
					'<th> 번호 </th>'+
					'<th>제목</th>'+
					'<th>내용</th>'+
					'<th>작성자</th>'+
					'<th>비밀번호</th>'+
					'<th>날짜</th>'+
					'<th>조회수</th>'+
					'</tr>';
			// 2. tag 값 넣기
			for( let i = 0; i<	boardlist.length ; i++){
				// 3.해당 인덱스의 객체 호출
				let b = boardlist[i]
				tag +='<tr>'+
					'<td> '+b.bno+' </td>'+
					'<td onclick="viewload('+b.bno+')">'+b.btitle+'</td>'+
					'<td> '+b.bcontent+'</td>'+
					'<td> '+b.bname+'</td>'+
					'<td> '+b.bpassword+'</td>'+
					'<td> '+b.bdate+'</td>'+
					'<td> '+b.view+'</td>'
					'</tr>';
			}
			// html 문자열을 table에 넣어주기
			table.innerHTML = tag
		               
		               //'<td>'+b.bno+'</td>' +
		               //'<td><a href="http://localhost:8081/jspweb/board/view.jsp?bno='+board.bno+'">'+b.btitle+'</a></td>' +
		               //'<td><a href="http://localhost:8081/jspweb/board/view?"bno='+board.bno+'">'+b.mno+'</a></td>' +
		               // 하이퍼는 페이지 전환
		               
		               
			
			//console.log(html)
			//document.querySelector('.boardlisttable').innerHTML += html
			////btable.innerHTML = html
		}
	})
}

function viewload(bno){
	$.ajax({
		url:"/비동기게시판/비동기게시판/view",
		data:{"bno" : bno},
		success : function(re){
			let boardlist = JSON.parse(re)
			console.log(boardlist)

			let table = document.querySelector("#view")

			let tag ='<tr>'+
					'<th> 번호 </th>'+
					'<th>제목</th>'+
					'<th>내용</th>'+
					'<th>작성자</th>'+
					'<th>비밀번호</th>'+
					'<th>날짜</th>'+
					'<th>조회수</th>'+
					'</tr>';

	

				tag +='<tr>'+
					'<td> '+boardlist.bno+' </td>'+
					'<td> '+boardlist.btitle+'</td>'+
					'<td> '+boardlist.bcontent+'</td>'+
					'<td> '+boardlist.bname+'</td>'+
					'<td> '+boardlist.bpassword+'</td>'+
					'<td> '+boardlist.bdate+'</td>'+
					'<td> '+boardlist.view+'</td>' +
					'<input type="submit" onclick="review('+b.bno+')" value="답글"> '
					'</tr>';
			

			table.innerHTML = tag
		}
	})
}

function review(bno){
	$.ajax({
		url:"/비동기게시판/비동기게시판/review",
		data:{"bno" : bno},
		success : function(re){
			let boardlist = JSON.parse(re)
			console.log(boardlist)

			let table = document.querySelector("#review")

			let tag ='<tr>'+
					'<th>내용</th>'+
					'<th>작성자</th>'+
					'<th>비밀번호</th>'+
					'</tr>';

	

				tag +='<tr>'+
					'<td> '+boardlist.bcontent+'</td>'+
					'<td> '+boardlist.bname+'</td>'+
					'<td> '+boardlist.bpassword+'</td>'+
					'<input type="submit" onclick="review('+b.bno+')" value="답글"> '
					'</tr>';
			

			table.innerHTML = tag
		}
	})
	}