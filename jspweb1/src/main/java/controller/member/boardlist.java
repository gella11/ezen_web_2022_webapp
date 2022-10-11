package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.MemberDao;
import model.dao.bboardDao;
import model.dto.MemberDto;
import model.dto.boardDto;

/**
 * Servlet implementation class boardlist
 */
@WebServlet("/boardlist")
public class boardlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public boardlist() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		//ArrayList<boardDto> list = bboardDao.getInstance().boardlist();
		bboardDao dao = new bboardDao();
		ArrayList<boardDto> list = dao.boardlist();
		
		//Dto ---> json
		//JSONObject를 여러개 담을 수 있는 JSON리스트 선언
		JSONArray array = new JSONArray();
		
		for(boardDto dto : list) {
			// JSONObject 생성
			JSONObject object = new JSONObject();
			object.put("bno", dto.getBno() );
			object.put("btitle", dto.getTitle() );
			object.put("bcontent", dto.getContent() );
			object.put("bname", dto.getBname() );
			object.put("bpassword", dto.getBpassword() );
			object.put("mdate", dto.getBdate() );
			object.put("view", dto.getView() );
			array.add(object); // JSONObject 객체를 리스트에 담기
		}
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
