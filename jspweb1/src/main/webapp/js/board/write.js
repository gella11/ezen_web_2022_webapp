


function bwirte(){
	
	let inputs = document.querySelectorAll('input')
	console.log(inputs)	
	
	let data ={
		// input[0] 은 헤더
		btitle : inputs[1].value ,
		bcontent: inputs[2].value
	}
	console.log(data)
	$.ajax({
		url : "/jspweb/board/write",
		data : data,
		success : function(re){
			if(re ==='true'){
				location.href="list.jsp"
			}else{alert('글 등록 실패')}
		}
	})
	
	
}