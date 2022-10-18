package controller.member.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dto.BoardDto;

/**
 * Servlet implementation class bupdate
 */
@WebServlet("/board/bupdate")
public class bupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public bupdate() { super();  }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uploadpath = request.getSession().getServletContext().getRealPath("/upload/");
		MultipartRequest multi = new MultipartRequest(
				   request ,					 // 요청방식
				   uploadpath ,
				   1024 * 1024 * 10, 			 // [1024 : 1kb] [1024*1024 : 1mb] [1024*1024*1024 : 1G]
				   "UTF-8",	
				   new DefaultFileRenamePolicy() // 업로드 된 파일의 이름이 중복일 경우 자동으로 이름 지정
				   );
		// 요청
		String btitle = multi.getParameter("btitle");			// 수정할 제목
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		
		// 수정할 게시물의 번호
		int bno = (Integer)request.getSession().getAttribute("bno");
		
							// 1) 수정시 새로운 첨부파일 등록 있을 경우[ 기존첨부파일 삭제 ]
		
		
		// 수정 전 게시물 정보 
		BoardDto dto = BoardDao.getInstance().getboard(bno);
		
		// 기존 첨부파일 변경 여부 판단
		boolean bfilechange = true;
		
		
		if(bfile == null) { // 2) 수정시 첨부파일 등록 없을 경우 [ 기존 첨부파일 호출 ]
			bfile =  dto.getBfile();
			bfilechange = false;
		}
		
		// dao 처리
		boolean result = BoardDao.getInstance().bupdate(bno, btitle, bcontent , bfile);
		// *. 수정시 첨부파일 등록 없을경우 [ 기존첨부파일 호출  ]
		if( bfile == null ) {  bfile = dto.getBfile(); bfilechange =false; }
		
		if(result) {	// 업데이트 성공시 [ 기존첨부파일 변경되었을 때 ] 기존파일 삭제
			if(bfilechange) {
				String deletepath = request.getSession().getServletContext().getRealPath("/upload/"+dto.getBfile());
				File file = new File(deletepath);
				if(file.exists()) {
					file.delete();
				}
			} 
		}
		
		// 결과 반환
		response.getWriter().print(result);
		
	}

}
