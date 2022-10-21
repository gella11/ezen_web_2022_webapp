package model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import controller.BoardDao;
import controller.BoardDto;


@WebServlet("/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public view() {super();    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String type = request.getParameter("type");
		
		BoardDao dao = new BoardDao();
		BoardDto dto = new BoardDto();
		
		if( type.equals("list") ){
			int bno = Integer.parseInt(request.getParameter("bno"));
			HttpSession session = request.getSession();
			session.setAttribute("bno",bno);
			response.getWriter().print(true);
		}
		else if( type.equals("view") ){
			int bno2 = (int)request.getSession().getAttribute("bno");
			
			BoardDto dto1 = dao.getboard(bno2);
			
			
			JSONObject object = new JSONObject();
			object.put("bno", dto1.getBno() );
			object.put("btitle", dto1.getBtitle() );
			object.put("bcontent", dto1.getBcontent() );
			object.put("bname", dto1.getBname() );
			object.put("bpassword", dto1.getBpassword() );
			object.put("bdate", dto1.getBdate() );
			object.put("view", dto1.getView() );
			
			
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print( object );
			
		}
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
