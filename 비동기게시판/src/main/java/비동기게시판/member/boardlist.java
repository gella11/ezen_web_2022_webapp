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

@WebServlet("/비동기게시판/boardlist")
public class boardlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public boardlist() {super();   }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		// 페이지당 계시글 수
		int listsize = Integer.parseInt(request.getParameter("listsize"));
		
		// 전체 게시글 수
		boardDao dao = new boardDao();
		int totalsize = dao.gettotal();
		
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
		
		ArrayList<boardDto1> list = dao.boardlist(startrow, listsize);
		System.out.println("여기"+list);
		JSONArray array = new JSONArray();
		
		for(boardDto1 dto : list) {
			// JSONObject 생성
			JSONObject object = new JSONObject();
			object.put("bno", dto.getBno() );
			object.put("btitle", dto.getBtitle() );
			object.put("bcontent", dto.getBcontent() );
			object.put("bname", dto.getBname() );
			object.put("bpassword", dto.getBpassword() );
			object.put("mdate", dto.getBdate() );
			object.put("view", dto.getView() );
			array.add(object); // JSONObject 객체를 리스트에 담기
		}
		
		boards.put("totalpage", totalpage);
		boards.put("data", array);
		boards.put("startbtn", startbtn);
		boards.put("endbtn", endbtn);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(boards);
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
