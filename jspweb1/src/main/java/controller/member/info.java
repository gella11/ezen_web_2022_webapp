package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class info
 */
@WebServlet("/member/info")
public class info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// 1.요청
		String mid = (String)request.getSession().getAttribute("mid");
		// 2.db
		MemberDto dto = MemberDao.getInstance().getinfo(mid);
			// 	  JS DTO 사용 못함
			// 1) JS 이해할 수 있는 형식 변경해야함. [ JSON 형식 ]
			// 2) DTO -> JSON 형식 변경 [ JAVA에서 제공 안해줌x -> 외부라이브러리 
			JSONObject object = new JSONObject();
			object.put("mno", dto.getMno() );
			object.put("mid", dto.getMid() );
			object.put("mname", dto.getMname() );
			object.put("mphone", dto.getMphone() );
			object.put("memail", dto.getMemail() );
			object.put("maddress", dto.getMaddress() );
			object.put("mdate", dto.getMdate() );
			object.put("mpint", dto.getMpint() );
		// 3.서비스로직
		//String result ="성공";
		// 4.응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(object);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
