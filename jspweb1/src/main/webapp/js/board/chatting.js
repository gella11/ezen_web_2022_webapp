
let websocket = null // 웹소켓 선언만

//////////////////////////// 로 그 인  여 부 ////////////////////////////////////

let mid = document.querySelector('.mid').value

if(mid !== null){
	// 1. JS 지원하는 웹소켓 클래스[new WebSocket()]
	// f5번 누른 만큼 소켓이 생김. 방지법은 추후에 배울 것
	// f5번 메모리는 날라감. ex)웹게임
	websocket = new WebSocket('ws://localhost:8081/jspweb/chatting/'+mid)
	// 3. 2번에서 구현된 메소드를 클라이언트 소켓에 대입
	websocket.onopen    = function(e){onopen(e)}
	websocket.onclose   = function(e){onclose(e)}
	websocket.onmessage = function(e){onmessage(e)}
	
}else{
	alert('로그인 필요합니다.')
	location.href="../member/login.jsp"
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
		content : document.querySelector('.msgbox').value,
		from : mid,
		date : new Date().toLocaleTimeString() // JS 날짜 Date api에, toLocaleTimeString 시간
		
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
	console.log(e)
	console.log(e.data)
	let msg = JSON.parse(e.data)		// 파싱하면 JSON 형식만 가능. {키 : 값} 들만 파싱되는데. HTTP는 무조건 문자. 문자여서 안됨. 그래서 send에서 보내 줄 때 JSON형식으로 바꿔서 보내줘야 함.
	console.log(msg+"msg")
	let contentbox = document.querySelector('.contentbox')
	// 받은 메시지를 html 꾸미기
	let html = '<div>'
				+ '<span>['+msg.from+']</sapn>'
				+ '<span>'+msg.content+'</sapn>'
				+ '<span>['+msg.date+']</sapn>'
				+ '</div>'
	contentbox.innerHTML += html
}


