
// 상진 
// jsp 등록된 섹션 값 가져오기
//let user_email = document.querySelector('.mid').value

// 상진
// 친구 리스트 출력
f_list()
function f_list(){
	$.ajax({
		url : "/jspweb/F_list",
		data : {"user_email" : user_email},
		success : function(re){
			alert(re)
			let list = JSON.parse(re)
			let html = document.querySelector('.f_list').innerHTML
			
			
			
			for(let i = 0 ; i<list.length; i++){
				let l = list[i]
				html += '<tr onclick="모달()" value='+l.user_num+' id='+l.user_num+' >'
						+	'<td>'+l.profile+' </td>'
						+	'<td>'+l.user_name+'</td>'
						+	'<td>마지막대화내용 추후에</td>'
						+'</tr>';
			}
			document.querySelector('.f_list').innerHTML = html;
		}
	})
}