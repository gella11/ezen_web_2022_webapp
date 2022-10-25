package controller.member.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dto.ProductDto;


@WebServlet("/regist")
public class regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public regist() {super();  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 첨부파일 있을 경우에만 
		MultipartRequest multi = new MultipartRequest(
				request,
				request.getSession().getServletContext().getRealPath("/admin/pimg"),
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		String pname = multi.getParameter("pname");			
		String pcomment = multi.getParameter("pcomment");	
		int pprice = Integer.parseInt( multi.getParameter("pprice") ) ;		
		float pdiscount = Float.parseFloat( multi.getParameter("pdiscount") );
		String pimg = multi.getFilesystemName("pimg"); 

		ProductDto dto = new ProductDto( 0 , pname, pcomment, pprice, pdiscount, (byte) 0 , pimg, null, 0 );
		System.out.println( dto.toString() ); // dto 확인용
		
	}

}















