package controller.member.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.compiler.NewlineReductionServletWriter;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.MemberDao;

/**
 * Servlet implementation class write
 */
@WebServlet("/board/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public write() {super(); }
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * String mid = (String)request.getSession().getAttribute("mid"); int mno =
		 * MemberDao.getInstance().getMno(mid);
		 * 
		 * 
		 * String btitle = request.getParameter("btitle"); String bcontent =
		 * request.getParameter("bcontent"); // 코드 바뀌어서 빨간 줄 나올겨 boolean result =
		 * BoardDao.getInstance().write(btitle, bcontent, mno);
		 * System.out.println(btitle); System.out.println(bcontent);
		 * System.out.println(result);
		 */
		
		/* form 전용 */
	//	if(result) {
	//		response.sendRedirect("list.jsp");
	//	}else {
	//		response.sendRedirect("write.jsp");
	//	}
		
		/* js 전송용*/
		//response.getWriter().print(result);
		
	}


	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 첨부파일 [cos.jar 라이브러리 필요]
		// cos.jar로 MultipartRequest 쓸 수 있음.
		// HttpServletRequest : 첨부파일x 소량의 문자만 지원
		// 첨부파일이 있다면,, 첨부파일을 주소에 노출시키면 안되니 post 형식으로만 가능하다.
		
		// 저장경로 [ 프로젝트 ]
		String uploadpath = "C:\\Users\\504\\git\\ezen_web_2022_webapp\\jspweb1\\src\\main\\webapp\\upload";
		
		// 2. muti 객체 생성
		// MultipartRequest multi = new MultipartRequest( 1.요청방식 , 2.파일저장경로 , 3.최대용량범위 , 4.인코딩타입 , 5.기타 보안(필수x) );
		   MultipartRequest multi = new MultipartRequest(
				   request ,					 // 요청방식
				   uploadpath ,
				   1024 * 1024 * 10, 			 // [1024 : 1kb] [1024*1024 : 1mb] [1024*1024*1024 : 1G]
				   "UTF-8",					     // 인코딩
				   new DefaultFileRenamePolicy() // 업로드 된 파일의 이름이 중복일 경우 자동으로 이름 지정
				   );
		// 3. g해당 저장경로에 첨부파일 업로드가 된다.
		   
		// 4. 나머지 데이터 직접 요청
		   String btitle 	= multi.getParameter("btitle");
		   String bcontent  = multi.getParameter("bcontent");
		   System.out.println(btitle);
		   System.out.println(bcontent);
		   String mid = (String)request.getSession().getAttribute("mid");		
		   int mno = MemberDao.getInstance().getMno(mid);
		   
		// * 어떤 파일을 업로드 했는지 db에 저장할 첨부파일된 경로/이름 호출
        // 이름 호출
		// getParameter 아님!!!!!
		   String bfile = multi.getFilesystemName("bfile");
		   System.out.println(bfile);
		   
		   boolean result = BoardDao.getInstance().write(btitle, bcontent, mno, bfile);
		   	
		   response.getWriter().print(result);
		
		
		
		
		
		
	}

}
