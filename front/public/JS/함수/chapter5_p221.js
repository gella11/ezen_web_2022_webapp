/**
 * 
 	익명함수 = 람다
 	* JS : 함수도 자료 이다. [ 함수는 변수처럼 사용이 가능하다.]
 	매개변수에 함수 전달이 가능하다.
 	함수호출 ( 변수 )			가능
 	함수호출 ( 배열 )			가능		
 	함수호출 ( 함수 )			가능
 	함수호출 ( function(){} )	가능
 
 */
 
 function callThreeTimes( callback ){
	for (let i = 0; i<3 ; i++){
		callback(i)
	}
}

function print (i){
	console.log(`${i}번째 함수 호출`)
}

//함수를 호출합니다.
callThreeTimes(print)

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
// 2.익명 콜백 함수 정의
 function callThreeTimes2( callback ){
	for (let i = 0; i<3 ; i++){
		callback(i)
	}
}

// 콜백함수 : 익명 함수 사용하기
callThreeTimes2( function(i){
	console.log(`${i}번째 함수 호출`)
})

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
// 3. 배열의 forEach() 함수 메소드 p.223
// 내장함수

let numbers = [273, 52, 103, 32, 57]

numbers.forEach(function (value, index, array){
	console.log(`${index}번째 요소 : ${value}`)
})	

//function for_print( numbers){
//	for( let i = 0 ; i<numbers.length ; i++){
//		console.log(`${i}번째 요소 : ${number[i]}`)
//	}
//}
// 위와 동일

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
// 4. 배열의 map() p.223
numbers = numbers.map( function (value, index, array){
	return value * value
	
})
numbers.forEach( console.log)
console.log(' map 실행 결과 : ' + numbers)

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
// 5. 배열의 filter() p.224
const evenNumbers = numbers.filter(function (value){
	return value % 2 === 0
})
console.log('원래 배열 : ' + numbers)
console.log('짝수 배열 : ' + evenNumbers)








