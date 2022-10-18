package controller.member.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.cj.xdevapi.JsonArray;

import model.dao.BoardDao;
import model.dto.BoardDto;

/**
 * Servlet implementation class list
 */
@WebServlet("/board/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public list() {    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 페이지당 계시글 수
		int listsize = Integer.parseInt(request.getParameter("listsize"));
		
		// 전체 게시글 수
		int totalsize = BoardDao.getInstance().gettotal();
		
		// 전체 페이지 계산
		int totalpage = 0;
		if(totalsize % listsize == 0) {totalpage = totalsize/listsize;}
		else 						  {totalpage = totalsize/listsize+1;}
		
		// 페이징처리에 필요한 정보 담는 jsonobject
		JSONObject boards = new JSONObject();
		
		// 현재 페이지 수
		int page = Integer.parseInt(request.getParameter("page"));
		
		// 페이지별 시작 게시물 행 번호
		int startrow = (page-1)*listsize;

		// 화면에 표시할 최대 버늩 수
		int btnsize = 5;
		int startbtn = ( (page-1)/btnsize) * btnsize+1;
		int endbtn = startbtn +(btnsize-1);
			if(endbtn >totalpage) {endbtn = totalpage;}
		
		

		// 2. db
		ArrayList<BoardDto> list =  BoardDao.getInstance().getlist(startrow, listsize);
		// ** arraylist ---> jsonarray 변환[ js에서 쓸려고 ]
		JSONArray array = new JSONArray();
		// arraylist ---> jsonarray 변화 [js에서 쓰려고]
		for( int i = 0  ; i<list.size() ; i++ ) {
			JSONObject object = new JSONObject();
			object.put("bno", list.get(i).getBno() );
			object.put("btitle", list.get(i).getBtitle() );
			object.put("bdate", list.get(i).getBdate() );
			object.put("bview", list.get(i).getBview() );
			object.put("mid", list.get(i).getMid() );
			array.add(object);
		}		
		System.out.println(array);
		
		boards.put("totalpage", totalpage);
		boards.put("data", array);
		boards.put("startbtn", startbtn);
		boards.put("endbtn", endbtn);
		
	// 3. 응답o
	response.setCharacterEncoding("UTF-8"); 
	//response.getWriter().print( array );
	response.getWriter().print( boards );
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
