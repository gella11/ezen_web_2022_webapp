package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.dao.MemberDao;
import model.dto.MemberDto;


@WebServlet("/member/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// ----------- ajax -------------
			// js ajax에게 변수 요청
			String mid = request.getParameter("mid");
			String mpassword = request.getParameter("mpassword");
			// Dao 응답
			int result = MemberDao.getInstance().login(mid, mpassword);
			// db결과를 js ajax에게 응답
			response.getWriter().print( result );
	}
		

		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		/*String mid 				= request.getParameter("mid");
		String mpassword 		= request.getParameter("mpassword");
		
		MemberDao dao = new MemberDao();
		int result = dao.login(mid, mpassword);
		if(result == 1) {System.out.println("로그인 성공");}
		else 	   {System.out.println("로그인 실패");}
		
		if(result== 1) {	response.sendRedirect("/jspweb/index.jsp");	}
		else 	   {	response.sendRedirect("/jspweb/member/login.jsp"); }*/
	}	

}
