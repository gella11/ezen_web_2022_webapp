/*

	객체지향 프로그램
	객체 [ Object ]
	객체 멤버
		1. 변수 , 상수 , 배열[object] , 함수

 */
 
  /**/
  
 /* p.291 */
  
 // 1. 객체 설정 
  
  const object = {
	name : '혼자 공부하는 파이썬' ,
	price : 18000 ,
	publisher : '한빛미디어'
}

// 2. 속성 확인 하는 방법

if(object.name !== undefined){
	console.log('name 속성이 있습니다.')
} else {
	console.log('name 속성이 없습니다.')
}

/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/

if(object.author !== undefined){
	console.log('author 속성이 있습니다.')
} else {
	console.log('author 속성이 없습니다.')
}

/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/

 /* p.293 */
  
 // 삼항 ( 항이 3개 ) 연산자 
 // 	? >>> 참이면 뭐시기 거짓이면 뭐없..
  
 object.name = object.name !== undefined ? object.name : '제목 미정'
 object.author = object.author !== undefined ? object.author : '저자 미정'
  
 // 객체 출력
 console.log(object)


/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/

 /* p.294 
 
 // 배열 기반의 다중 할당
 // 원래 배열 let array = [ 1, 2, 3 ] 
 let [ a , b ] = [ 1, 2 ]
 console.log( a )
 console.log( b )

[ a , b ] = [ b , a ]
 console.log( a )
 console.log( b )
*/



 /* p.295 */
 
 let arrayA = [1, 2, 3, 4, 5]
 const [ a, b, c] =arrayA
 console.log(a, b, c)



 /* p.295 */
 const {name , price} = object
 	// object 객체내 속성 꺼내기 >>> 변수로 꺼내서 사용한다. 할당이 된다.
 	 console.log( name )
 	 console.log( price )
 	 
 const {n = name , p = price} = object
 	// object 에 name 의 값을 n이란 곳에 할당한다. 
 	 console.log( name )
 	 console.log( price )	 
 	 
 let n2 = object.name 
 



























