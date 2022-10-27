package controller.member.board;

import java.io.IOException;
import java.net.Inet4Address;
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
		// * 타입 : 1 [ 모든 제품 출력 ]  2 [ 개별 제품 출력 ] 

				// 공통 변수
				String type = request.getParameter("type");
				response.setCharacterEncoding("UTF-8");
		if( type.equals("1") ) {
			//////////////////////////////////////////// 모든 제품 출력 //////////////////////////
			ArrayList<ProductDto> list  = new ProductDao().getProductlist();// DAO 처리 
			JSONArray array = new JSONArray(); 	// LIST -> JSON
			for( int i = 0 ; i<list.size() ; i++ ) {
				JSONObject object  = new JSONObject();
				object.put("pno", list.get(i).getPno() );				
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
			response.getWriter().print(array);
			///////////////////////////////////////////////////////////////////////////////////

		}else if( type.equals("2") ) {
			////////////////////////////////////////////  개별 제품 출력 //////////////////////////
			// 1. 호출할 제품번호 요청 
			int pno = Integer.parseInt( request.getParameter("pno") ) ;
			// 2. db처리 
			ProductDto dto = new ProductDao().getpProduct( pno );
			// 3. dto -> json 형변환 [ 로직 ] 
				JSONObject object  = new JSONObject();
				object.put("pno", dto.getPno() );				
				object.put("pname", dto.getPname() );
				object.put("pcomment", dto.getPcomment() );		
				object.put("pprice", dto.getPprice() );
				object.put("pdiscount", dto.getPdiscount() );	
				object.put("pactive",dto.getPactive() );
				object.put("pimg", dto.getPimg() );				
				object.put("pdate", dto.getPdate() );
				object.put("pcno", dto.getPcno() );	
			// 4. 응답 
			response.getWriter().print(object);
			///////////////////////////////////////////////////////////////////////////////////
		}
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
	
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 첨부파일이 있을경우 [ 업로드 용 ] */
		MultipartRequest multi = new MultipartRequest(
				request, 
				request.getSession().getServletContext().getRealPath("/admin/pimg") , 
				1024*1024*10,
				"UTF-8", 
				new DefaultFileRenamePolicy() );

		int pno = Integer.parseInt( multi.getParameter("pno") );	// 수정할 대상 
		byte pactive = Byte.parseByte(multi.getParameter("pactive"));
		String pname = multi.getParameter("pname");			
		String pcomment = multi.getParameter("pcomment");	
		int pprice = Integer.parseInt( multi.getParameter("pprice") ) ;		
		float pdiscount = Float.parseFloat( multi.getParameter("pdiscount") );
		String pimg = multi.getFilesystemName("pimg"); 
		
		
		
		ProductDto dto = new ProductDto( 
				pno , pname, 
				pcomment,pprice, 
				pdiscount, pactive ,
				pimg, null, 0 );

		System.out.println( "수정할 dto : "+ dto.toString() );
		
		boolean result = new ProductDao().ProductUpdate(dto);
		response.getWriter().print(result);
		
	}
	
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("통신왓슈");
		System.out.println("pno 변수 : " + request.getParameter("pno"));
		
		// 삭제할 제품번호 요청
		int pno = Integer.parseInt(request.getParameter("pno"));
		// 2. dao
		boolean result = new ProductDao().deleteproduct(pno);
		// 응답
		response.getWriter().print(result);
		
		
		
		
	}

}















