

list()
function list(){
	$.ajax({
		url:"/jsptest/list",
		success : function(re){
			let boardlist = JSON.parse(re)
			let html = '<tr>'
						+ '<th> 번호 </th>'
						+ '<th> 제목 </th>'
						+ '<th> 작성자 </th>'
						+ '<th> 날짜 </th>'
						+ '<th> 조회수 </th>'
						+ '</tr>'
			for(let i = 0; i<boardlist.length; i++){
				let b = boardlist[i]
				html += '<tr>'
						+ '<td> '+b.bno+' </td>'
						+ '<td onclick="viewlaod('+b.bno+')"> '+b.btitle+' </td>'
						+ '<td> '+b.bname+' </td>'
						+ '<td> '+b.bdate+' </td>'
						+ '<td> '+b.view+' </td>'
						+ '</tr>'
			}
			html += '<button onclick="writepage()"> 글쓰기 </button>'
			document.querySelector('#list').innerHTML = html
		}
	})
}

function writepage(){
	location.href="http://localhost:8080/jsptest/html/write.html"
}

function viewlaod(bno){
	$.ajax({
		url : "/jsptest/view",
		data : {"bno" : bno ,  "type" : "list"},
		success : function(re){
			location.href="http://localhost:8080/jsptest/html/view.html"
		}		
	})
}
