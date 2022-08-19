/*
 */
 
 
 // p.257
 // 배열도 객체이다.
 const a = []			// 1. 배열선언
 console.log(a)
 a.sample = 10 			// 2. 속성추가
 console.log(a.sample)
 //	>>> 됨
 
  // 함수도 객체이다.
  function b(){}
  b.sample= 10			// 1. 함수언
  console.log(b.sample)	// 2. 함수에 속성 추가
  //	>>> 됨
  
   // p.258
   // 기본 자료형
   const c = 273
   c.sample = 10			// 1.상수선언
   console.log(c.sample)	// 1.상수에 속성 추가 
   //	>>> 안됨
 
 	const d = '안녕하세요'
 	c.sample = 10			// 1.상수(문자열)에 선언
 	console.log(d.sample) 	// 2.상수에 속성 추가
 	// >>> 안됨
 
 
 //	p.277
 // Math.random() : 0 <= 1 사이 결과 0포함
 // Math.random()*10 : 0 <= 10 사이 결과 0포함
 // 결과물 : 실수(소수점) -- 소수점 없애기 ---> 정수 만들기 : Math.floor(실수)
 const num = Math.random()
 
 console.log(' 0~1 사이 난수 ' + num)
 console.log(' 0~10 사이 난수 ' + num*10)
 console.log(' 0~50 사이 난수 ' + num*50)
 
 console.log(' -5 ~ 5 사이 난수 ' + num*10-5)
 console.log(' -25 ~ 25 사이 난수 ' + num*50-25)
 
 
 
 
 
 
 
 