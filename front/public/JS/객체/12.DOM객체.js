/*
 	왼쪽 방향키 37
 	위 38
 	오른쪽 39
 	아래 40
 */
 
 
 
 /* 별의 초기 설정 */
 const star = document.querySelectorAll('h1')
 star.style.position = 'absolute'
 
 /* 별의 이동을 출력하는 기능 */
 let[ x , y ] = [ 0 , 0 ] /* 다중선언  let x = 0 /// let y = 0  */
 const block = 110
 const print = () =>{
	star.style.left = `${x*block}px`
	star.style.top = `${y*block}px`
}

print()

const [ left , up , right , down ] = [ 37 , 38 , 39 , 40 ]

document.body.addEventListener( 'keydown' , (event) => {
	
		// if : 논리제어
		// switch : 값 제어 [ 정해진 경우의 수 스위치가 더 빠름]
	switch(event.keyCode){
		case left :
			x -= 1
			break
		case up :
			y -= 1
			break
		case right :
			x += 1
			break
		case down :
			y += 1
			break

	}
	print() // x와 y변경 후 함수 호출
})






