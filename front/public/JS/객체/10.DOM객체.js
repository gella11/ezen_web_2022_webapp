/**
 * 
 */
 
 
 let counter = 0
 let isConnect = false //연결 상태 저장하는 변수
 
 // 요소 객체들
 const h1 = document.querySelector('h1')
 const p = document.querySelector('p')
 const connectBtn = document.querySelector('#connect')
 const disconnectBtn = document.querySelector('#disconnect')
 const upBtn = document.querySelector('#up')
 const downBtn = document.querySelector('#down')
 
 // 출력하는 함수
 const listener = () => { h1.textContent = `클릭횟수 : ${++counter}` }
 
 // 1. 연결 버튼을 클릭했을 때
 connectBtn.addEventListener( 'click' , () => { 
	if(isConnect == false){
		h1.addEventListener('click' , listener)
		p.textContent = '이벤트 연결 상태 : 연결'
		isConnect = true 
	}
	
})
 
 // 2. 해제 버튼을 클릭했을 때
 disconnectBtn.addEventListener( 'click' , () => { 
	if(isConnect == true){
		h1.removeEventListener('click' , listener)
		p.textContent = '이벤트 연결 상태 : 해제'
		isConnect = false
	}
	
})
 
 upBtn.addEventListener( 'click' , ()=>{
	if(isConnect == true){
		counter++
		h1.textContent = `클릭횟수 : ${counter}`
	}
})
 downBtn.addEventListener( 'click' , ()=>{
	if(isConnect == true){
		counter--
		h1.textContent = `클릭횟수 : ${counter}`
	}
})
 
 
 h1.addEventListener('click' , () => {
	counter++
	h1.textContent = `클릭횟수 : ${counter}`
})
 
 
 
 /*
 //객체명.addEventListener( '이벤트명' , 콜백함수 )
 	// 해당 객체의 클릭이벤트가 발생하면 콜백함수 실행된다. (event) 인수인데 안에 넣나 안넣나 상관 없음
 h1.addEventListener('click' , (event) => {
	
	counter++
	h1.textContent = `클릭횟수 : ${counter}`
	
})
 
// 위와 동일
// h1.addEventListener('click', 함수 )
// function 함수() {
//  	counter++
//  	h1.textContent = `클릭횟수 : ${counter}`
// }
 
 
 // html 에서 클릭이벤트 이용. 온클릭
 // 셀렉터 h2를 안써서 안되지만 기능은 됨
 function 함수(){
	counter++
	h1.textContent = `클릭횟수 : ${counter}`
}
 */

 
 
 
 
 
 
 
 
 