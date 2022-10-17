list()

function registration(){
	
	let info ={
		 btitle 	: document.querySelector("#btitle").value,
		 bcontent 	: document.querySelector("#bcontent").value,
		 bname 		: document.querySelector("#bname").value,
		 bpassword	: document.querySelector("#bpassword").value
	}
	$.ajax({
		url : "/비동기게시판/비동기게시판/board",
		data: info, 
		success : function(re){
			console.log('여기까지 못와?')
			console.log(re)
			location.href="../jsp/board.jsp"
		}
	})
}



function list(){
	$.ajax({
		url:"/비동기게시판/비동기게시판/boardlist",
		success : function(result){
			let boardlist = JSON.parse(result)
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
			for( let i = 0; i<boardlist.length ; i++){
				// 3.해당 인덱스의 객체 호출
				let b = boardlist[i]
				tag +='<tr>'+
					'<td> '+b.bno+' </td>'+
					'<td onclick="viewload('+b.bno+')">'+b.btitle+'</td>'+
					'<td> '+b.bcontent+'</td>'+
					'<td> '+b.bname+'</td>'+
					'<td> '+b.bpassword+'</td>'+
					'<td> '+b.mdate+'</td>'+
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

			let table = document.querySelector("#view")
			let bno_review = "content"+boardlist.bno
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
					'<td> <input type="submit" onclick="review('+boardlist.bno+')" value="답글"> </td>'+
					'<div id="bno_review"></div>'+
					'</tr>'
			

			table.innerHTML = tag
			console.log(bno_review)
		}
	})
}

function review(bno){
	let bno_review 		= "bno_review"+bno
	let bno_ctitle 		= "bno_ctitle"+bno
	let bno_ccontent	= "bno_ccontent"+bno
	let bno_cpassword	= "bno_cpassword"+bno
	console.log(bno_review)
	let table = document.querySelector("#bno_review")
	tag =   '작성자	: '+'<input type="text" 	 id = "bno_ctitle"><br>'	+
			'내용		: '+'<input type="text" 	 id = "bno_ccontent"><br>'	+
			'비밀번호	: '+'<input type="password"	 id = "bno_cpassword"><br>'	+
			' 			 <input type="submit" onclick="commit" value="답글등록">'
	table.innerHTML = tag
	$.ajax({
		url:"/비동기게시판/비동기게시판/review",
		data:{"bno" : bno},
		success : function(re){
			let boardlist = JSON.parse(re)
			console.log(boardlist)
			
			let table = document.querySelector("#bno_review")

			let tag ='<tr>'+
					'<th>내용</th>'+
					'<th>작성자</th>'+
					'<th>비밀번호</th>'+
					'</tr>';

				tag +='<tr>'+
					'<td> '+boardlist.bcontent+'</td>'+
					'<td> '+boardlist.bname+'</td>'+
					'<td> '+boardlist.bpassword+'</td>'+
					'<input type="submit" onclick="review('+boardlist.bno+')" value="답글">'+'<br>'+
					'</tr>';
			table.innerHTML = tag
		}
	})
}
