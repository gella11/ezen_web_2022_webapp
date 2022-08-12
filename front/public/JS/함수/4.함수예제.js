/*

	함수 : 미리 정의된 코드집합
		alert() / prompt() >>> js 내장함수
	함수 만들기 : 
		function 함수명 ( 매개변수1 , 매개변수2 ~~~){
			실행코드
			return리턴값
		}
		
	함수 호출
		js : 함수명 ( 매개변수1 , 매개변수2 ~ )
		html : tag 속성내 이벤트 속성
			onclick : 클릭했을 때
			onclick ="함수명(매개변수1, 매개변수2)"
			
 */
 // 1. 매개변수 x 리턴값x 함수 정의
 function 함수1(){ alert('함수1실행')}
 //	2. 매개변수 o 리턴값x 함수 정의
 function 함수2(value){
	alert('함수2실행 매개변수 : '+ value)
}
  function 함수3(value1, value2){
		return value1 + value2
}
function 함수4(){
	alert('함수4실행')
	return 10
}
 //호출
 함수1()
 함수2(50) // 함수 호출시 매개변수 전달
 let result = 함수( 3, 5)
 let result2 = 함수4()
 
 
 // p.204 최솟값을 구하는 함수
 function min (array){
	let output = array[0] 		//array에서 0번 인덱스 호출해서 output 대입
	for( const item of array){	//배열의 요소를 하나씩 item에 대입 반복
		if(output > item){		
			output=item
		}
	}
	return output;
} 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 