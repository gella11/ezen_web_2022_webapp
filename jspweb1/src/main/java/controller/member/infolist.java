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
import model.dto.MemberDto;

/**
 * Servlet implementation class infolist
 */
@WebServlet("/member/infolist")
public class infolist extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public infolist() {super();    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<MemberDto> list = MemberDao.getInstance().getinfolist();
		//Dto ---> json
		//JSONObject를 여러개 담을 수 있는 JSON리스트 선언
		JSONArray array = new JSONArray();
		for(MemberDto dto : list) {
			// JSONObject 생성
			JSONObject object = new JSONObject();
			// JSONObject 에 엔트리[정보] 담기
			object.put("mno", dto.getMno() );
			object.put("mid", dto.getMid() );
			object.put("mname", dto.getMname() );
			object.put("mphone", dto.getMphone() );
			object.put("memail", dto.getMemail() );
			object.put("maddress", dto.getMaddress() );
			object.put("mdate", dto.getMdate() );
			object.put("mpint", dto.getMpint() );
			array.add(object); // JSONObject 객체를 리스트에 담기
		}
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
