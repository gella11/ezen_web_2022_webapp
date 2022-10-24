

let datalist = null // 전역변수 사용 위함 선언

getdata()
function getdata(){
	$.ajax({
		url : "/jspweb/api",
		success : function(re){
			let json = JSON.parse(re)	// json 객체
			datalist = json.data		// 객체중에 data 속성 [키 필드]
			dataprint()					// 검색이 없을때 모든 약국 호출  [ search : undefined ]
		}	
	})
}




/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
// 2. 검색 버튼을 눌렀을 때 함수
function addrsearch(){
	let addr = document.querySelector('.addrinput').value
	dataprint(addr)
}

// 3. html에 약국리스트 출력 함수
function dataprint(search){
	 console.log("타입확인 : " + typeof(search))
	// undefined vs "undefined"	문자 차이 여부 확인
	
	if(search !== undefined){
		let searchlist = []
		for( let i = 0; i<datalist.length; i++){
			let addr = datalist[i].주소
			if( addr.indexOf(search) !== -1 ){
				searchlist.push( datalist[i] )
			}
		}
		console.log(searchlist)
		datalist = searchlist
		if( search == ''){ alert('초기화'); getdata() }
	}
	let html = ''
	for(let i = 0; i<datalist.length; i++){
		let data =  datalist[i]
		html += '<tr onclick="mapview('+i+')">'
				+ '<td> '+data.약국명+' </td> <td>'+data.대표전화+'</td> <td>'+data.주소+'</td>'
				+'</tr>'
	}
	// += 는 검색하면 항목들이 추가. 검색한 것만 찾아보려고 하는 것이기 때문에 = 사용
	document.querySelector('table').innerHTML = html
}

/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////

// 카카오 지도 api
function mapview(i){
	
	/* 카카오 지도 api*/
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	       			  center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	      			  level: 3 // 지도의 확대 레벨
	   				 };
	// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	////////////////////////////////////////////////////////////
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(datalist[i].주소, function(result, status) {

   	 	// 정상적으로 검색이 완료됐으면 
     	if (status === kakao.maps.services.Status.OK) {
	       	var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	       	// 결과값으로 받은 위치를 마커로 표시합니다
        	var marker = new kakao.maps.Marker({
           		 map: map,
           		 position: coords
        	});
        	
        	// 마커 클릭이벤트 : 마커에 클릭이벤트를 등록합니다
			kakao.maps.event.addListener(marker, 'click', function() {
			    detailview(i) // 약국 상세 div 출력 
			});
        	
	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+datalist[i].약국명+'</div>'
	            
	        });
	        infowindow.open(map, marker);	
	        
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
       	}
    })
}


function detailview(i){
	let html = '<div>'+datalist[i].약국명+' </div>'
			+ '<div>'+datalist[i].주소+' </div>'
			+ '<div>'+datalist[i].대표전화+' </div>'
			+ '<div> <button> 평점주기 </button> </div>'
			+ '<div> <button> 문의하기 </button> </div>'
	document.querySelector('.detailbox').innerHTML = html
}



getdata2()
function getdata2(){
	$.ajax({
		url : "/jspweb/api2",
		success : function(re){
			let datalist = JSON.parse(re)
			let html = '<tr>'
			+	'<th> 시군구 </th>'
			+	'<th> 번지/본번/부번 </th>'
			+	'<th> 단지명 </th>'
			+	'<th> 전용면적 </th>'
			+	'<th> 계약년월 </th>'
			+	'<th> 계약일 </th>'
			+	'<th> 계약금액(만원) </th>'
			+	'<th> 층 </th>'
			+	'<th> 건축년도 </th>'
			+	'<th> 도로명 </th>'
			+	'<th> 해체사유발생일 </th>'
			+	'<th> 거래유형 </th>'
			+	'<th> 중개사소재지 </th>'
			+  '</tr>'
			for(let i = 0; i<datalist.length; i++){
				let d =  datalist[i]
				html += '<tr>'
						+ '<td> '+d.시군구+'</td>'
						+ '<td>'+d.번지본번부번+'</td>'
						+ '<td>'+d.단지명+'</td>'
						+ '<td>'+d.전용면적+'</td>'
						+ '<td>'+d.계약년월+'</td>'
						+ '<td>'+d.계약일+'</td>'
						+ '<td>'+d.계약금액+'</td>'
						+ '<td>'+d.층+'</td>'
						+ '<td>'+d.건축년도+'</td>'
						+ '<td>'+d.도로명+'</td>'
						+ '<td>'+d.해체사유발생일+'</td>'
						+ '<td>'+d.거래유형+'</td>'
						+ '<td>'+d.중개사소재지+'</td>'
						+'</tr>'
			}
			document.querySelector('.searchcontent').innerHTML = html
		}
	})
}



