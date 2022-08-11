// p.204
function sumAll( a,b ){
		//sumAll 이름으로 함수명 선언, 매개변수 a, b
		//외부에서 함수 호출시 들어오는 값[데이터]
	let output = 0
	for(let i = a ; i<=b ; i++){
		output += i
	}
	return output
}

console.log(`1부터 100까지의 합 : ${sumAll(1,100)}`)
console.log(`1부터 500까지의 합 : ${sumAll(1,500)}`)


//계산하기 버튼을 눌렀을 때 함수
function 계산버튼함수(){
	alert('버튼눌림')
	let snumber = document.getElementById('sinput').value
	let enumber = document.getElementById('einput').value
	let result = sumAll( snumber , enumber)
	document.getElementById('resultbox').innerHTML = '계산결과 :' + result
	}