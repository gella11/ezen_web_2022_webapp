
// 게시글 등록
function registration(){
	let info = {
		btitle 		: document.querySelector("#btitle").value,
		bcontent 	: document.querySelector("#bcontent").value,
		bname 		: document.querySelector("#bname").value,
		bpassword 	: document.querySelector("#bpassword").value		
	}
	$.ajax({
		url:"/jsptest/write",
		data : info,
		success :function(re){
			if(re === 'true'){ alert('글 등록 완료'); location.reload() }
			else			 { alert('글 등록 실패'); location.reload()}
		}
	})
	
}

function listpage(){
	location.href="http://localhost:8080/jsptest/html/list.html"
}