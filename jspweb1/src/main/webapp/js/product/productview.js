/*

	JS 반복문
		1. for(let i = 0; 배열명.length; i++){}
			i : 반복변수[인덱스용]
		2. 배열명.forEach( 함수(i) )
		   배열명.forEach( (value , index, array) => {} )
		   		value : 배열내 데이터 반복변수
		   		index : 인덱스
		   		array : qoduf
		3. for( value of 배열명 ){}  배열에서 순서대로 데이터 반복변수에 대입 
		4. for( index in 배열명 ){}  배열에서 순서대로 인덱스 반복변수에 대입
		
		
		배열에 객체 추가
		배열.push(객체)
		배열내 인덱스 삭제
		배열.splice(start,end)
		
*/


/////////////////////////////////////// 공 통 변 수 ///////////////////////////////////////
let pno = document.querySelector('.pno').value
let stock = null		//재고목록
let product = null  	//제품
let color = null;		// 선택된 색상
let productlist = []	
let psale = 0; // 할인율이 적용된 판매가
/////////////////////////////////////// 이 벤 트 /////////////////////////////////////// 
// 색상 select 박스를 체인지 했을 때 이벤트
document.querySelector('.cselect').addEventListener('change' , (e)=>{
	color = e.currentTarget.value  //카테고리목록에서 선택를 클릭했을떄 제품출력 메소드 호출
	alert(color+' 사이즈 선택했음.')
	
	// 8. 색상 select에서 선택된 생상의 사이즈 select 구성
	let shtml = '<option>-[필수] 사이즈 선택</option>'
	stock.forEach(s=>{
		if(s.pcolor == color){
			shtml += '<option value='+s.psize+'>'+s.psize+'</option>'
		}
	})
	document.querySelector('.sselect').innerHTML = shtml
})
	


// 사이즈 select 박스를 체인지 했을 때 이벤트
document.querySelector('.sselect').addEventListener('change' , (e)=>{
	let size = e.currentTarget.value
	
	if(size == '-[필수] 사이즈 선택'){return}
	
	// 단 이미 존재한 옵션은 재고만 1 증가한다.
	for( p of productlist){
		if(p.pcolor==color&&
		   p.psize == size){
			p.amount++
			print()
			return;
		}
	}
	
	// 선택된 제품 정보와 옵션을 객체에 담는다.
	let sproduct = {
		pcolor : color ,
		psize : size,
		amount : 1
	}
	// 리스트에 담기
	productlist.push(sproduct)
	print()
	// 리스트에 존재하는 객체를 출력한다.
})

let btnlike = document.querySelector('.btnlike');
// 찜하기 버튼을 눌렀을 때
document.querySelector('.btnlike').addEventListener('click', (e)=>{
	// 1. 로그인 유무 판탄 방법1)ajax 방법2)html에서 가져온다
	let mid = document.querySelector('.mid').value
	if(mid =='null'){ // input자체가 문자열이기 때문에 문자열!!!!인 null로 들어온다		
		alert('로그인 후 가능한 기능입니다.')
		return;
	}
	
	
	// 2. 찜하기 등록 혹은 삭제 처리
	$.ajax({
		url:"/jspweb/product/plike",
		type:"post",
		data:{"pno":pno},
		success : re =>{
			if(re=="1"){
				alert('찜하기 취소')
				btnlike.innerHTML = '찜하기 ♡'
			}else if(re=="2"){
				alert('찜하기 ')
				btnlike.innerHTML = '찜하기 ♥'
			}else if(re=="3"){
				alert('찜하기 db오류')
			}
			
			
		}
	})
	
})

// 장바구니 버튼을 눌렀을때
document.querySelector('.btncart').addEventListener('click' , (e)=>{

	// 1. 만약에 선택한 제품이 없으면 
	if( productlist.length == 0 ){ alert('최소1개 이상 옵션을 선택해주세요'); return; }
	// 2. 로그인 유무 
	if( document.querySelector('.mid').value == 'null' ){ alert('로그인후 가능한 기능입니다.');return; }

	// 3. 선택된 제품들의 옵션들을 전송
	$.ajax({ // 전송타입 : 문자열객체 
		url : "/jspweb/product/cart" ,
		type : "post",
		data : { "data" : JSON.stringify(productlist) , "pno" : pno } , 
				//  JSON.stringify( 객체 ) : 객체 타입 --> 문자열타입
		success : re =>{ 	alert(re)  }
	})

});

/////////////////////////////////////// 함 수 ///////////////////////////////////////

getproduct(pno) // 제품 정보 호출 [ pno ] 
getstock(pno)   // 제품 재고 호출 [ pno ]
sethtmlprint()

