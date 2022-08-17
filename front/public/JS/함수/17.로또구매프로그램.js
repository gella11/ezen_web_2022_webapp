/*
	로또 구매 
		1.사용자 6개 버튼 선택한다.
			조건: 한번클릭(선택) 두번클릭(취소) , 최대6개
		2.컴퓨터 추첨번호[1~45난수] 생성
		3.사용자 추첨번호 비교 결과
	
 */
// * 변수 선언 
// 변수는 지역변수 특징 = { } 안으로 들어갈수 있다. { } 밖으로 못나감  
let select_numbers = [ ] // 내가 선택한 번호 리스트 	// 여러개 함수에서 호출(사용) 될 예정 
let lotto_numbers = [ ] // 컴퓨터 난수 번호 리스트 
// 1. 버튼 만들기함수 
function btn_print(  ){
	let btnlist = '' // 1~45의 버튼을 저장하는 변수 
	for( let i = 1 ; i<=45 ; i++ ){
		// i는 1부터 45까지 1씩증가 반복
		btnlist += `<button id=${i} onclick=btn_click(${i}) >${i}</button>`
		// i가 5 배수이면 줄바꿈
		if( i % 5 == 0 ){ btnlist +='<br>'}
	} // for end 
	// 현재문서의 btnbox 라는 id 갖는 태그 호출해서 html에 변수 대입 
	document.getElementById('btnbox').innerHTML = btnlist;
}
// 2. 버튼 눌렀을때 함수 [ 매개변수 : i -> 내가 클릭한 버튼의 순서 ]
function btn_click( i ){
	// 배열내 존재하는 숫자 인지 확인 
	let index = select_numbers.indexOf( i )
	if ( index >= 0 ){ // 선택한 수가 배열내 존재하면 
	// 배열명.indexOf( 데이터 ) : 배열내 해당데이터의 인덱스 검색 
		// 해당 데이터가 존재하면 찾은 인덱스 출력  // 해당 데이터가 존재하지 않으면 -1 출력 
		alert('이미 선택한 번호입니다. [ 취소합니다. ]')
		select_numbers.splice( index  , 1 ) // 배열명.splice( 삭제할인덱스 , 개수 )
	}else{ // 선택한 수가 배열내 존재하지 않으면 
		// 배열내 개수 체크 
		if( select_numbers.length == 6 ){ // 만약에 배열내 숫자가 6개 이면 
			alert('더 이상 선택할수 없습니다.')
			return // 함수 종료[ 아래 코드 실행X ]
		}
		// 선택한 번호 배열 저장 
		select_numbers.push( i ) // 배열명.push( 데이터 ) : 배열에 데이터 추가 
	}
	// 내가 선택한 번호들 해당 id태그에 출력 
	document.getElementById('selectbox').innerHTML = select_numbers
}
// 3. 추첨번호 생성 함수 
function lotto_number(){
	if( select_numbers.length != 6 ){
		alert('6개 수를 모두 입력후 추첨 해주세요 ')
		return // 함수 종료[ 아래 코드 실행X ]
	}
	// 난수 생성 [ 1~45 ]
	while( true ){ // 무한루프 [ 추첨번호가 6개 되면 종료 ]
														// Math.random()  0~1 사이의 실수 생성 
		let rand = Math.floor( (Math.random()*45)+1 )   // ( Math.random()*끝값 )+시작값 : 시작값 ~ 끝값 사이의 난수 실수 생성 
		let index = lotto_numbers.indexOf( rand )		// Math.floor( 난수 ) : 소수점 버림 함수 
		if( index == -1  ){ // 존재하지 않으면  
			if( lotto_numbers.length == 6 ){ // 배열내 수가 6개 이면 반복문 종료 
				break // 가장 가까운 반복문 탈출 
			}else{ // 배열내 수가 6개 가 아니면 해당 난수를 배열에 저장 
				lotto_numbers.push( rand )
			} // else end 
		} // if end 
	} // while end 
	// html 태그 에 배열 출력
	document.getElementById('lottobox').innerHTML = lotto_numbers
	// 결과 함수 출력 
	lotto_result()
}
// 4. 추첨번호 비교 결과 함수 
function lotto_result(){

	let count = 0  // 두 배열 간 총 동일한 숫자의 개수 
	let result_numbers = select_numbers.filter( (value) => lotto_numbers.includes(value) )
	count = result_numbers.length
	let msg = '' // 출력할 메시지를 저장하는 변수 
	if( count == 0 ){ msg +='꽝'}
	else if( count == 1 ){  msg +='1개 맞았습니다.' + result_numbers }
	else if( count == 2 ){  msg +='2개 맞았습니다.[5등]' + result_numbers }
	else if( count == 3 ){  msg +='3개 맞았습니다.[4등]' + result_numbers }
	else if( count == 4 ){  msg +='4개 맞았습니다.[3등]' + result_numbers }
	else if( count == 5 ){  msg +='5개 맞았습니다.[2등]' + result_numbers }
	else if( count == 6 ){  msg +='6개 맞았습니다.[1등]' + result_numbers }
	document.getElementById('resultbox').innerHTML = msg
}



/*
	두 배열간 교집합[동일한 데이터] 개수 구하기 방법 
	1. 
	for( let i of select_numbers ){
		for( let j of lotto_numbers ){
			if( i == j) { 
				count++ 
			} 
		}
	} 
	
	2.
	for( let i of select_numbers ){
		if( lotto_numbers.indexOf( i ) != -1 ){ count++; }
	}
	
	3.
	let result_numbers = select_numbers.filter( (value) => lotto_numbers.includes(value) )
	count = result_numbers.length
*/