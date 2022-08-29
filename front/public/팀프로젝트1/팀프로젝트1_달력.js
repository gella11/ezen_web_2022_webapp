


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
	"1_January ",
	"2_February",
	"3_March",
	"4_April",
	"5_May",
	"6_June",
	"7_July",
	"8_August",
	"9_September",
	"10_October",
	"11_November",
	"12_December",
]

document.querySelector('.head h3').innerHTML = months[date.getMonth()]
document.querySelector('.head h2').innerHTML = date.getFullYear()


/* ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
let days =""
/* P R E */
for(let x = firstdayIndex ; x > 0 ; x--){
	if(date.getMonth() > new Date().getMonth() || date.getFullYear() > new Date().getFullYear()){
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
	if( i == date.getDate() && date.getMonth() == new Date().getMonth() ){
		days += `<div class="today">${i}
		<ul>
			<li><button class="lunch">Lunch</button></li>
			<li><button class="dinner">Dinner</button></li>
		</ul>
		</div>`
	}else if( i > date.getDate() && date.getMonth() >= new Date().getMonth() || date.getMonth() > new Date().getMonth() || date.getFullYear() > new Date().getFullYear()  ){
		days += `<div>${i}
		<ul>
			<li><button class="lunch${date.getDay()}">Lunch</button></li>
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
		
	days += `<div id="nextDay">${j}
	<ul>
		<li><button class="lunch}">Lunch</button></li>
		<li><button class="dinner">Dinner</button></li>
	</ul>
		</div>`
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
