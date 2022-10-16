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


@WebServlet("/비동기게시판/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public view() { super();  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bno = Integer.parseInt(request.getParameter("bno")) ;
		System.out.println(bno);
		boardDao dao = new boardDao();
		boardDto1 dto = dao.getboard(bno);

			JSONObject object = new JSONObject();
			object.put("bno", dto.getBno() );
			object.put("btitle", dto.getBtitle() );
			object.put("bcontent", dto.getBcontent() );
			object.put("bname", dto.getBname() );
			object.put("bpassword", dto.getBpassword() );
			object.put("bdate", dto.getBdate() );
			object.put("view", dto.getView() );
			
			System.out.println(object);
		
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(object);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
