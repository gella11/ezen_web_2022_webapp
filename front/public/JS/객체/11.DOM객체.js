/*

	1.DOM : 문서 객체 모델 [ 미리 만들어진 객체/메소드 ]
		
		1. HTML에 요소를 객체로 호출
			1. querySelector('식별자명')
			2. querySelectorAll('식별자명')
		
		1. 문서객체.addEventListener( '이벤트명' , 콜백함수(그냥 함수도 가능) )
			- 이벤트 종류
				1. 'click' 	: 해당 객체를 클릭했을 때
				2. 'keyup' 	: 해당 객체에서 키가 떨어질 때 함수 실행
		

 */
 
 // p.332
 // 1. HTML태그를 문서 객체화
 const 긴글상자 = document.querySelector('textarea')
 const 헤더텍스트 = document.querySelector('h1')
 
 긴글상자.addEventListener('keyup' , () => {
	const 길이 = 긴글상자.value.length
	헤더텍스트.textContent = `글자수 : ${길이}`
})
 
 // 다른 방법
 // 긴글상자.onkeyup = () => {}
 
 function 글자수(){
	const 길이 = 긴글상자.value.length
	헤더텍스트.textContent = `글자수 : ${길이}`
}


 // p.333
 const h2 = document.querySelector('h2')
 const print = (event) => {
	let output = ''
	output += `alt : ${event.altKey}<br>`
	output += `ctrl : ${event.ctrlKey}<br>`
	output += `shift : ${event.shiftKey}<br>`
	output += `code : ${typeof(event.code) != 'undefined' ? event.code : 
		event.keyCode}<br>`
	
	h2.innerHTML = output
}
	document.addEventListener('keyup' , print)

	
	
	
	