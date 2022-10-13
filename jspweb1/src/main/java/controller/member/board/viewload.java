package controller.member.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewload
 */
@WebServlet("/board/viewload")
public class viewload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewload() {super();    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// 요청 [클릭한 게시물의 번호 저장 .  backend에 저장]
		// *세션 : 웹서버에 저장할 수 있는 메모리 공간
		// 브라우저 마다 할당이 됨.
		// 유저별로 할당이 됨.
		// 서버 종료되거나 시간타이머 끝나거나 브라우저가 아예 종료되었을 때 끝남.
		// 1. 요청 [ 클릭한 게시물의 번호 저장 = backend ]
				// * 세션 : 웹서버에 저장할수 있는 메모리 공간
					// 브라우저마다 할당 [ 유저 마다 메모리 웹서버 할당 ]
					// 서버 종료되거나 시간타이머 브라우저 종료되었을때
					// 세션 == Object
				int bno = Integer.parseInt(  
						request.getParameter("bno") ) ;

				request.getSession().setAttribute("bno", bno);

		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
