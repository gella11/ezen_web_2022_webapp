
// 1. 등록 버튼을 눌렀을 때
function regist(){
	let form = document.querySelector('form')
	let formdata = new FormData(form)
	
	console.log(formdata)
	
	$.ajax({
		url:"/jspweb/regist",
		data : formdata,
		type : "post",					// form 전송이 첨부파일있을 경우 3가지 필수 write.js참고
		processData : false,			// form 전송이 첨부파일있을 경우 3가지 필수 write.js참고
		contentType : false,			// form 전송이 첨부파일있을 경우 3가지 필수 write.js참고
		success : function(re){
			if( re == 'true' ){ alert("제품등록"); pagechage('regist.jsp')}
			else			  { alert("제품등록실패") }
		}
	})
}


// 2. 첨부파일 등록(변경)했을 때 미리보기
let pimg = document.querySelector('#pimg')
	pimg.addEventListener('change',function(e){	// e 꼭 넣어야함 e:event 객체(이벤트 정보[target] 여기선 change이벤트 , 누가 뭐를[]data])
	// 1) js 파일 클래스 []
	let file = new FileReader() // 객체생성
	console.log(file+"는 file")
	console.log(e+"는 e")
	console.log(e.target+"는 e.taget")
	console.log(e.target.files[0]+"는 e.taget.files[0]")
	// 2) 해당 펌부된 파일 경로 알기
	file.readAsDataURL(e.target.files[0])
	// 3) 이미지 태그에 첨부된 이미지 대입
	file.onload = function(e){ // e는 onload 이벤트 정보
		document.querySelector('#pimgpre').src = e.target.result
	}
})


// 3. 카테고리 추가 버튼을 눌렀을 때 이벤트
function pcategoryview(){
	document.querySelector('.pcategoryaddbox').innerHTML
		= '<input type="text" id="pcname">'
		+ '<button type="button" onclick="pcategoryadd()"></button>'
}

// 4. 카테고리 등록 버튼을 눌렀을 때 이벤트
function pcategoryadd(){
	let pname = document.querySelector('#pcname').value
	$.ajax({
		url:"/jspweb/pcategory",
		data :{"pcname" : pname },
		type : "post",
		success : function(re){
			if(re == 'true'){
				alert('카테고리 등록 성공')
				document.querySelector('.pcategoryaddbox').innerHTML =''
				getpcategory()
			}else{
				alert('카테고리 등록 실~패')
			}
		}
	})
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
			document.querySelector('.pcategorybox').innerHTML = html
			
		}
	})
}









