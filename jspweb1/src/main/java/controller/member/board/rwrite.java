package controller.member.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDao;
import model.dao.MemberDao;

@WebServlet("/reply/rwrite")
public class rwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public rwrite() { super();  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청
		// 타입 요청 [ 0 댓글 / 1 대댓글 ]
		// 타입 자료형은 무조건 문자형
		String type = request.getParameter("type");
		request.setCharacterEncoding("UTF-8");
		
		String rcontent = request.getParameter("rcontent");
				int bno = (Integer)request.getSession().getAttribute("bno");
				int mno = MemberDao.getInstance().getMno( (String)request.getSession().getAttribute("mid") );
						if(mno==0) {response.getWriter().print("0"); return;}// 비 로그인일 경우 반환
		
		
		
		// DB DAO
		boolean result = false;
		if(type.equals("reply")) {
			result = BoardDao.getInstance().rwrite(rcontent, mno, bno);
			if(result) {response.getWriter().print("1");}
			else 	   {response.getWriter().print("2");}
			
		}
		else if(type.equals("rereply")) {
			int rindex = Integer.parseInt(request.getParameter("rno"));
			result = BoardDao.getInstance().rrwrite(rcontent, mno, bno, rindex);
			if(result) {response.getWriter().print("1");}
			else 	   {response.getWriter().print("2");}
			
		}
		
		
		
		
		
		
		
		
	}

}
