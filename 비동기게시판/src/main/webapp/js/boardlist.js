list()
function list(){
	$.ajax({
		url:"/비동기게시판/비동기게시판/boardlist",
		success : function(re){
			let boardlist = JSON.parse(re)
			console.log(boardlist+"여기야 여기")
			
			let html = ""
			
			for(let i = 0 ; i<boardlist.length; i++){
				let b = boardlist[i]
				// ? 변수 선언 은 get방식에서만 가능
				html += '<tr>' +
				       '<td>'+b.bno+'</td>'+
					   '<td onclick="viewload('+b.bno+')">'+b.btitle+'</td>'+
		               '<td>'+b.mid+'</td>'+
					   '<td>'+b.bdate+'</td>'+
					   '<td>'+b.bview+'</td>'+
		               '</tr>';
		               
		               //'<td>'+b.bno+'</td>' +
		               //'<td><a href="http://localhost:8081/jspweb/board/view.jsp?bno='+board.bno+'">'+b.btitle+'</a></td>' +
		               //'<td><a href="http://localhost:8081/jspweb/board/view?"bno='+board.bno+'">'+b.mno+'</a></td>' +
		               // 하이퍼는 페이지 전환
		               
		               
			}
			console.log(html)
			document.querySelector('.btable').innerHTML += html
			//btable.innerHTML = html
		}
	})
}


