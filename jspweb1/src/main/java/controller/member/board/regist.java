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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.ProductDao;
import model.dto.ProductDto;


@WebServlet("/regist")
public class regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public regist() {super();  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		ArrayList<ProductDto> list  = new ProductDao().getProductlist();// DAO 처리 
		JSONArray array = new JSONArray(); 	// LIST -> JSON
		for( int i = 0 ; i<list.size() ; i++ ) {
			JSONObject object  = new JSONObject();
			object.put("pno", list.get(i).getPcno() );				
			object.put("pname", list.get(i).getPname() );
			object.put("pcomment", list.get(i).getPcomment() );		
			object.put("pprice", list.get(i).getPprice() );
			object.put("pdiscount", list.get(i).getPdiscount() );	
			object.put("pactive", list.get(i).getPactive() );
			object.put("pimg", list.get(i).getPimg() );				
			object.put("pdate", list.get(i).getPdate() );
			object.put("pcno", list.get(i).getPcno() );			
			array.add(object);
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 첨부파일이 있을경우 [ 업로드 용 ] */
		System.out.println("dha?");
		MultipartRequest multi = new MultipartRequest(
				request, 
				request.getSession().getServletContext().getRealPath("/admin/pimg") , 
				1024*1024*10,
				"UTF-8", 
				new DefaultFileRenamePolicy() );
		
		System.out.println("asdasdasd");
		
		String pname = multi.getParameter("pname");			
		String pcomment = multi.getParameter("pcomment");
		int pprice = Integer.parseInt( multi.getParameter("pprice") );
		float pdiscount = Float.parseFloat( multi.getParameter("pdiscount") );
		String pimg = multi.getFilesystemName("pimg"); 
		int pcno = Integer.parseInt( multi.getParameter("pcno") );
		
		System.out.println(pname);
		System.out.println(pcomment);
		System.out.println(pprice);
		System.out.println(pdiscount);
		System.out.println(pimg);
		System.out.println(pcno);
		
		ProductDto dto = new ProductDto( 0 , pname, pcomment, pprice, pdiscount, (byte) 0 , pimg, null, pcno );

		boolean result = new ProductDao().setproduct(dto);
		response.getWriter().print(result);
		
		
		
		
	}

}















