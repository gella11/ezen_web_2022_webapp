


const date = new Date()


/*Thu Aug 25 2022 03:32:16 GMT+0900 (한국 표준시)*/


const monthmove = () => {

/* ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/

const monthDays = document.querySelector('.days')
const lastDay = new Date(date.getFullYear(), date.getMonth()+1,0).getDate()
/*Sun Aug 31 2022 00:00:00 	GMT+0900 (한국 표준시)*/
/*끝에 .getDate() 를 붙일 경우 31만 추출*/
const firstdayIndex =new Date(date.getFullYear(), date.getMonth(),1).getDay()
console.log(firstdayIndex)
const lastDayIndex = new Date(date.getFullYear(), date.getMonth()+1,0).getDay()
console.log(lastDayIndex)
/* ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/


const prevlastDay =new Date(date.getFullYear(), date.getMonth(),0).getDate()
console.log(prevlastDay)



/* ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
const months = [
	"1_ January ",
	"2_ February",
	"3_ March",
	"4_ April",
	"5_ May",
	"6_ June",
	"7_ July",
	"8_ August",
	"9_ September",
	"10_ October",
	"11_ November",
	"12_ December",
]

document.querySelector('.head h3').innerHTML = months[date.getMonth()]
document.querySelector('.head h2').innerHTML = date.getFullYear()


/* ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
let days =""
/* P R E */
for(let x = firstdayIndex ; x > 0 ; x--){
	const aaa = new Date(date.getFullYear() , date.getMonth()-1,prevlastDay-x+1).getDay()
	if(  (date.getMonth() > new Date().getMonth() || date.getFullYear() > new Date().getFullYear() ) && aaa !==1){
	days += `<div id="prevDay">${prevlastDay-x+1}
	<ul>
		<li><button class="lunch">Lunch</button></li>
		<li><button class="dinner">Dinner</button></li>
	</ul>
		</div>`
	}else{
	days += `<div id="prevDay">${prevlastDay-x+1}</div>`
	monthDays.innerHTML = days
	}
}
/* T H I S */
for(let i = 1 ; i<=lastDay ; i++){
	const bbb = new Date(date.getFullYear() , date.getMonth(),i).getDay()
	const bbbb = new Date(date.getFullYear() , date.getMonth(),i)
	if( (i == date.getDate() && date.getMonth() == new Date().getMonth()) && bbb !== 1){
		days += `<div class="today">${i}
		<ul>
			<li><button class="lunch">Lunch</button></li>
			<li><button class="dinner">Dinner</button></li>
		</ul>
		</div>`
	}else if(( i > date.getDate() && date.getMonth() >= new Date().getMonth() || date.getMonth() > new Date().getMonth() || date.getFullYear() > new Date().getFullYear()) && bbb !==1  ){
		days += `<div>${i}
		<ul>
			<li><button class="lunch">Lunch</button></li>
			<li><button class="dinner">Dinner</button></li>
		</ul>
		</div>`
	}else{
		days += `<div>${i}</div>`
		monthDays.innerHTML = days
		}
	}



/* N E X T */
for(let j = 1 ; j<=7-lastDayIndex-1 ; j++){
	const ccc = new Date(date.getFullYear() , date.getMonth()+1,j).getDay()
	if(  (date.getMonth()+1 > new Date().getMonth() || date.getFullYear() > new Date().getFullYear() ) && ccc !==1){
	days += `<div id="nextDay">${j}
	<ul>
		<li><button class="lunch">Lunch</button></li>
		<li><button class="dinner">Dinner</button></li>
	</ul>
		</div>`
	}else{days += `<div id="nextDay">${j}</div>`}
	monthDays.innerHTML = days
}


}


document.querySelector('.left_btn').addEventListener('click' , () => {
	date.setMonth(date.getMonth() -1)
	monthmove()
})
document.querySelector('.right_btn').addEventListener('click' , () => {
	date.setMonth(date.getMonth() +1)
	monthmove()
})

monthmove()




