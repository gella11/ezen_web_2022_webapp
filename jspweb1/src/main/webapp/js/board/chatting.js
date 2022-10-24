
let mid = document.querySelector('.mid').value

//////////////////////////// 로 그 인  여 부 ////////////////////////////////////

// 2. 웹소켓 선언 
let clientsocket = null; 
// 3. 접속 제어 
if( mid != 'null'){
	// 웹소켓에 서버소켓으로 연결[매핑]
	clientsocket 
	= new WebSocket('ws://localhost:8080/jspweb/chatting/'+mid);
	// 아래에서 구현 메소드를 객체에 대입
	clientsocket.onopen 	= function(e){ onopen(e) 	 }
	clientsocket.onclose 	= function(e){ onclose(e) 	 }
	clientsocket.onmessage  = function(e){ onmessage(e)  }
	clientsocket.onerror	= function(e){ onerror(e)	 }
}else{ alert('로그인하고 오세요~'); location.href='../member/login.jsp'; }


function onopen(e) { alert( e ) }
function onclose(e){ alert( e ) }

function send(){ 
	let msg = {
		content : document.querySelector('.msgbox').value , 
		mid : mid , 
		date : new Date().toLocaleTimeString() 
	}
	clientsocket.send( JSON.stringify(msg) )
	document.querySelector('.msgbox').value = ''
}

/////////////////////////////////////////////////////////////////////////////

// 2. 메소드 구현 [접속][나갔을 때][메시지 보내기] [메시지 받았을 때]
function onopen	  (e){alert('채팅방에 들어왔습니다.'+e)}
function onclose  (e){alert('채팅방에 나갔습니다.'+e)}

////////////////////////////// ↓↓ 메시지 보내기 ///////////////////////////////////
////////////////////////////// ↓↓ 메시지 보내기 ///////////////////////////////////
////////////////////////////// ↓↓ 메시지 보내기 ///////////////////////////////////

// 보내기 send
function send(){
	// 보낼 데이터 객체 구성
	let msg = {
		type : "msg",
		content : document.querySelector('.msgbox').value,
		from : mid,
		date : new Date().toLocaleTimeString(), // JS 날짜 Date api에, toLocaleTimeString 시간
		img : '개.jfif'
	}
	// 메시지 전송
	// 전송 후 입력상자 초기화
	websocket.send(JSON.stringify(msg))	// 해당 객체를 JSON 형식으로 바꿔서 보내줌.
	document.querySelector('.msgbox').value = ''
}

// 전송방식 1)  메시지 입력 상자에서 보내기를 눌렀을 때	send()
// 전송방식 2)  메시지 입력 상자에서 엔터를 눌렀을 때		enterkey()
function enterkey(){
	if(window.event.keyCode == 13){ // 엔터를 눌렀을 때 //key'C'ode 대문자 조심
		send()
	}
	 
}
//////////////////////////// ↓↓ 메시지 받 음  ////////////////////////////////////
//////////////////////////// ↓↓ 메시지 받 음  ////////////////////////////////////
//////////////////////////// ↓↓ 메시지 받 음  ////////////////////////////////////
	

// 메시지 받았을 때					  
function onmessage(e){ // e(event약자) : 서버소켓으로 부터 받은 정보 담겨져있음. 아무말 꺼도 됨.
	let msg = JSON.parse(e.data)		// 파싱하면 JSON 형식만 가능. {키 : 값} 들만 파싱되는데. HTTP는 무조건 문자. 문자여서 안됨. 그래서 send에서 보내 줄 때 JSON형식으로 바꿔서 보내줘야 함.
	
	if(msg.type == "msg"){
			if(msg.mid==mid){ // 본인 글
			let html = document.querySelector('.contentbox').innerHTML
			
			html += '<div class="secontent my-3">' 	
						+'<span class="date"> '+msg.date+' </span>'
						+'<span class="content"> '+msg.content+' </span>'
						+'</div>'
			document.querySelector('.contentbox').innerHTML += html
		}else{ //남의 글
			let html = document.querySelector('.contentbox').innerHTML
			html += +'<div class="row g-0 my-3">'
					+'			<div class="col-sm-1 mx-2"> '
					+'				<img width="100%;" class="rounded-circle" alt="" src="/jspweb/img/'+msg.img+'">'
					+'			</div>'
					+'			<div class="col-sm-9"> '
					+'				<div class="recontent">'
					+'					<div class="name">'+msg.mid+'</div>'
					+'					<span class="content">'+msg.content+'</span>'
					+'					<span class="date">'+msg.date+'</span>'
					+'				</div>'
					+'			</div>'
					+'		</div>'
			document.querySelector('.contentbox').innerHTML += html	
		}
	}
	else if(msg.type =="emo"){}
	
	
	
	
	let contentbox = document.querySelector('.contentbox')
	// 받은 메시지를 html 꾸미기
	let html = '<div>'
				+ '<span>['+msg.from+']</sapn>'
				+ '<span>'+msg.content+'</sapn>'
				+ '<span>['+msg.date+']</sapn>'
				+ '</div>'
	contentbox.innerHTML += html
}




emoview()
function emoview(){
	html = ''
	for(let i = 1; i<=43 ; i++){
		html += '<img src="/jspweb/img/imoji/emo'+i+'.gif" onclick="emosend('+i+')"> '
	}
	document.querySelector('.dropdown-menu').innerHTML += html
}

function emosend(i){
	alert(i + "번째 이모티콘 선택")
	
	let msg = {
		type : "emo" , // 이모티콘
		content : i , // 이미지번호
		mid : mid, // 보낸 사람
		date : new Date().toLocaleTimeString(),
		img : '개.jfif'
	}
}













