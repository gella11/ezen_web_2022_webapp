
bview()

function bview(bno){
	$.ajax({
		url:"/jspweb/board/view",
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
				let updatebtn = '<button> <a href="../board/update.jsp"> 수정 </a> </button>'
				btnbox.innerHTML += updatebtn
			}
			
		}
	})	
}

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