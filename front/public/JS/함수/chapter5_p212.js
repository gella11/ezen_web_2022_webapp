/**
 
 
 	기본매개변수 : 매개변수의 값이 정해져 있는 경우
 		- 함수호출시 매개변수의 값이 없을때의 기본(초기)값
 		- 매개변수의 값이 없을때 undefined -> 기본매개변수
 	
 
 
 */
 //		1. 매개변수의 기본값 정하기
 //			8590, 40 이 디폴트값
 function earnings(name, wage = 8590 , hours = 40){
	console.log(` # ${naver} 님의 급여 정보`)
	console.log(` -시급 : ${wage}원`)
	console.log(` -근무시간 : ${hours}시간`)
	console.log(` -급여 : ${wage*hours}원`)
}

//function earnings(name){
//	wage = 8590
//	hours = 40
//	console.log(` # ${naver} 님의 급여 정보`)
//	console.log(` -시급 : ${wage}원`)
//	console.log(` -근무시간 : ${hours}시간`)
//	console.log(` -급여 : ${wage*hours}원`)
// }
// 위와 동일한 값이지만 wage / hours를 바꾸기가 어려움.

//		함수호출
earnings('구름')

//		함수호출
earnings('별' , 10000)

//		함수호출
earnings('인성' , 10000 , 52)