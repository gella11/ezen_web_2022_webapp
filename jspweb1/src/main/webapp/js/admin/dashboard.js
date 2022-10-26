
// 1. 해당 사이드바 태그 호출
 let sidebar = document.querySelector('.sidebar')
 let mainbox = document.querySelector('#mainbox')

 
// [ 사이드바 열기 ]클릭시 sidebar css 조절
sidebar.addEventListener('click' , function(){
	sidebar.style.left = 0;
})

// [ 사이드바 닫기 ]본문을 클릭했을 때 사이드바 가려짐
mainbox.addEventListener('click' , function(){
	sidebar.style.left = '-170px';
})

//////////// 본문 페이지 전환 이벤트 ///////////
function pagechage( page ){
	$("#mainbox").load( page ) // 특정 태그에 해당 파일 로드 [ jquery ]
}