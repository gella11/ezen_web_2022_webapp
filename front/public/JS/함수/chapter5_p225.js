/**
 
 // p.226
 // function , return 입력
 // (인수) => 결과
 
 */
 
 let numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 
 // 메소드 체이닝 (결과 연결) 사용 안할 때
 // 배열명.메소드1().메소드2() : 메소드1 결과를 가지고 메소드2 사용
 let array1 = numbers.filter( (value) => value % 2 == 0)
 //console.log('짝수 배열 : ' + array1)
 let array2 = numbers.filter( (value) => value * value )
 //console.log('짝수 제곱 : ' + array2)
 array2.forEach ( (value) => console.log(value) )
 
/*
numbers.filter( function(value(){
	return value % 2 == 0
})
아래와 같음
*/
numbers.filter ( ( value) => value%2 ==0 )
 	.map( (value) => value*value )
 	.forEach( (value) => console.log(value))
