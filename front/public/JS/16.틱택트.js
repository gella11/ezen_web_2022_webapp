/*
	틱택트( 삼묵 )
		1. 게임판 구현 [9칸]
		2. 버튼 눌림 기능
		3. 사용자(선택) vs 컴퓨터(랜덤)
		4. 승리자 판단
	
	
*/

게임판그리기() //js 실행되면서 무조건 함수1번 실행

//	1. 게임판 출력하는 변수
function 게임판그리기(){
	let 게임판 ='' // 여러개 버튼(태그)을 저장하는 변수
	for( let i = 0 ; i<9 ; i++){ // i는 0부터 8까지 1씩 증가
		게임판 += `<button onclick=버튼선택(${i})>${i}</button>`
		if( i % 3 == 2){게임판 += '<br>'}
		// 게임판 변수에 버튼(tag)을 누적 더하기
	}
	// 문서(html)의 id가 hameboard의 
	document.getElementById('gameboard').innerHTML = 게임판
}

//	2. 버튼 선택 함수
function 버튼선택(i){
	alert ( i + '버튼눌림')
	// 사용자 선택한 버튼의 id의 html -> o 변경
	document.getElementById( i ).innerHTML = ' O '
	// [컴퓨터] 난수 발생
		// Math			// Math : 수학 관련 메소드 제공하는 클래스
		// random()		// Math.random() : 0~1 사이의 난수 발생
	//Math.random() * 9	// Math.random() * 끝번호 -1
						// ()math.random() * 9 )+1 : 1~10 사이의 난수
	let rand = Math.floor(Math.random() * 9 )// 0~8
		//Math.floor 가장 가까운 정수로 내림
		//Math.round() 반올림
		//Math.ceil() 올림
	alert ( '난수 :' + rand )
	document.getElementById( rand ).innerHTML = 'X'
}
//	3. 게임 상태(상황) 함수
function 상황출력(){}

//	4. 게임 결과 함수
function 게임결과(){}



