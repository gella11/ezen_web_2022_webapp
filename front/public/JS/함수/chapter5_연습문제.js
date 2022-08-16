/**
 * 
 */
 
 
 // 연습문제 1 p.218
 function multiplyAll(a,b){
	
	let result = 1
	
	for(let i = a ; i<=b ; i++){
		result *= i
	}
	return result
}


console.log('모두 곱한 결과 : ' +  multiplyAll(1,2))
console.log('모두 곱한 결과 : ' +  multiplyAll(1,3))

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
// 연습문제 2 - 1 [익명함수 선언]
const max = function(array){
	let output = array[0]
	for( let i of array){
		if( output < i ){output = i}
	}return output
}
// for( let i in array){ array[i]}
// for( elt i ; i<array.length ; i++){array[i]}
// 위의 값과 동일한 식

console.log(max([1, 2, 3, 4]))
console.log( ' 최대값 구하기 결과 : ' + max([1,2,3,4]))

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
// 연습문제 2 - 2 
const max2 = function(...array){
	let output = array[0]
	for( let i of array){
		if( output < i ){output = i}
	}return output
}
console.log(max([1, 2, 3, 4]))
console.log( ' 최대값 구하기 결과 : ' + max([1,2,3,4]))



//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
// 연습문제 3 
const max3 = function(array , ...array2 ){
	
	alert('타입확인 : ' + typeof(array))
	alert('타입확인 : ' + typeof(array2))
	alert('타입확인 : ' + typeof(Array.isArray(array2)))
	
	
	let maxvalue = 0
	let items
	if(typeOf(array) == 'object' ){
		items = array
	}else if( typeOf(array2) != 'Number'){
		items = array2
	}
	
	//if( typeof(array) === 'number'){
		//typeof(메모리) : 자료형 확인 함수 1. string 2. Number 3.Boolean 4.★★★object[배열]★★★
	//	maxvalue
	//}
	
	for( let i of items){
		if( maxvalue < i ){maxvalue = i}
	}
	return maxvalue
}


console.log( ' 최댓값 구하기 결과[배열>>매개변수1개] : ' + max3( [1,2,3,4] ) ) 
console.log( ' 최댓값 구하기 결과[배열>>매개변수4개] : ' + max3(1,2,3,4)) 


//인수2개 : 배열, 공백
//인수2개 : 숫자, 배열 1,[2,3,4]



//const max = function (first,...rest){
//	let output
//	let items
//	
//	if(Array.isArray(first)){
//		output = first[0]
//		items = first
//	} else if (typeof(first) === 'number'){
//		output = first
//		items=rests
//	}
//	for (const data of items){
//		if (output < data){
//			output = data
//		}
//	}
//	return output
//}
//
//console.log(`max(배열) : ${max([1,2,3,4])}`)
//console.log(`max(숫자, ...): ${max(1,2,3,4)}`)