// 1. 해당 제품 번호의 제품정보 호출
function getproduct(pno){
	$.ajax({	//결과와 상관없이 다음코드가 진행 [ 비 동 기 ] [async : true 결과를 대기X async : false 결과를 대기O ]
	url:"http://localhost:8080/jspweb/regist",
	type:"get",
	async : false,
	data:{"type" : 2 , "pno" : pno},
	success : re => {
		let p = JSON.parse(re)
		}
	})
}
// 2. 해당 제품의 정보를 HTML 대입 메소드
function sethtmlprint(){
	console.log(p)
		// 1. 제품 사진
		document.querySelector('.pimg').src='/jspweb/admin/pimg/'+p.pimg
		// 2. 제품명 대입
		document.querySelector('.pname').innerHTML=p.pname
		// 3. 제품 설명 대입
		document.querySelector('.pcomment').innerHTML=p.pcomment
		// 4. 가격 대입
		document.querySelector('.pprice').innerHTML=p.pprice
			// 1) 할인이 있을 때,
			let phtml =''
			if(p.discount == 0){				// 소수점 버리기
				psale = p.pprice-(p.pprice*p.pdiscount).toLocaleString()
				phtml += 	'<span class="pdiscount">'+Math.round(p.pdiscount*100)+'%</span>'
							+'<span class="pprice">'+(p.pprice.toLocaleString())+'</span>'
							+'<span class="psale">'+psale.toLocaleString()+'</span>'
				document.querySelector('.pricebox').innerHTML = phtml
			}
			// 2) 할인이 없을 때,
			else{
				psale = product.pprice
				phtml +=  '<span class="pprice">'+psale.toLocaleString()+'</span>'
				document.querySelector('.pricebox').innerHTML = phtml
			}
			
			
			
			// 사이즈목록 중복 제거 [ set , includes , filter 등]
			// 사이즈 목록
			let sizelist = []
			stock.forEach(s=>{sizelist.push(s.psize)})
			let sizeset = new Set(sizelist) // 2.사이즈목록 중복제거
			console.log(sizeset)
			
			// 6. 사이즈 종류 [ 중복 제거 o ]
			let shtml='<span> ['
			sizeset.forEach( s => {
				shtml +=  " "+s+" "
			})
			shtml += '] </span>'
			document.querySelector('.sizebox').innerHTML = shtml
			
			// 7. 색상 select 구성 [ 중복 제거 o ]
			let colorlist = []
			stock.forEach(s => {colorlist.push(s.pcolor)})
			let colorset = new Set(colorlist)
			console.log(colorset)
			
			chtml = '<option>-[필수] 색상 선택</option>'
			colorset.forEach(c=>{
				chtml += '<option value='+c+'>'+c+'</option>'
			})
			document.querySelector('.cselect').innerHTML = chtml
			

			// 8. 선택된 색상의 사이즈 select 구성 [ 중복 제거 x ]
			//ahtml = '<option>-[필수] 사이즈 선택</option>'
			//stock.forEach( c => {
			//	ahtml += '<option>'+c.psize+'</option>'
			//})
			//document.querySelector('.sselect').innerHTML = ahtml
}

// 3. 재고 가져오는 함수 메소드
function getstock(pno){
	// 5. 제품의 재고목록 호출 [ajax]
	$.ajax({
		url:"http://localhost:8080/jspweb/stock",
		type:"get",
		async : false,
		data:{"pno":pno},
		success : re => {
			 stock = JSON.parse(re)
		}
	})
}

// 4. 프린트 함수
function print(){
	let ohtml ='<tr>'
					+'<th width="60%">상품명/옵션</th>'
					+'<th width="25%">수량</th>'
					+'<th width="15%">가격</th>'
				+'</tr>';
	let totalprice = 0
	let totalamount = 0
	productlist.forEach( (p,i) =>{
		let tsale = psale*p.amount 
		let tpoint = Math.rount(tsale * 0.01)
		
		totalprice += tsale // 각 옵션별 판매가를 전체판매가에 누적 더하기
		totalamount += p.amount // 각 옵션별 수량을 전체 수량에 누적 더하기
		
					ohtml += '<tr>'+
'								<td>'+
'									<span> '+product.pname+'</span>'+
'									<br>'+
'									<span> '+p.pcolor+' / '+p.psize+' </span>'+
'								</td>'+
'								<td class="row g-0">'+
'									<div class="col-md-4 amountinput">'+
'										<input readonly class="form-control" value='+p.amount+'>'+
'									</div>'+
'									<div class="col-md-4">'+
'										<button class="amount_btn" onclick="amountup('+i+')"> ▲ </button>'+
'										<button class="amount_btn" onclick="amountdown('+i+')"> ▼ </button>'+
'									</div>'+
'									<div class="col-md-1">'+
'										<button class="cancel_btn" onclick="pcancel('+i+')"> x </button>'+
'									</div>'+
'								</td>'+
'								<td>'+
'									<span class="pricebox"> '+tsale.toLocaleString()+' </span><br>'+
'									<span class="pointbox"> (포인트)'+tpoint.toLocaleString()+' </span>'+
'								</td>'+
'							</tr>';
		
	})
	
	document.querySelector('.select_t').innerHTML = ohtml
	let tohtml = totalprice.toLocaleString()+"원("+totalamount+"개)"
	document.querySelector('.totalprice').innerHTML = tohtml
	
}
	
	
// 5. 수량 증가 버튼
function amountup(i){
	let maxstock = 0;
	stock.forEach(s =>{
		if(s.pcolor == productlist[i].pcolor &&
		   s.psize == productlist[i].psize ){ // 재고목록에서 선택한 옵션과 일치하면
			maxstock = s.pstock // 재고 대입
		}
	})
		
	if(productlist[i].amount >= maxstock){alert('재고가 부족합니다.'); return;}
	productlist[i].amount++; print()}
// 6. 수량 감소 버튼
function amountdown(i){
	if(productlist[i].amount <= 1){alert('최소 구매수량 입니다.'); return;}
	productlist[i].amount--; print()}
	
	
// 7. 선택된 제품 제거
function pcancel(i){
	// 선택된 제품리스트에서 i번째부터 1개 인덱스 제거
	productlist.splice(i,1); print();
}	
	
	
	
	
	
	