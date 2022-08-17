






 let evf = Math.floor( (Math.random()*15)+1 ) 	//엘레베이터 현재 위치 @@난수
 let me = 5								//나의 층 @@ 상수

 
	let count = ''
	let output=''
	 while(me < evf){
		evf--
		let 타이머 = setInterval( ()=> {
			console.log(`1초 후에 실행됩니다.${count}`)
			count++
			if( count == 5){
				console.log('타이머가 종료됩니다.')
				clearInterval(타이머)
		}
} , 1*1000)
		if( me == evf){
			output = evf
			break
		}
	}console.log(evf)