package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

/**
 * Servlet implementation class delete
 */
@WebServlet("/member/memberdelete")
public class memberdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public memberdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 변수요청
		String mpassword = request.getParameter("mpassword");
		System.out.println(mpassword);
		// 2. 세션 호출
		String mid = (String)request.getSession().getAttribute("mid");
		// 3. DAO
		boolean result = MemberDao.getInstance().delete(mid, mpassword);
		System.out.println(result);
		// 4
		response.getWriter().print(result);
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
