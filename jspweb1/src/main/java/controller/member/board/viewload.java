package controller.member.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.BoardDao;

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
		
				// 게시글의 bno 가져오기
				int bno = Integer.parseInt(request.getParameter("bno") ) ;
				
				// 세션 객체 만들기
				HttpSession session = request.getSession();
				
				// 클릭한 게시물 번호를 세션에 저장
				session.setAttribute("bno", bno);
				
				// 로그인한 회원 아이디
				String mid = (String)request.getSession().getAttribute("mid");
				

				// 해당 유저가 24시간 내 한번도 클릭한 적이 없으면 [세션이 없으면]
				if( session.getAttribute(bno+mid) == null) {

					boolean result = BoardDao.getInstance().view(bno);
					if(result) { System.out.println("조회수 증가");	}
					else	   { System.out.println("조회수 증가 실패"); }
					request.getSession().setAttribute(bno+mid, true);
					request.getSession().setMaxInactiveInterval(60*60*24);
					

					//srequest.getSession().setAttribute("bno", bno);
				}
				
				
				// 세션 주기 현재 유저가 조회수 한 기록 남기기 [ 해당 유저가 조회수 올린 적 있다/없다 ]

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
