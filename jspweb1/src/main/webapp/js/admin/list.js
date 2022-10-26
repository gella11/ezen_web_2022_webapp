getproduct()
// 1. 모든 제품 호출 메소드 
function getproduct(){
	$.ajax({
		url :"/jspweb/regist" ,
		type : "get", 
		success : function( re ){
			let json = JSON.parse( re )
			
			
			let tag ='<tr>'+
						'<th>카테고리번호 </th>'+
						'<th>제품명</th>'+
						'<th>가격</th>'+
						'<th>할인율</th>'+
						'<th>판매가</th>'+
						'<th>상대</th>'+
						'<th>제품이미지</th>'+
						'<th>제조일</th>'+
						'<th>카테고리번호</th>'+
					'</tr>';
					
					
			for(let i = 0 ; i<json.length; i++){
				let l = json[i];
				let img = '/jspweb/admin/pimg/'+json[i].pimg
				let img2 = '<img src="'+img+'">'
				tag += '<tr>' +
				     	'<td>'+l.pcno+'</td>'+
					  	'<td>'+l.pname+'</td>'+
		              	'<td>'+l.pcomment+'</td>'+
					 	'<td>'+l.pprice+'</td>'+
						'<td>'+l.pdiscount+'</td>'+
						'<td>'+l.pactive+'</td>'+
						'<td>'+img2+'</td>'+
						'<td>'+l.pdate+'</td>'+
						'<td>'+l.pcno+'</td>'+
		            	'</tr>';
			}
			document.querySelector('.table').innerHTML = tag;
		}
	})
}

