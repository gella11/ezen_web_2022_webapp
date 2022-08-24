



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
	"1월",
	"2월",
	"3월",
	"4월",
	"5월",
	"6월",
	"7월",
	"8월",
	"9월",
	"10월",
	"11월",
	"12월",
]

document.querySelector('.head h3').innerHTML = months[date.getMonth()]



let days =""

for(let x = firstdayIndex ; x > 0 ; x--){
	days += `<div class="prevDay">${prevlastDay}</div>`
	monthDays.innerHTML = days
}

for(let i = 1 ; i<=lastDay ; i++){
	days += `<div>${i}</div>`
	monthDays.innerHTML = days
}

for(let j = 1 ; j<=7-lastDayIndex-1 ; j++){
	days += `<div class="nextDay">${j}</div>`
	monthDays.innerHTML = days
}