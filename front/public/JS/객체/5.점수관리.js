/*


	학생 점수 프로그램
		1. 학생 객체 설게
		2. HTML에서 입력받은 데이터를 js객체에 저장
			
			1. 해당 js 함수 호출하기
			- <button onclick="함수명()"
			
			1. HTML에서 입력받은 데이터를 js객체에 저장
			- 학생 이름 중복 체크
				-중복
			- 함수 등록 함수 사용
			- document.getElementById('id명').value;
			
			2. 여러개의 객체를 저장 >>> 배열
				- 배열은 다른 함수에서도 사용할 예정이므로 밖으로 빼야함.
			
			3. HTML 초기화
			4. 학생 점수 출력
				js 처음 열었을 때 1번 / 점수 등록할 때 마다

 */
 // js 시작할 때 깔고 가는 것
 
 let studentlist = []
 학생출력()
 
 /*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
 /*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
 /*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
 
 function 점수등록() {
	
	const student = {
		name: 	document.getElementById('name').value ,
		kor	: 	document.getElementById('kor').value  ,
		eng :	document.getElementById('eng').value ,
		mat :	 document.getElementById('mat').value
	}
	
	if( 이름중복체크( student.name) ){
		return // 함수 종료
	}
	
	studentlist.push(student)
	alert('학생 점수 등록이 되었습니다.')
	console.log(studentlist)
	
	document.getElementById('name').value = ''    // 점수 입력 후 등록한 뒤에, 다시 입력할 수 있게끔 공백처리
	document.getElementById('kor').value = ''
	document.getElementById('eng').value = ''
	document.getElementById('mat').value = ''
	
	학생출력()
}
 /*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
 /*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
 /*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
 
function 이름중복체크(name) {
	for(let i = 0; i<=studentlist.length-1 ; i++){
		// 배열이 3일 경우
		// 길이 : 1~3
		// 인덱스 : 0~2
		if( studentlist[i].name === name ){
			alert( '이미 존재한 학생명 입니다.')
			return true
		}
	}
	return false
}

/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */

function 학생출력(){
	// 1. 변수에 html태그[문자열]를 저장하기
	let html = '<tr>' + 
					'<th>등수</th>' +
					'<th>학생명</th>'+
					'<th>국어</th>' +
					'<th>영어</th>' +
					'<th>수학</th>' +
					'<th>총점</th>' +
					'<th>평균</th>' +
					'<th>비고</th>' +
				'</tr>'
	
	// 배열내 데이터를 하나씩 꺼내기 >>> 객체 정보를 html 화			
	for(let i = 0; i<studentlist.length ; i++){
		// i는 0부터 배열내 마지막인덱스까지 
		
		let sum = Number(studentlist[i].kor) + Number(studentlist[i].eng) + Number(studentlist[i].mat)
		// html input 박스 자체가 text 타입 문자형이므로. 
		// 또는 정수등록 함수에 Number 기입
		
		let avg = sum / 3
		
		
		html += '<tr>' + 
					'<th>'+studentlist[i].name+'</th>' +
					'<th>'+studentlist[i].name+'</th>'+
					'<th>'+studentlist[i].kor+'</th>' +
					'<th>'+studentlist[i].eng+'</th>' +
					'<th>'+studentlist[i].mat+'</th>' +
					'<th>'+sum+'</th>' +
					'<th>'+avg+'</th>' +
					'<th><button onclick="학생삭제('+i+')">삭제</button></th>' +
				'</tr>'
					// 문자처리 x
					// 변수는 앞전에 미리 정의된 단어 [ 키워드 = 컴퓨터가 알고 있는 단어는 문자처리하면 안됨]
				
	}
	// 2. 해당 변수를 html에 출력하기
	document.getElementById('listtable').innerHTML = html
}


/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
// 매개변수 : 삭제할 식별번호( 배열 내 저장된 순서번호 = 인덱스 )
function 학생삭제(i){
	alert( studentlist[i].name + '의 점수를 삭제합니다.')
	studentlist.splice( i , 1 )	// 화면에 표시되는 것은 HTML이므로 데이터상 삭제가 되었지만. 학생출력 함수를 다시 호출 ()업데이트)
	학생출력()
}

/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */


