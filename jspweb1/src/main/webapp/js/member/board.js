alert('dddd')





function registration(){
	$.ajax({
		url : "/jspweb/board/boardlist",
		success : function(result){
			let boardlist = JSON.parse(result)
			// 1. tag 가져오기
			let table = document.querySelector("#boardlisttable")
			//alert(table)
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
					'<td> '+b.title+'</td>'+
					'<td> '+b.content+'</td>'+
					'<td> '+b.bname+'</td>'+
					'<td> '+b.bpassword+'</td>'+
					'<td> '+b.bdate+'</td>'+
					'<td> '+b.view+'</td>'
					'</tr>';
			}
			// html 문자열을 table에 넣어주기
			table.innerHTML = tag
		}
	})
}