package ch11String;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;


public class EX4DAO {
	
	private Connection con;									// db연동 인터페이스
	private PreparedStatement ps;							// sql연동/조작 인터페이스
	private ResultSet rs;									// sql결과[쿼리] 조작 인터페이스
	private static EX4DAO dao = new EX4DAO();				// 싱글톤
	static EX4DAO getInstance() {return dao;}	// 싱글톤을 외부로 호출시키는 메소드
	
	private EX4DAO() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cal",
					"root",
					"1234"
					);
			System.out.println("연동성공");
		} catch (Exception e) { System.out.println("경고) DB 연동 실패" + e );	}
	}
	
	
	boolean 일정추가( String cdate, String ccoment) {
		// -1 sql 작성
		String sql ="insert into calender values( null, ?, ?)";
		try {
			ps = con.prepareStatement(sql);	
			ps.setString(1 , cdate);		
			ps.setString(2 , ccoment);
			ps.executeUpdate();					
			return true;				
		} catch (Exception e) {System.out.println("경고) 메뉴추가 실패" + e );}
		return false;
	}
	
	HashMap< Integer, ArrayList<String> > 일정출력(){
		String sql = "select * from calender";
		HashMap< Integer, ArrayList<String> > map = new HashMap<>();
		try {
			ps = con.prepareStatement(sql);
			ps.executeQuery();
			while( rs.next() ) {
				// 레코드 -> 필드2 필드3 -> 리스트 담기
				ArrayList<String> values = new ArrayList<>();
				values.add(rs.getString(2) );
				values.add(rs.getString(3) );
				//pk 와 리스트 map 담기
				map.put(rs.getInt(1), values);
			}
			System.out.println(map.toString());
			return map;				
		} catch (Exception e) {System.out.println("경고) 일정출력 실패" + e );}
		return map;
	}
	
}
