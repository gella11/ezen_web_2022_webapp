



const date = new Date()
console.log(date)
/*Thu Aug 25 2022 03:32:16 GMT+0900 (한국 표준시)*/



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
	"1 January ",
	"2 February",
	"3 March",
	"4 April",
	"5 May",
	"6 June",
	"7 July",
	"8 August",
	"9 September",
	"10 October",
	"11 November",
	"12 December",
]

document.querySelector('.head h3').innerHTML = months[date.getMonth()]



let days =""

for(let x = firstdayIndex ; x > 0 ; x--){
	days += `<div id="prevDay">${prevlastDay-x+1}</div>`
	monthDays.innerHTML = days
}

for(let i = 1 ; i<=lastDay ; i++){
	if( i == date.getDate() && date.getMonth() == new Date().getMonth() ){
		days += `<div class="today">${i}</div>`
	}else{
		days += `<div>${i}</div>`
		monthDays.innerHTML = days
		}
	}

for(let j = 1 ; j<=7-lastDayIndex-1 ; j++){
	days += `<div id="nextDay">${j}</div>`
	monthDays.innerHTML = days
}