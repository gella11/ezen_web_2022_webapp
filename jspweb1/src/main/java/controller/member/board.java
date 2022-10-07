package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.bboardDao;
import model.dto.boardDto;


@WebServlet("/board/board")
public class board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public board() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String title 				= request.getParameter("title");
			String content 				= request.getParameter("content");
			String bname				= request.getParameter("bname");
			String bpassword 			= request.getParameter("bpassword");
		
			boardDto bdto = new boardDto(0, title, content, bname, bpassword, null);
			System.out.println( bdto.toString() );
			
			bboardDao bdao = new bboardDao();
			boolean result = bdao.board(bdto);
			if(result) {System.out.println("글 등록 성공");}
			else 	   {System.out.println("글 등록 실패");}
			
			if(result) {	response.sendRedirect("/jspweb/index.jsp");	}
			else 	   {	response.sendRedirect("/jspweb/board/board"); }	
		
		
		doGet(request, response);
	}

}
