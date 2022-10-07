/*
	
	자료		: 데이터 ( 정보 / 값)
	자료형		: 데이터 타입
		1. 숫자
				숫자 : 소수점이던 그냥 숫자던 그냥 쓰면 됨.
		2. 문자열
				문자열 	: '' ""
				문자열 연결	: +
				문자열 길이	: 문자열.length
		3. 불
				true / false
				=== 같다	!== 같지않다
				&& || (자바와 동일)
	
	자료형 검사	: typeof(데이터)	해당 데이터의 자료형 확인
	
	자료형 변환
		Number(데이터) : 숫자형 변환
		String(데이터) : 문자열형 변환
		Boolean(데이터): 불 형 변환
	
	입력	   메시지 : prompt('ddd')
 	확인/취소 메시지 : confirm('ddd')
	
	
 */
 
 console.log("가나다라");
 console.log('가나다라');
 console.log('가나'+'다라');
 console.log("가나다라".length);
 console.log(273)
 console.log(273.3)
 /*--------------------------------------------------*/
  /*--------------------------------------------------*/
   /*--------------------------------------------------*/
 
 /*
 		상수		: 고정된 값	[ const ]
 		변수		: 변하는 수	[ let ]
 	undefined	: 값이 없음	[ java는 null ]	
 */
 const pi = 3.141529
 console.log(pi)
 
 
 let pi2 = 3.141529
 console.log(pi2)
 pi2 = 4.14
 console.log(pi2)
 
 
 
 /*--------------------------------------------------*/
  /*--------------------------------------------------*/
   /*--------------------------------------------------*/
 
 // 문제1 : 지폐 세기
 // 조건	 : 금액 321000
 // 출력  : 십만원 3장
 
 //const input = prompt('6자리 숫자를 입력해주세요')
 let input = prompt('6자리 숫자를 입력해주세요')		
 let cash = 321000
 console.log('십만원 : '+ cash/100000 + '장')
 console.log('만원 : '+ cash/10000 + '장')
 console.log('천원 : '+ cash/1000 + '장')
 	
 
 