package 키오스크.관리자;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminDAO {

		// 1 필드
		private Connection con;							// db연동 인터페이스
		private PreparedStatement ps;					// sql연동/조작 인터페이스
		private ResultSet rs;							// sql결과[쿼리] 조작 인터페이스
		private static AdminDAO adao = new AdminDAO();	// 싱글톤 DAO 객체 [1. 생성자를 private, 2.객체
		
		// 2 생성자
		private AdminDAO() {
			try {
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/mmth",
						"root",
						"1234"
						);
				System.out.println("연동성공");
			} catch (Exception e) { System.out.println("경고) DB 연동 실패" + e );	}
		}
		// 3 메소드
			// 1) 외부에서 싱글톤 객체를 반환하는 메소드 [ getInstance
		public static AdminDAO getInstance() {return adao;}// 4 기능추가
			// 1) 메뉴 추가 [ 인수(메뉴이름) : 반환(성공/실패) ]
		boolean inMenu( String menuname) {
			// -1 sql 작성
			String sql ="insert into menu values( null, ?)";
			try {
				ps = con.prepareStatement(sql);	// -2 sql 연결조작
				ps.setString(1 , menuname);		// ? : 첫번째 ?에 대입
				ps.execute();					// sql 실행
				return true;					// 성공하면 true
			} catch (Exception e) {System.out.println("경고) 메뉴추가 실패" + e );}
			return false;
		}
		// 2) 메뉴 호출
		ArrayList<MenuDTO> getMenu() {
			ArrayList<MenuDTO> list = new ArrayList<>();
			String sql = "select * from menu";
			try {
				ps = con.prepareStatement(sql);	
				rs = ps.executeQuery();			
				while(rs.next()) {
					MenuDTO menu = new MenuDTO(
							rs.getInt(1), rs.getString(2)
							);
					//현재 검색된 현재 레코드의 필드 호출 : rs.get자료형(검색필드순번)
					list.add(menu);
				}
				return list;
			} catch (Exception e) {System.out.println("경고) 메뉴호출 실패" + e );}
			return list;
		}
		// 3) 제품 추가
		boolean inProduct(ProductDTO productDto) {
			String sql ="insert into product values(null, ?, ?, ?, ?, ?)";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1 , productDto.getPname());
				ps.setInt	(2 , productDto.getPprice());
				ps.setString(3 , productDto.getPcomment());
				ps.setShort	(4 , productDto.getPamount());
				ps.setByte	(5 , productDto.getMno());
				ps.executeUpdate();
				return true;
		}catch (Exception e) {System.out.println("경고) 제품추가 실패" + e );}
			return false;
		}	
		
			// 4) 주문 확인
		
}









