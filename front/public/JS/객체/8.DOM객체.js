/**
 * 
 */
 
 

 
 document.addEventListener('DOMContentLoaded' , () => {
	
	 const a = document.querySelector('#a')
	 const b = document.querySelector('#b')
	 
	 // p.314 텍스트 조작
	 a.textContent = '<h1>textContent 속성</h1>'
	 b.innerHTML = '<h1>textContent 속성</h1>'
	 
	 
	 // p.315 속성 조작
	 const rects = document.querySelectorAll('.rect')
	 
	 for(let i = 0 ; i<rects.length ; i++){
		const width = ( i + 1 ) *100
		const src = `http://placekitten.com/${width}/250`
		rects[i].setAttribute('src' , src)
		//rects.src = src 위와 동일 ★★★★★★ attrubute 생략 가능★★★★★★ 
	}
	
	// p.318 스타일 조작
	const divs = document.querySelectorAll('#divbox div')
	
	divs.forEach( (div,index) => {
		
		// [ 콜백함수 ]
		// 배열명.forEach( ( 요소명 , 인덱스 , 배열명 )) => { } )
			// 배열에 있는 요소들을 하나씩 반복변수에 저장 대입
			// 배열에 인덱스들을 하나씩 인덱스변수에 저장 대입
			// 함수 내에서 사용할 배열명 대입
		// 배열명.forEach( ( 요소명 ) ) => { } )
		
		// 배열명.forEach( ( 요소명 , 인덱스) ) => { } )
		
		
		console.log( div , index)
		const val = index * 10
		div.style.height = `10px`
		div.style.backgroundColor=`rgba( ${val} , ${val} , ${val} )`
	})
	
})
 
 
