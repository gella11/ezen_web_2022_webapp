


let pageinfo = {
	listsize : 5,
	page : 1,
	key : "",
	keyword: ""
}

// 게시글 수 사용자가 정하기
function blistsize(){
	pageinfo.listsize = document.querySelector('.listsize').value
	list(1)
}


// 검색
function bsearch(){
	let key 	= document.querySelector('.key').value
	let keyword = document.querySelector('.keyword').value
	console.log(key)
	console.log(keyword)
	
	pageinfo.key = key
	pageinfo.keyword = keyword
	console.log(pageinfo)	
	
	list(1)
	
}



// 페이징
list(1)
function list(page){
	
	pageinfo.page = page 
	
	
	let today = new Date();  
	let year = today.getFullYear(); // 년도
	let month = today.getMonth() + 1;  // 월
	let date = today.getDate();  // 날짜
	let day = today.getDay();  // 요일
	let date1 = (year + '-' + month + '-' + date)
	
	$.ajax({
		url:"/jspweb/board/list",
		data : pageinfo,
		success : function(re){
			let boards = JSON.parse(re)
			console.log(boards)
			let boardlist = boards.data

			let html = '<tr>'
							+'<th> 번호 </th> <th> 제목 </th> <th>작성자</th> '
						+	'<th> 작성일 </th> <th> 조회수 </th>'
						+'</tr>'
			
			for(let i = 0 ; i<boardlist.length; i++){
				let b = boardlist[i]
				
				//var result1 = b.bdate.substr(0, 10);
				//	if(result1 !== date1){
				//	b.bdate = result1
				//	}
				
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
			document.querySelector('.btable').innerHTML = html
			//btable.innerHTML = html
			
			
			// 페이징 버튼 html 구성
			let pagehtml =""
			if(page <= 1){pagehtml += '<button type="button" onclick="list('+(page)+')"> 이전 </button>'}
			else		 {pagehtml += '<button type="button" onclick="list('+(page-1)+')"> 이전 </button>'}
			
			for(let page = boards.startbtn; page<=boards.endbtn; page++){
				pagehtml +='<button type="button" onclick="list('+page+')"> '+page+' </button>'
			}
			
			if(page >= boards.totalpage){pagehtml += '<button type="button" onclick="list('+(page)+')"> 다음 </button>'}
			else					    {pagehtml += '<button type="button" onclick="list('+(page+1)+')"> 다음 </button>'}
			
			
			document.querySelector('.pagebox').innerHTML = pagehtml
			
			document.querySelector('.totalsize').innerHTML = boards.totalsize
			
			
		}
	})
}


function viewload(bno){
	$.ajax({
		url:"http://localhost:8080/jspweb/board/viewload",
		data:{"bno" : bno},
		success : function(re){
			location.href="http://localhost:8080/jspweb/board/view.jsp"
		}
	})
}




