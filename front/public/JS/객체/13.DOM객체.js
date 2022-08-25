/*

	객체명.textContent
	객체명.innerHTML
	객체명.value	: 입력상자 

 */
 
 // 1. HTML 요소 가져오기
 const input = document.querySelector('#inchbox')
 const button = document.querySelector('#inchbtn')
 const p = document.querySelector('#inchp')

 button.addEventListener( 'click' , () =>{
	const inch = Number(input.value)
	//isNaN(데이터) : 숫자가 아니면 true / 숫자이면 false
	if(isNaN(inch)){						
		p.textContent = '숫자를 입력해주세요'
		return
	}
	// 숫자이면
	const cm = inch * 2.54
	p.textContent = `${cm}cm`
})


/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */

const emailbox = document.querySelector('#emailbox')
const emailp = document.querySelector('#emailp')

const isemail = (value) => {
	return(value.indexof('@') > 1 ) && (value.split('@')[1].indexOf(".") > 1)
	// 입력데이터의 @ 가 있는지   이면서  입력데이터의 @ 뒤문자        .이 있는지
}



emailbox.addEventListener('keyup' , (event) =>{
	const value = event.currentTarget.value
	if(isemail(value)){
		p.style.color = 'green'
		p.textContent = `이메일 형식입니다 : ${value}`
	}else{
		p.style.color = 'red'
		p.textContent = `이메일 형식이 아닙니다. : ${value}`
	}
})




/*
	배열명.indexOf('검색데이터') : 배열내 해당 데이터읭 인덱스 번호 찾기
	문자열.indexOf('@') : 문자열내 @ 의 인덱스 번호 찾기
		인덱스가 0보다 작으면 못찾았다.
		[인덱스란 저장 순서 번호 0번부터]
	
	문자열.split('기준문자') : 문자열 내 기준문자 기준으로 분리 [자르기] >>> 분리후 배열으로 저장됨
	ex) 문자열 = 유재석,강호동,신동엽,하하 : [ 유재석 / 강호동 / 신동엽 / 하하]
		문자열.split(',')[0] : 유재석
		문자열.split(',')[1] : 강호동
		문자열.split(',')[2] : 신동엽
		문자열.split(',')[3] : 하하
*/

/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */


const selectbox = document.querySelector('#selectbox')
const selectp = document.querySelector('#selectp')

// ↓ currentTarget
selectbox.addEventListener('change' , (event) =>{
	
	const options = event.currentTarget.options
	const index = event.currentTarget.options.selectdIndex
	selectp.textContent = `선택 : ${option[index0,textContent]}`
})

/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */

const selectbox2 = document.querySelector('#selectbox2')
const selectp2 = document.querySelector('#selectp2')

selectbox2.addEventListener('change' , (event) =>{
	
	const options = event.currentTarget.options
	const list = []
		//배열[옵션목록]중 하나씩 option 대입 반복
	for(const option of options){
		if(option.selected){
			list.push(option.textContent)
		}
	}
	selectp2.textContent = `선택 : ${list.join(',')}`
})


/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */

let 현재값
let 변환상수 = 10

const cminput = document.querySelector('#cminput')
const cmspan = document.querySelector('#cmspan')
const cmselect = document.querySelector('#cmselect')

// 3.
cmselect.addEventListener('change' , (event) =>{
	const options = event.currentTarget.options
	const index = event.currentTarget.options.selectedIndex
	변환상수 = Number(options[index].value)
	calculate()
})

// 2.
const calculate = () => {
	cmspan.textContent = (현재값*변환상수).toFixed(2)
}

// 1.
cminput.addEventListener('keyup' , (event)=> {
	현재값 = Number( event.currentTarget.value)
	calculate()
})

/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */

let timer = 0		// 타이머 시간(초) 저장하는 변수/객체
let timerId = 0		// 타이머 함수를 저장하는 변수/객체 [ setInterval 함수]
const timerinput = document.querySelector('#timerinput')
const timerh1 = document.querySelector('#timerh1')

timerinput.addEventListener('change' , (event) => {
	if(event.currentTarget.checked){
		timerId = setInterval( ()=>{
			timer += 1
			timerh1.textContent = `${timer}초`
		}, 1000)
	}else{
		clearInterval( timerId )		//timer가 1씩 증가된 변수로 지정되어서 누적으로 됨.
	}
})

/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
/*
	<input type="radio" name="pet" value="강아지" >
	<span> 강아지 </span>
	<input type="radio" name="pet" value="고양이" >
	<span> 고양이 </span>
	<input type="radio" name="pet" value="햄스터" >
	<span> 햄스터 </span>
	<input type="radio" name="pet" value="기타" >
	<span> 기타 </span>
	★★★★★★★★★★★★★★★★★★★★★★★★★★★★
	name 값을 다르게 한다면 복수 선택이 되고, 취소도 안됨
	name 값을 같게 하여 하나만 고를 수 있게 함
	★★★★★★★★★★★★★★★★★★★★★★★★★★★★
	
	tag 	>>> 'tag'			[복수]
	class 	>>> '.calss명'		[복수]
	id 		>>> '#id명'			[단일]
	name 	>>> '[name-name명]'	[복수]
	
*/

const radios = document.querySelectorAll('[name=pet]')
const output = document.querySelector('#output')

radios.forEach( (radio) => {
	radio.addEventListener('change' , (event) =>{
		const current = event.currentTarget
		if( current.checked){
			output.textContent = `좋아하는 애완동물은 ${current.value}이시군요!`
		}
	})
})




































