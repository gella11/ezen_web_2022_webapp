/**
 * 
 */
 
 // p.320
 // js 태그 생성
 const header = document.createElement('h1')
 // 2. 텍스트 조작
 header.textContent = 'js에서 만든 태그'
 header.style.color = 'purple'
 header.style.backgroundColor = 'skyblue'
 // 3.
 document.body.appendChild(header)
 
 
 
 // p.321 이동하는 태그
 
 const divA = document.querySelector('#first')
 const divB = document.querySelector('#second')
 
 const h1 = document.createElement('h1')
 h1.textContent = '이동하는 h1 태그'
 
 const toFirst = () => {
	divA.appendChild(h1)
	setTimeout( toSecond , 500 )
}
 const toSecond = () => {
	divB.appendChild(h1)
	setTimeout( toFirst , 500 )
}
 toFirst()

 


// 타이머 함수 ( 함수() , 밀리초(1000/1초)  )
// setTimeout( toSecond , 3000 )

// 타이머 함수 응용
// setTimeout( () => {} , 3000 )
 
 
  // p.322 객체 제거
 const h2 = document.querySelector('h2')

	// 1회용 함수 
	setTimeout( ()=> {
	 h2.parentNode.removeChild(h2)
	} , 3000 )

	// 변수에 저장햇으니 계속 가능
	const 땡땡땡 =  ()=> {h2.parentNode.removeChild(h2)}
	setTimeout( 익명함수 , 3000 )
	
	
	// 변수에 저장햇으니 계속 가능
	function 함수() {
		h2.parentNode.removeChild(h2)
		} setTimeout( h2 , 500 )
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
  
  
  
  
  
  