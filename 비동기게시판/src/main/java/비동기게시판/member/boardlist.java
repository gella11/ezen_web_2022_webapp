package 비동기게시판.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.boardDao;
import model.dto.boardDto1;

@WebServlet("/비동기게시판/boardlist")
public class boardlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public boardlist() {super();   }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		//ArrayList<boardDto> list = bboardDao.getInstance().boardlist();
		boardDao dao = new boardDao();
		ArrayList<boardDto1> list = dao.boardlist();
		//Dto ---> json
		//JSONObject를 여러개 담을 수 있는 JSON리스트 선언
		
		JSONArray array = new JSONArray();
		for(boardDto1 dto : list) {
			// JSONObject 생성
			JSONObject object = new JSONObject();
			object.put("bno", dto.getBno() );
			object.put("btitle", dto.getBtitle() );
			object.put("bcontent", dto.getBcontent() );
			object.put("bname", dto.getBname() );
			object.put("bpassword", dto.getBpassword() );
			object.put("mdate", dto.getBdate() );
			object.put("view", dto.getView() );
			array.add(object); // JSONObject 객체를 리스트에 담기
			System.out.println(object);
		}
		System.out.println(array);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
