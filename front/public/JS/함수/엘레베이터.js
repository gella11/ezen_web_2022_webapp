/**

 엘레베이터 현재위치
 
 내 현재 위치
 
 상승 버튼 / 하강 버튼
 - 
 1.현재위치 상수 / 엘레베이터 현재위치 난수발생
// 2. 엘레베이터 현재위치 확인

  2-1 내 현재위치보다 위에 있으면 하강버튼
  	- 엘레베이터 현재위치 한칸씩 내려오게
  2-2 내 현재위치보다 아래 있으면 상승버튼
	- 엘레베이터 현재위치 한칸씩 올라오게
	
 3. 엘레베이터와 내 현재위치가 같으면 알림
 
 */
// 1.현재위치 상수 / 엘레베이터 현재위치 난수발생
const myfloor=5
let evfloor= Math.floor((Math.random()*15)+1)

document.getElementById('ev').innerHTML= evfloor
document.getElementById('here').innerHTML= myfloor

//2. 엘레베이터 현재위치 확인-> 같은 층이면 탑승알림
if(myfloor == evfloor) {
	alert('탑승하세요')
} else if(myfloor>evfloor){
	alert('상승버튼을 누르세요')
} else {alert('하강버튼을 누르세요')}


// 버튼클릭함수
function upbtn(){
	setInterval( ()=> {
		if(evfloor < myfloor){
		evfloor -= -1 
		document.getElementById('ev').innerHTML= evfloor
			if(evfloor == myfloor){
				setTimeout( ()=> {
				alert('엘레베이터가 도착했습니다.')	
				},0.7*1000)		
			}
		} 
	}, 0.7*1000)
}




function downbtn(){
	setInterval( ()=> {
		if(evfloor > myfloor){
		evfloor += -1 
		document.getElementById('ev').innerHTML= evfloor
		//alert(evfloor)
			if(evfloor == myfloor){
				setTimeout( ()=> {
				alert('엘레베이터가 도착했습니다.')
				},0.7*1000)
			}
		} 
	}, 0.7*1000)
}




