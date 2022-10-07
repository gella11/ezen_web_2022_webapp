package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

/**
 * Servlet implementation class findpassword
 */
@WebServlet("/member/findpassword")
public class findpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findpassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String mid = request.getParameter("mid");
		String memail = request.getParameter("memail");
		
		// Dao 응답
		boolean result = MemberDao.getInstance().findpassword(mid, memail);
		
		// db결과를 js ajax에게 응답
		// 문자 난수 15자리 : 랜덤클래스 [임시비밀번호]
		String randstr = "";
		if(result) {
			Random random = new Random();
			for( int i = 0; i <15 ; i++) {
			randstr += (char)(random.nextInt(26)+97); // 난수 -> 문자로 강제형변환 (소문자 아스키코드로 97~122)
										// random.nextInt(26) 		: 0~25
										// random.nextInt(26)+97 	: 97~122
										// (char)(random.nextInt(26)+97)
			}
			// 해당 회원의 비밀번호 임시 비밀번호 교체[업데이트]
			MemberDao.getInstance().passwordchange(mid, randstr);
		}
		response.getWriter().print( randstr );		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
