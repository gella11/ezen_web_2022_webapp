/* chartist.js 이용한 차트 구현 */

let pieData = {
	labels:['웹디자이너' , '웹개발자' , '서버 엔지니어' , '영업직'],
	series:[14, 9, 8, 6]
};
let pieOptions = {
	width:'100%',
	height:'440px'
};
new Chartist.Pie('.pie_chart', pieData , pieOptions);




let barData ={
	labels:['2018년' , '2019년' , '2020년'],
	series:[[10, 16, 29]]
};

let barOptions = {
	axisY :{
		offset : 60,
		scaleMinspace:50,
		labelInterpolationFnc: function(value){
			return value + '명'
		}
	},
	width : '100%',
	height : '400px'
};
new Chartist.Bar('.bar_chart', barData, barOptions);

/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////

let board = []

function 지원자등록(){
	let 입력리스트 = document.querySelectorAll('input')
	console.log(입력리스트)
	let 목록상자 = document.querySelector('select')
	let 긴글상자 = document.querySelector('textarea')
	console.log(목록상자)
	console.log(긴글상자)
	
	let table = {
		성명 : 입력리스트[0].value,
		영문명: 입력리스트[1].value,
		메일주소:입력리스트[2].value,
		포트폴리오:입력리스트[3].value,
		희망근무지: 0,
		현재상태: 목록상자.value,
		자기상태: 긴글상자.value
	}
	console.log(table)
	alert('글 등록 완료되었습니다')
}

 	








