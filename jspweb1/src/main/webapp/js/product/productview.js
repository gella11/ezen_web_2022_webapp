
let pno = document.querySelector('.pno').value


let stock = ''

$.ajax({
	url:"http://localhost:8080/jspweb/regist",
	type:"get",
	data:{"type" : 2 , "pno" : pno},
	success : re => {
		let p = JSON.parse(re)
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
			if(p.discount == 0){						// 소수점 버리기
				phtml += 	'<span class="pdiscount">'+Math.round(p.pdiscount*100)+'%</span>'
							+'<span class="pprice">'+(p.pprice.toLocaleString())+'</span>'
							+'<span class="psale">'+(p.pprice-(p.pprice*p.pdiscount)).toLocaleString()+'</span>'
				document.querySelector('.pricebox').innerHTML = phtml
			}
			// 2) 할인이 없을 때,
			else{
				phtml +=  '<span class="pprice">'+(p.pprice.toLocaleString())+'</span>'
				document.querySelector('.pricebox').innerHTML = phtml
			}
		// 5. 제품의 재고목록 호출 [ajax]
			$.ajax({
				url:"http://localhost:8080/jspweb/stock",
				type:"get",
				data:{"pno":pno},
				success : re => {
					 stock = JSON.parse(re)
					
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
			})
		}
	})
let color = null;

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
	

let sproductlist = []
// 사이즈 select 박스를 체인지 했을 때 이벤트
document.querySelector('.sselect').addEventListener('change' , (e)=>{
	let size = e.currentTarget.value
	
	// 선택된 제품 정보와 옵션을 객체에 담는다.
	let sproduct = {
		pcolor : color ,
		psize : size,
		amount : 1
	}
	// 리스트에 담기
	sproductlist.push(sproduct)
	print()
	console.log(sproductlist)
	// 리스트에 존재하는 객체를 출력한다.
})

function print(){
	let ohtml ='';
	sproductlist.forEach(p=>{
		ohtml += '<tr>'+
'								<td>'+
'									<span> 미라클 경량 점퍼</span>'+
'									<br>'+
'									<span> -블랙 / FREE </span>'+
'								</td>'+
'								<td class="row g-0">'+
'									<div class="col-md-3 amountinput">'+
'										<input class="form-control" value="1">'+
'									</div>'+
'									<div class="col-md-4">'+
'										<button class="amount_btn"> ▲ </button>'+
'										<button class="amount_btn"> ▼ </button>'+
'									</div>'+
'									<div class="col-md-1">'+
'										<button class="cancel_btn"> x </button>'+
'									</div>'+
'								</td>'+
'								<td>'+
'									<span class="pricebox"> 20,000원 </span><br>'+
'									<span class="pointbox"> (포인트)200 </span>'+
'								</td>'+
'							</tr>';
		
	})
	document.querySelector('.select_t').innerHTML = ohtml
}
	
	
	
	
	
	
	
	
	
	
	
	