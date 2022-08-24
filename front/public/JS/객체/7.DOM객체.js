

	// Listener을 쓸 거면 html에 스크립트를 어디에 둬도 되고, 안쓸거면 스크립트를 가장 아래에 둬야 함 , head에 둬도 됨
	// addEventListener함수 (       이벤트      , 콜백함수(인수)=>{결과} )
	// DOMContentLoaded 이벤트 : 문서 모두 실행 후 이벤트
document.addEventListener('DOMContentLoaded' , () => {
	
			// 변수 = h1태그 이름으로 요소(태그) 선택 [태그를 js객체로 가져오기]
			// querySelector HTML에 h1태그가 여러개 여도 하나밖에 가져오지 못함
			// querySelectorALL 은 여러개 가져옴 ★★★★배열로 가져옴★★★
		const header = document.querySelector('h1')
		
		// 어떻게 되었는지 찍어보기
		console.log( header )
		console.log( typoef(header))
		
		// 텍스트 와 스타일 변경
		header.textContent = '안녕~~'
		header.style.color = 'white'			// css 조작 [ DOM객체명.style.속성명 = ]
		header.style.backgroundColor = 'black'	// css 조작 [ DOM객체명.style.속성명 = ]
		header.style.padding = '10px'			// css 조작 [ DOM객체명.style.속성명 = ]
				
})

document.addEventListener('DOMContentLoaded' , () => {
	const headers = document.querySelectorAll('h1')
	console.log( headers )
	console.log( typoef(headers))
	// 1.배열내 데이터를 하나씩 꺼내는 방법 근본이 for문
	for(let i = 0 ; i<headers.length ; i++){
		headers[i].textContent = '안녕' + i
	}
	// 2.
	for( let index in headers ){  //0부터 마지막 인덱스까지 인덱스 하나씩 대입반복
		headers[index].textContent = 'hello'+index
	}
	// 3.
	for( let object of headers){		//0번째 인덱스의 데이터를 마지막 인덱스의 데이터를 하나씩 대입반복  ★★★★ 인덱스가 없음 순서가 없음
		object.textContent = '안녕'
	}
	// 4.
	headers.forEach( ( object )=>{object.textContent='안녕~~'} ) 
})	
	
	
	
	
	
	
	