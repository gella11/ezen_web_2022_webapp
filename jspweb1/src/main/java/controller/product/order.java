package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import model.dao.MemberDao;
import model.dao.ProductDao;
import model.dto.OrderDto;


@WebServlet("/product/order")
public class order extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public order() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		String data = request.getParameter("data"); // 결제할 제품 리스트 문자열 
		String orderinfo = request.getParameter("orderinfo"); // 받는 사람 정보 문자열
		int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("mid"));
		
		
		// 문자열타입 JSON형식 ---> JSON타입 형변환
		JSONParser parser = new JSONParser();
		
		try {
			// 1. 객체 [ 받는 사람 회원정보 문자열 ---> jsonobject ]
			JSONObject jsonObject = (JSONObject)parser.parse(orderinfo);
			// 2. 리스트[ 결제할 제품 리스트 문자열 -> jsonarray
			JSONArray jsonArray = (JSONArray) parser.parse(data);
			
			//받는 사람 정보
			String oname = String.valueOf( jsonObject.get("amount"));
			String ophone = String.valueOf( jsonObject.get("ophone"));
			String oaddress = String.valueOf( jsonObject.get("oaddress"));
			String oquest = String.valueOf( jsonObject.get("oquest"));
			
			ArrayList<OrderDto> list = new ArrayList<>();
			// 3. 반복문 [ orderDto 객체 -> Dao 처리]
			for(int i = 0 ; i<jsonArray.size(); i++){
				JSONObject object =  (JSONObject)jsonArray.get(i);
				
				// 주문 상세 정보
				int odamount = 		Integer.parseInt(String.valueOf( object.get("amount")));
					int pprice = 		Integer.parseInt(String.valueOf(object.get("pprice")));
					float pdiscount = 	Float.parseFloat(String.valueOf(object.get("pdiscount")));
				int odprice =		Math.round(pprice -(pprice * pdiscount));
				int pstno =			Integer.parseInt(String.valueOf(object.get("pstno")));
				
				// 주문 dto 생성
				OrderDto dto = new OrderDto(
						0,
						oname,
						ophone,
						oaddress,
						oquest,
						null,
						mno,
						0,
						odamount,
						odprice,
						0,
						pstno);
				list.add(dto);
				System.out.println(dto.toString()); // 확인
			}
			boolean result = new ProductDao().setOrder(list);
			System.out.println("llllllll"+list);
			System.out.println("resusssss"+result);
			response.getWriter().print(result);
			
		} catch (Exception e) {System.out.println("json 형변환 오류"+e);	}
		  response.getWriter().print(true); // 성공햇을 때 true
	}
}
