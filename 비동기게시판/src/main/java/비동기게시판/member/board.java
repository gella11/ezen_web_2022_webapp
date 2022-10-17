package 비동기게시판.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.boardDao;
import model.dto.boardDto1;


@WebServlet("/비동기게시판/board")
public class board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public board() {super();  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String btitle 				= request.getParameter("btitle");
		String bcontent 			= request.getParameter("bcontent");
		String bname				= request.getParameter("bname");
		String bpassword 			= request.getParameter("bpassword");
		
		System.out.println(btitle);
		System.out.println(bcontent);
		System.out.println(bname);
		System.out.println(bpassword);
		
		boardDto1 bdto = new boardDto1(0, btitle, bcontent, bname, bpassword, null, 0);
		
		
		
		boardDao bdao = new boardDao();
		
		
		System.out.println( bdto.toString() );
		
		//boolean result = bdao.board(bdto);
		boolean result = bdao.board(btitle , bcontent , bname, bpassword);
		
		if(result) {
			System.out.println(result);
			System.out.println("글 등록 성공");
			response.getWriter().print(result);
			}
		else{
			System.out.println("글 등록 실패");
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		
		

	}

}
