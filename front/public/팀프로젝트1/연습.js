




/**/
const date = new Date()
const months = date.getMonth()

console.log(date)
/* Thu Aug 25 2022 00:46:18 GMT+0900 (한국 표준시) */
console.log(months)
/* 7 */

/*
const lastDay = new Date(date.getFullYear(), date.getMonth(),3)
console.log(lastDay)
Wed Aug 03 2022 00:00:00 GMT+0900 (한국 표준시)
*/

const lastDay = new Date(date.getFullYear(), date.getMonth()+1,0).getDate()
console.log(lastDay)
/*Sun Aug 31 2022 00:00:00 	GMT+0900 (한국 표준시)*/
/*끝에 .getDate() 를 붙일 경우 31만 추출*/

const firstDayIndex = date.getDay()
console.log(firstDayIndex)



/**
 * 
 */
 console.log(nowYear)
    // 달력 생성
  const makeCalendar = (date) => {
    
    // 현재의 년도와 월 받아오기
    const nowYear = new Date(date).getFullYear();
    const nowMonth = new Date(date).getMonth() + 1;

    // 지난달의 마지막 요일
    const prevDay = new Date(nowYear, nowMonth - 1, 1).getDay();

    // 현재 월의 마지막 날 구하기
    const lastDay = new Date(nowYear, nowMonth, 0).getDate();
    
    // 남은 박스만큼 다음달 날짜 표시
    let nextDay = (prevDay + lastDay) % 7;
    
    if (nextDay == 0) nextDay = 7;

    let htmlDummy = '';

    // 전달 날짜 표시하기
    for (let i = 0; i < prevDay; i++) {
      htmlDummy += `<div class="noColor"></div>`;
    }

    // 현재 날짜 표시하기
    for (let i = 1; i <= lastDay; i++) {    
      htmlDummy += `<div>${i}</div>`;
    }

    // 다음달 날짜 표시하기
    for (let i = nextDay; i < 7; i++) {
      htmlDummy += `<div class="noColor"></div>`;
    }

    document.querySelector(`.dateBoard`).innerHTML = htmlDummy;
    document.querySelector(`.dateTitle`).innerText = `${nowYear}년 ${nowMonth}월`;
  }
  
window.onload = () => {
  const date = new Date();
 
  makeCalendar(date);
  
  // 이전달 이동
  document.querySelector(`.prevDay`).onclick = () => {
    makeCalendar(new Date(date.setMonth(date.getMonth() - 1)));
  }
  
  // 다음달 이동
  document.querySelector(`.nextDay`).onclick = () => {
    makeCalendar(new Date(date.setMonth(date.getMonth() + 1)));
  }
};