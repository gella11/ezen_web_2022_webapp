package controller.member.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDao;
import model.dto.BoardDto;


@WebServlet("/board/bdelete")
public class bdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public bdelete() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bno = Integer.parseInt( request.getParameter("bno") );
		
		BoardDto dto = BoardDao.getInstance().getboard(bno);// 삭제할 게시물 정보 호출 [ 삭제 전에 해야하는 당연함 주의 ]
		
		// DAO 처리 [ db내 데이터 삭제 ]
		boolean result = BoardDao.getInstance().delete(bno);
		if(result) {
			//BoardDto dto = BoardDao.getInstance().getboard(bno);// 게시물 정보 호출
			String deletepath = request.getSession().getServletContext().getRealPath("/upload/"+dto.getBfile());
			File file = new File(deletepath);
			// file 클래스
			// 자바 외부에 존재하는 파일 조작/제어 메소드 제공하는 클래스
			// 객체명.length() 해당 파일의 바이트 길이
			// 객체명.delete() 해당 파일의 삭제
			// 객체명.exists() 해당 파일이 존재하면 true/ false
			if(file.exists() )
			file.delete(); // 해당 경로에 존재하는 파일을 삭제
		}
		response.getWriter().print(result);
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
