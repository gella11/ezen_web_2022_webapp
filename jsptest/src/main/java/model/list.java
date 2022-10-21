package model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controller.BoardDao;
import controller.BoardDto;


@WebServlet("/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public list() {super();    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> list = dao.boardlist();
		
		
		JSONArray array = new JSONArray();
		
		for(BoardDto dto : list) {
			// JSONObject 생성
			JSONObject object = new JSONObject();
			object.put("bno", dto.getBno() );
			object.put("btitle", dto.getBtitle() );
			object.put("bcontent", dto.getBcontent() );
			object.put("bname", dto.getBname() );
			object.put("bpassword", dto.getBpassword() );
			object.put("bdate", dto.getBdate() );
			object.put("view", dto.getView() );
			array.add(object); // JSONObject 객체를 리스트에 담기
		}
		
		
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
