


function findpassword(){
let mid 		= document.querySelector('#mid').value
let memail	 	= document.querySelector('#memail').value
let findpasswordconfirmbox = document.querySelector('#findpasswordconfirmbox')	// div 라서 value 안씀
   $.ajax({
	 url : "/jspweb/member/findpassword",	// 서블릿 주소
	 data : { "mid" : mid , "memail" : memail},
	 success : function(re){
		if(re === ''){
			findpasswordconfirmbox.innerHTML =' 동일한 회원 정보가 없습니다.'
		}
		else{
			findpasswordconfirmbox.innerHTML = '임시 비밀번호 :' + re
		}
		}
	 });
}