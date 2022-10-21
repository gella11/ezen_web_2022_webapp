
view()
function view(){
	$.ajax({
		url : "/jsptest/view",
		data : {"type" : "view"},
		success : function(re){
			let boardlist = JSON.parse(re)
			let b = boardlist
			let html = '<tr>'
						+ '<th> 번호 </th>'
						+ '<th> 제목 </th>'
						+ '<th> 작성자 </th>'
						+ '<th> 내용 </th>'
						+ '<th> 날짜 </th>'
						+ '<th> 조회수 </th>'
						+ '</tr>'
				html += '<tr>'
						+ '<td> '+b.bno+' </td>'
						+ '<td> '+b.btitle+' </td>'
						+ '<td> '+b.bname+' </td>'
						+ '<td> '+b.bcontent+' </td>'
						+ '<td> '+b.bdate+' </td>'
						+ '<td> '+b.view+' </td>'
						+ '</tr>'
			
			html += '<button onclick="writepage()"> 글쓰기 </button>'
			
			document.querySelector('#view').innerHTML = html
		}
	})
}


function writepage(){
	location.href="http://localhost:8080/jsptest/html/write.html"
}
function listpage(){
	location.href="http://localhost:8080/jsptest/html/list.html"
}