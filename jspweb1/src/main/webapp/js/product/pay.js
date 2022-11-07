// js 저장소에 있는 'checkplist' 라는 이름으로 객체 호출 
let checkplist = JSON.parse( localStorage.getItem('checkplist') ) ;


let checkbtn = document.querySelector('.checkbtn')

checkbtn.addEventListener('click' , (e)=>{
	// 1. 체크박스 체크 했을때
	if( e.currentTarget.checked == true ){
		document.querySelector('.oname').value = member.mname;
		document.querySelector('.ophone').value = member.mphone;
		document.querySelector('.oddress').value = member.maddress;
	}else{
		document.querySelector('.oname').value = '';
		document.querySelector('.ophone').value = '';
		document.querySelector('.oddress').value = '';	
	}
})

// * 로그인된 회원호출
let member = null;

getmember();
function getmember(){
	$.ajax({
		url :  "/jspweb/member/info" , 
		success: re =>{ member =  JSON.parse( re ) }
	})
}

let pmethod = null
function paymethod( payM ) { pmethod = payM; alert( pmethod ) }

/* 아임포트 [ 결제 API ] */
function requestPay(payM ) {
	var IMP = window.IMP; 
	IMP.init("imp14103839"); // [본인]관리자 식별코드 [ 관리자 계정마다 다름 ] 
  	IMP.request_pay({ 
      pg: "kcp",	// pg 카드 
      pay_method: "card" ,
      merchant_uid:  "",   //주문번호 [ 1.자동번호 2.직접( 날짜+시간+mid+난수 ) ]
      name:  checkplist[0].pname +"외 "+checkplist.length ,	// 제품명 [ 장바구니에 ]
      amount:  "" ,                        	 // 숫자타입
      buyer_email: "" ,
      buyer_name: "" ,
      buyer_tel: "" ,
      buyer_addr: "" ,
      buyer_postcode: ""
  }, function (rsp) { // callback
      if (rsp.success) {// 결제 성공 시 로직
    		
      } else { // 결제 실패 시 로직 [ 테스트 -> 실패(성공)]
         alert('결제성공 했다 치고');
         setorder();
      }
  });
}

function setorder(){
	
	let orderinfo = { // 받는사람 정보의 객체
		oname : document.querySelector('.oname').value , 
		ophone : document.querySelector('.ophone').value , 
		oddress : document.querySelector('.oddress').value , 
		oquest : document.querySelector('.oquest').value
	}
	
	$.ajax({
		url : "/jspweb/product/order",
		data : { 
			"data" : JSON.stringify(checkplist) , 
			"orderinfo" : JSON.stringify(orderinfo) } ,
		type : "post" , 
		success : (re) => {
			if( re == 'true' ){ 
				alert('주문완료'); 
				localStorage.removeItem('checkplist'); // 저장소 제거
				location.href='/jspweb/product/ordersuccess.jsp';
			}else{
				alert('주문완료[관리자에게 문의]');
			}
		}
	})
}

/*
	 JS 
  1. 실행주체 : 사용자
  2. 실행위치 : HTML 내부 
	-- HTTP : 문서교환 통신
  3. HTML 새로 열리거나 / 새로고침 
	--> JS도 같이 로드[ 새로고침] 메모리 초기화 
  4. HTML [ HTML 변경될때 메모리 유지 ]
	-- JS 새로고침 해도 메모리 유지 
	-- Object객체[ 문자열 저장 ]
	-- 저장
		sessionstorage.setitem( 'key' , value  ) 
		localstorage .setitem( 'key' , value )
	-- 호출 
		sessionstorage.getitem( 'key' )
		localstorage .getitem( 'key' )	
	-- 생명주기
		-- 1. 모든 메모리 삭제 
			sessionstorage.clear()
			localstorage.clear()
		-- 2. 특정 메모리 삭제 
			sessionstorage.removeitem( 'key')
			localstorage .removeitem( 'key'  )
		
	세션 : JS [ sessionstorage ] 
		- 모든 브라우저 닫을때 삭제
		- 열려 있는 브라우저 끼리 데이터 공유 [ x ] 
	쿠키 : JS [ localstorage ]
		- 모든 브라우저 닫고 다시 열었을때 유지 [ 클라이언트 pc ]
		- 열려 있는 브라우저 끼리 데이터 공유 [ O ] 
		
		
		
		vs
		
		
JAVA 세션 
-- 서버가 실행중인될때 메모리 유지 
-- Object객체
-- 저장 
request.getSession().setAttribute( 'KEY' , value ); 
-- 호출
request.getSession().getAttribute( 'KEY'  ); 
-- 생명주기 
session.invalidate();
request.getSession().setAttribute( 'KEY' , null ); 
*/