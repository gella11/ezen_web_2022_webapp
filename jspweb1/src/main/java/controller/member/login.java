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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String mid 				= request.getParameter("mid");
		String mpassword 		= request.getParameter("mpassword");
		
		MemberDao dao = new MemberDao();
		boolean result = dao.login(mid, mpassword);
		if(result) {System.out.println("로그인 성공");}
		else 	   {System.out.println("로그인 실패");}
		
		if(result) {	response.sendRedirect("/jspweb/index.jsp");	}
		else 	   {	response.sendRedirect("/jspweb/member/login.jsp"); }
	}	

}
