package controller.member.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.ProductDao;
import model.dto.PcategoryDto;



@WebServlet("/pcategory")
public class pcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public pcategory() {    super();   }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<PcategoryDto> list = new ProductDao().getpcatogory();
		JSONArray array = new JSONArray();
		
		for(PcategoryDto dto : list) {
			// JSONObject 생성
			JSONObject object = new JSONObject();
			object.put("pcno", dto.getPcno() );
			object.put("pcname", dto.getPcname() );
			array.add(object); // JSONObject 객체를 리스트에 담기
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 등록이라 포스트
		
		// 1. 요청
		request.setCharacterEncoding("UTF-8");
		String pcname  = request.getParameter("pcname");
		
		// 2. dao처리
		boolean result = new ProductDao().setpcategory(pcname);
		
		// 3. 응답
		response.getWriter().print(result);
		
		
		
	}

}
