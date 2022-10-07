



function findid(){
let mname 		     = document.querySelector('#mname').value
let memail	 		 = document.querySelector('#memail').value
let findidconfirmbox = document.querySelector('#findidconfirmbox')	// div 라서 value 안씀
   $.ajax({
	 url : "/jspweb/member/findid",	// 서블릿 주소
	 data : { "mname" : mname , "memail" : memail},
	 success : function(re){
		if( re !== 'null'){
			findidconfirmbox.innerHTML = '회원 아이디 : ' + re
		}else{
			findidconfirmbox.innerHTML = '동일한 정보가 없습니다.'
		}
		}
	 });

}