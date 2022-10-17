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
import model.dao.reviewDao;
import model.dto.boardDto1;
import model.dto.reviewDto;


@WebServlet("/비동기게시판/review")
public class review extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public review() {super();   }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("???");
		
		String cname 				= request.getParameter("cname");
		String ccontent				= request.getParameter("ccontent");
		String cpassword 			= request.getParameter("cpassword");
		
		
		System.out.println(cname);
		System.out.println(ccontent);
		System.out.println(cpassword);
	
		reviewDao rdao = new reviewDao();
		boolean result = rdao.review( cname, ccontent, cpassword);
		
		if(result) {
			System.out.println("리뷰 등록 성공");
			response.getWriter().print(result);
			}
		else{
			System.out.println("리뷰 등록 실패");
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
