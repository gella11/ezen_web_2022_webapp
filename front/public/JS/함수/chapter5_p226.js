/*

	p.226
	*타이머 함수 : 내장함수[콜백함수를 이용]
	setTimeout( 함수 , 시간[밀리초] ) : 시간이후에 한 번 함수 실행
		clearTimeout(함수변수) : 타이머 종료
	setInterval( 함수 , 시간[밀리초] ) : 매 시간마다 함수 실행
		clearInterval(함수변수) : 타이머 종료
 */
 // 1 			: 1밀리초
 // 1*1000 		: 1초
 // 1*1000*60 	: 1분
 // 1*1000*60*60: 1시간
 //setTimeout( ()=> {console.log('1초 후에 실행됩니다.')} , 1*1000)
 
// setInterval( ()=> {console.log('1초 후에 실행됩니다.')} , 1*1000)
 
 let count = 0
 let 타이머 = setInterval( ()=> {
	console.log(`1초 후에 실행됩니다.${count}`)
	count++
	if( count == 5){
		console.log('타이머가 종료됩니다.')
		clearInterval(타이머)
	}
} , 1*1000)



