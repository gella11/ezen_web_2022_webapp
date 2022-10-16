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

/**
 * Servlet implementation class review
 */
@WebServlet("/review")
public class review extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public review() {super();   }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String btitle 				= request.getParameter("btitle");
		String bcontent 			= request.getParameter("bcontent");
		String bname				= request.getParameter("bname");
		String bpassword 			= request.getParameter("bpassword");
	
		boardDto1 bdto = new boardDto1(0, btitle, bcontent, bname, bpassword, null, 0);
		boardDao bdao = new boardDao();
		System.out.println( bdto.toString() );
		
		
		boolean result = bdao.review(bdto);
		
		if(result) {
			System.out.println("답글 등록 성공");
			response.getWriter().print(result);
			}
		else{
			System.out.println("답글 등록 실패");
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
