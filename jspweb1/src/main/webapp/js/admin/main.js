
 getpactive1()
function getpactive1(){ 
	 $.ajax({
		url : "/jspweb/regist",
		data: { "type" : 1 , "option" : "pactive1"},
		success : function(re){
			let json = JSON.parse(re)
			let html = ''
			
			json.forEach( p  => {
				let img = '/jspweb/admin/pimg/'+p.pimg
				let img2 = '<img src="'+img+'" style="height:200px;%">'
				console.log(img)
				console.log(img2)
				let aaa = p.pdiscount
				html +=  '<div class="item">								'+
			'				<a href="#"> 									'+
			'					'+img2+'									'+
			'				</a>											'+
			'				<div class="item_info">							'+
			'					<div class="item_title">					'+
			'						'+p.pname+'								'+
			'					</div>										'+
			'					<div class="item_size"> 한우1++ </div>		'+
			'					<div class="item_price">'+p.pprice+' </div>	'+
			'					<div>										'+
			'						<span class="item_sale"> '+(p.pprice-(p.pprice*(p.pdiscount/100)))+' </span> '+
			'						<span class="item_discount">  '+aaa.toLocalString('ko-KR')+' %</span>			'+
			'					</div>														'+
			'					<div class="item_review"> 찜수 9999+ 리뷰수 9999+ </div> 		'+
			'				</div>															'+
			'				<span class="badge rounded-pill text-bg-warning">주문폭주</span>	'+
			'				<span class="badge rounded-pill text-bg-danger"> 1+1 </span>	'+
			'			</div>';
			})
			
			
			document.querySelector('.itemlist').innerHTML += html
		}
	})
}












