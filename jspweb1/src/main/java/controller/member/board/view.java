package controller.member.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.dao.BoardDao;
import model.dto.BoardDto;


@WebServlet("/board/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {super();  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청
		//int bno = Integer.parseInt(request.getParameter("bno"));
		//BoardDto dto =  BoardDao.getInstance().getboard(bno);
		
		// 1. 요청 
		//int bno = Integer.parseInt( request.getParameter("bno") ) ;
				//System.out.println( bno );

				// 1. 세션 요청 [ 세션(Object) --> String -> int ] 
					// 다형성 : 부모가 자식으로 강제 형변환 가능 
				int bno = (Integer)request.getSession().getAttribute("bno");
				// 2. DAO 처리 
				BoardDto dto = BoardDao.getInstance().getboard(bno);

				// 3. DTO --> JSON 형변환
				JSONObject object = new JSONObject();
				object.put("bno", dto.getBno());
				object.put("btitle", dto.getBtitle());
				object.put("bcontent", dto.getBcontent());
				object.put("mid", dto.getMid() );
				object.put("bfile", dto.getBfile() );

					// 삭제 , 수정 버튼 활성화를 위한 식별 변수 선언
					String mid = (String)request.getSession().getAttribute("mid");
					if(mid!=null && mid.equals(dto.getMid())) {
						object.put("btnaction", true);
					}
					
				
				// 4. 응답 
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print( object );
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}