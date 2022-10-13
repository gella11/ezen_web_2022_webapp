package controller.member.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDao;
import model.dao.MemberDao;

/**
 * Servlet implementation class write
 */
@WebServlet("/board/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public write() {super(); }
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mid = (String)request.getSession().getAttribute("mid");		
		int mno = MemberDao.getInstance().getMno(mid);
		
		
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		boolean result = BoardDao.getInstance().write(btitle, bcontent, mno);
		System.out.println(btitle);
		System.out.println(bcontent);
		System.out.println(result);
		
		/* form 전용 */
	//	if(result) {
	//		response.sendRedirect("list.jsp");
	//	}else {
	//		response.sendRedirect("write.jsp");
	//	}
		
		/* js 전송용*/
		response.getWriter().print(result);
		
	}


	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
