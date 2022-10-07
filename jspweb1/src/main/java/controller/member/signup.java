package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;

// @WebServlet("URL") : 해당 클래스를 호출하는 URL 정의
@WebServlet("/member/signup")	// 해당 클래스로 맵핑(연결) URL 설정 [ 패키지경로x ]
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public signup() {	super();	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		// 0. 한글 인코딩
		request.setCharacterEncoding("URF-8");
		
		// 1.JSP(HTML) form 입력받은 데이터 요청
		String mid 				= request.getParameter("mid");
		String mpassword 		= request.getParameter("mpassword");
		String mpasswordconfirm = request.getParameter("mpasswordconfirm");
		String mname			= request.getParameter("mname");
		String mphone 			= request.getParameter("mphone");
		String memail 			= request.getParameter("memail");
		//String maddress			= request.getParameter("maddress");
		
		// 주소 요청
		String maddress1			= request.getParameter("address1");
		String maddress2			= request.getParameter("address2");
		String maddress3			= request.getParameter("address3");
		String maddress4			= request.getParameter("address4");
		
		String maddress = maddress1+"_"+maddress2+"_"+maddress3+"_"+maddress4;
		
		
		
		// 2. 변수 6개 -> DTO 객체화
		MemberDto dto = new MemberDto(0, mid, mpassword, mname, mphone, memail, maddress, null, 0);
		
		// 3. 통신 확인 [HTML -> JAVA]
		System.out.println( dto.toString());
		
		// 4. DAO 메소드 호출용 객체 선언
		// 싱글톤 객체가 아닐경우
		MemberDao dao = new MemberDao();
		boolean result = dao.signup(dto);
		if(result) {System.out.println("회원가입 성공");}
		else 	   {System.out.println("회원가입 실패");}

		// 싱글톤 쓸 경우
		//boolean result = MemberDao.getInstance().signup(dto);
		
		// 5. 결과제어
		if(result) {	response.sendRedirect("/jspweb/member/login.jsp");	}
		else {}
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
