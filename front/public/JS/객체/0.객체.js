/*
 
		객체		:	메모리(변수/배열 등등)와 함수들의 모임
 		배열과
 */
 
 //	p.246
 //	1. 객체 생성
 //	const or let 객채명 = { 키 : 값 }
 const product = {
	제품명 : '7D 건조 망고' , //쉼표로 구분
	유형 : '당절임' ,
	성분 : '망고 , 설탕 , 메타중아황산나트륨 , 치자황색소',
	원산지 : '필리핀'
 }
 
 //	2. 객체 확인
 		//	1. [객체호출] : 객채명
 		//	2. [객체내 값 호출] : 객체명[키]
 console.log('객체 호출 : ' + product)
 console.log('객체내 속성 호출 : ' + product['제품명'])
 console.log('객체내 속성 호출 : ' + product['유형'])
 console.log('객체내 속성 호출 : ' + product.성분)	//.으로 이용 가능
 
 
 //	p.248
 const object = {
	number: 273 ,
	string: '구름' ,
	boolean: true ,
	array: [52, 273, 103, 32],
	method: function(){console.log('함수실행')}
}

//	2. 객체 내 속성과 메소드=함수 호출
console.log('객체내 메소드 호출 ' + object.method() )

