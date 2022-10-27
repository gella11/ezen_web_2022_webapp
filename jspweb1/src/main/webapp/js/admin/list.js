
getproduct()
// 1. 모든 제품 호출 메소드 
function getproduct(){
	$.ajax({
		url :"/jspweb/regist" ,
		data : { "type" : 1 } , 
		type : "get", 
		success : function( re ){
			let json = JSON.parse( re )
			let tag ='<tr>'+
						'<th>제품번호 </th>'+
						'<th>제품명</th>'+
						'<th>가격</th>'+
						'<th>할인율</th>'+
						'<th>판매가</th>'+
						'<th>상태</th>'+
						'<th>제품이미지</th>'+
						'<th>제조일</th>'+
						'<th>카테고리번호</th>'+
					'</tr>';
					
					
			for(let i = 0 ; i<json.length; i++){
				let l = json[i];
				let img = '/jspweb/admin/pimg/'+json[i].pimg
				let img2 = '<img src="'+img+'" style="width:100px;%">'
				tag += '<tr>' +
					     	'<td>'+l.pno+'</td>'+
						  	'<td>'+l.pname+'</td>'+
			              	'<td>'+l.pcomment+'</td>'+
						 	'<td>'+l.pprice+'</td>'+
							'<td>'+l.pdiscount+'</td>'+
							'<td>'+l.pactive+'</td>'+
							'<td>'+img2+'</td>'+
							'<td>'+l.pdate+'</td>'+
							'<td>'+l.pcno+'</td>'+
							'<td>' + 
								`<button type="button" onclick="updatemodal( ${l.pno} )">수정</button>`+
								`<button type="button" onclick="deleteproduct( ${l.pno} )"> 삭제 </button>`+	
							'</td>'+ 
		            	'</tr>';
			}
			document.querySelector('.table').innerHTML = tag;
		}
	})
}

// 2-1. 수정 모달 실행 메소드 
function updatemodal( pno ){
	// 1. 해당 모달을 열러주는 버튼에 강제클릭 이벤트 실행 
	document.querySelector(".updatemodalhtn").click() // 해당 버튼을 강제클릭하는 이벤트 실행
	console.log('수정버튼 클릭')
	// 2. 해당 모달에 기존 내용물 넣기 
		// 2-1 : 해당 pno의 제품정보 호출 
		$.ajax({
			url : "/jspweb/regist",
			data : { "type" : 2 , "pno" : pno } , 	// 타입이 2 이면 개별 제품 호출 
			type : "get" ,
			success : function( re ){ 
				let json = JSON.parse(re)
				document.querySelector('.pno').value = json.pno
				document.querySelector('.pname').value = json.pname
				document.querySelector('.pcomment').value = json.pcomment
				document.querySelector('.pprice').value = json.pprice
				document.querySelector('.pdiscount').value = json.pdiscount
			}
		})
	}
// 2-2. 수정 처리 메소드
function updateproduct(){
	// 1.수정할 정보
	let form = document.querySelector('.updateform')
	let formdata = new FormData( form )
	// fomrdata 속성 추가 
		// formdata.set('속성명' : 데이터 )
		// formdata.set('pno' : pno )
	$.ajax({ 
		url : "/jspweb/regist" , 
		type : "put" ,  // 해당 서블릿주소 의 doPut메소드과 통신
		data : formdata , 
		processData : false , 
		contentType : false , 
		success : function( re ){ 
			if(re === 'true'){
				alert('수정 완료')
				// 1. 모달닫기
				document.querySelector(".modelclosebtn").click()
				// 2. 새로고침
				pagechage('list.jsp')
			}
			else{
				alert('수정 실패')
			}
		}
	})
}

// 3. 삭제 처리 메소드
function deleteproduct(pno){
	if(confirm("정말삭제?")){
		alert('그려 삭제할게유')
		$.ajax({
			url :"/jspweb/regist",
			data : {"pno" : pno},
			type : "delete", 
			success : function( re ){
				if(re ==='true'){
					alert('삭제성공');
					// location.reload()
					// 대쉬보드 안에 있는 jsp이기 때문에 이것은 대쉬보드를 새로고침함으로 하면 안됨
					pagechage('list.jsp')
					// 우리가 만들어놓은 페이지전환 함수로 해야함.
					// 또한 다른 js를 쓸 수 있는 이유는 대쉬보드 안에 다른 jsp를 띄우기 때문.
				}else{
					alert('삭제실패')
				}
			}
		})
	}
}

// 5. 카테고리 호출 메소드 [실행조건 : 페이지 열렷을 때]
getpcategory()
function getpcategory(){
	$.ajax({
		url:"/jspweb/pcategory",
		type: "get",
		success : function(re){
			let json = JSON.parse(re)
			let html = ""
			for(let i = 0 ; i<json.length; i++){
				let category = json[i]
				html += '<input type="radio" name="pcno" value='+category.pcno+'> '+category.pcname+' '
			}
			document.querySelector('.categorybox').innerHTML = html
			
		}
	})
}

