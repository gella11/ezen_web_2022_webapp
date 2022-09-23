package DATABASE.ch3기본문법;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	
	// 1. 필드
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	
	
	
	
	
	
	
	// 2. 생성자 : 객체 생성시 초기값
	public DAO() {
		// 빈생성자에 DB 접속 코드는 ( 객체 생성시 자동으로 DB 접속 )
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/market_db",
					"root",
					"1234"
					);
		} catch (Exception e) { System.out.println("경고) DB 연동 실패" + e );	}
	}
	
	
	
	
	
	
	
	
	// 3. 메소드
		// 예제1) 레코드 10줄 -> memberDto 8개 -> 배열/리스트 사용
		// 예제1) 레코드 10줄 -> memberDto 8개 -> 배열/리스트 사용
		// 예제1) 레코드 10줄 -> memberDto 8개 -> 배열/리스트 사용
		public ArrayList<MemberDto> 예제1결과() {
				// 위의 ArrayList<MemberDto> 반환타입
			
			// 배열(array) 대신에 배열을 편하게 사용할 수 있는 미리 만들어진 클래스 [컬렉션(수집) 프레임워크 ]
			// 리스트 선언 		 : ArrayList<리스트에 들어갈 클래스명> 리스트명 = new ArrayList<>();
			// 리스트에 객체 담기 : 리스트명.add(객체명)
			
			ArrayList<MemberDto> list = new ArrayList<>();
			// 위의 ArrayList<MemberDto> 선언타입
			// MemberDto 로 생성된 객체 여러개를 담을 수 있는 list 객체 선언
			
			
			// 1.sql 작성
			String sql = "select * from member";
			// 2.sql 연결조작
			try {
				ps = con.prepareStatement(sql);
				// 3.sql 결과조작
				rs = ps.executeQuery();
				while(rs.next()) {
					// 레코드 -> 객체화
					MemberDto dto = new MemberDto(
							rs.getString(1), rs.getString(2),
							rs.getInt(3), 	 rs.getString(4),
							rs.getString(5), rs.getString(6),
							rs.getShort(7),  rs.getString(8)
							);
					// 객체 -> 배열/리스트 담기
					list.add(dto);
				}
				return list;
			} catch (Exception e) {System.out.println( "예제1) 오류 ");}
			return list;
		} // 예제1결과 end
		
		// 예제2) 레코드 10줄 필드1 (필드가1개라 DTO를 만들지 판단, 이번에는 만듬)
		// 예제2) 레코드 10줄 필드1 (필드가1개라 DTO를 만들지 판단, 이번에는 만듬)
		// 예제2) 레코드 10줄 필드1 (필드가1개라 DTO를 만들지 판단, 이번에는 만듬)
		ArrayList<String> 예제2결과() {
			//DTO 생성자 안쓰고 함
			//String 객체 여러개를 저장할 수 있는 list 객체 선언
			ArrayList<String> list = new ArrayList<>();
			String sql = "select mem_name from member";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) { //rs.next() : 다음 레코드 이동
					list.add( rs.getString(1) );
				}
				return list;
			} catch (Exception e) {System.out.println( "예제2) 오류 ");}
			return list;		
			
		}// 예제2결과 end
		
		// 예제3) 레코드 1줄 필드8 >> 레코드가 1개면 굳이 리스트 안써도 된다.
		// 예제3) 레코드 1줄 필드8
		// 예제3) 레코드 1줄 필드8
		// 레코드 1개 		>>>	 	DTO 1개
		// 레코드 여러개 	>>> 	DTO 여러개
		ArrayList<MemberDto> 예제3결과() {
			ArrayList<MemberDto> list = new ArrayList<>();
			String sql = "select * from member where mem_name ='블랙핑크'";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					MemberDto dto = new MemberDto(
							rs.getString(1), rs.getString(2),
							rs.getInt(3), 	 rs.getString(4),
							rs.getString(5), rs.getString(6),
							rs.getShort(7),  rs.getString(8)
							);
					list.add(dto);
				}
				return list;
			} catch (Exception e) {System.out.println( "예제3) 오류 ");}
			return list;
		}
		
		// 예제3 강사님) 레코드 1줄 필드8
		// 예제3 강사님) 레코드 1줄 필드8
		// 예제3 강사님) 레코드 1줄 필드8
		//	void 예제3결과() {}
		//	아직 함수 결과가 없음
		//
		//MemberDto 예제3결과() {
		// return dto 의 자료형은 MemberDto
		//	String sql = "select * from member where mem_name ='블랙핑크'";
		//	try {
		//		ps = con.prepareStatement(sql);
		//		rs = ps.executeQuery();
		//		결과가 하나므로 반복문 필요 없음
		//		if (rs.next() ){
		//			MemberDto dto = new MemberDto(
		//					rs.getString(1), rs.getString(2),
		//					rs.getInt(3), 	 rs.getString(4),
		//					rs.getString(5), rs.getString(6),
		//					rs.getShort(7),  rs.getString(8)
		//					);
		//		return dto;
		//	} catch (Exception e) {System.out.println( "예제3) 오류 ");}
		//}return null;
		
		
		// 예제4) 레코드 3줄 필드 2
		// 예제4) 레코드 3줄 필드 2
		// 예제4) 레코드 3줄 필드 2
		ArrayList<MemberDto> 예제4결과() {
			ArrayList<MemberDto> list = new ArrayList<>();
			String sql = "select mem_id , mem_name from member where height <=162";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					MemberDto dto = new MemberDto(
							rs.getString(1), rs.getString(2)
							);
					list.add(dto);
				}
				return list;
			} catch (Exception e) {System.out.println( "예제4) 오류 ");}
			return list;
		}
		// 예제4 강사님) 레코드 3줄 필드 2
		// 예제4 강사님) 레코드 3줄 필드 2
		// 예제4 강사님) 레코드 3줄 필드 2
		//ArrayList<MemberDto> 예제4결과() {
		//	ArrayList<MemberDto> list = new ArrayList<>();
		//	String sql = "select mem_id , mem_name from member where height <=162";
		//	try {
		//		ps = con.prepareStatement(sql);
		//		rs = ps.executeQuery();
		//		while( rs.next() ) {
		//			MemberDto dto = new MemberDto(); 	//빈객체 선언
		//			dto.mem_id = rs.getString(1);
		//			dto.mem_name rs.getString(2);
		//			list.add(dto);						//객체 --> 리스트에 추가
		//		}
		//		return list;
		//	} catch (Exception e) {System.out.println( "예제4) 오류 ");}
		//	return list;
		//}
		
		
		// 예제5) 레코드 2줄 필드 3
		// 예제5) 레코드 2줄 필드 3
		// 예제5) 레코드 2줄 필드 3
		ArrayList<MemberDto> 예제5결과() {
			ArrayList<MemberDto> list = new ArrayList<>();
			String sql = "select mem_name , height , mem_number from member where height >= 165 and mem_number > 6";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					MemberDto dto = new MemberDto(
							rs.getString(1), rs.getShort(2),
							rs.getInt(3)
							);
					list.add(dto);
				}
				return list;
			} catch (Exception e) {System.out.println( "예제5) 오류 ");}
			return list;
		}
		// 예제6) 레코드 7줄 필드 3
		// 예제6) 레코드 7줄 필드 3
		// 예제6) 레코드 7줄 필드 3
		ArrayList<MemberDto> 예제6결과() {
			ArrayList<MemberDto> list = new ArrayList<>();
			String sql = "select mem_name , height , mem_number from member where height >= 165 or mem_number > 6";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					MemberDto dto = new MemberDto(
							rs.getString(1), rs.getShort(2),
							rs.getInt(3)
							);
					list.add(dto);
				}
				return list;
			} catch (Exception e) {System.out.println( "예제6) 오류 ");}
			return list;
		}
		// 예제7) 레코드 3줄  필드3
		// 예제7) 레코드 3줄  필드3
		// 예제7) 레코드 3줄  필드3
		ArrayList<MemberDto> 예제7결과() {
			ArrayList<MemberDto> list = new ArrayList<>();
			String sql = "select mem_name , height , mem_number from member where height between 163 and 165";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					MemberDto dto = new MemberDto(
							rs.getString(1), rs.getShort(2),
							rs.getInt(3)
							);
					list.add(dto);
				}
				return list;
			} catch (Exception e) {System.out.println( "예제7) 오류 ");}
			return list;
		}
		// 예제8) 레코드 1줄  필드8
		// 예제8) 레코드 1줄  필드8
		// 예제8) 레코드 1줄  필드8
		ArrayList<MemberDto> 예제8결과() {
		ArrayList<MemberDto> list = new ArrayList<>();
			String sql = "select * from member where mem_name like '우%'";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					MemberDto dto = new MemberDto(
							rs.getString(1), rs.getString(2),
							rs.getInt(3), 	 rs.getString(4),
							rs.getString(5), rs.getString(6),
							rs.getShort(7),  rs.getString(8)
							);
					list.add(dto);
				}
				return list;
			} catch (Exception e) {System.out.println( "예제8) 오류 ");}
			return list;
		}
		// 예제9) 레코드 1줄  필드8
		// 예제9) 레코드 1줄  필드8
		// 예제9) 레코드 1줄  필드8
		ArrayList<MemberDto> 예제9결과() {
			ArrayList<MemberDto> list = new ArrayList<>();
				String sql = "select * from member where mem_name like '__핑크%'";
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					while( rs.next() ) {
						MemberDto dto = new MemberDto(
								rs.getString(1), rs.getString(2),
								rs.getInt(3), 	 rs.getString(4),
								rs.getString(5), rs.getString(6),
								rs.getShort(7),  rs.getString(8)
								);
						list.add(dto);
					}
					return list;
				} catch (Exception e) {System.out.println( "예제9) 오류 ");}
				return list;
			}
		// 예제10) 레코드 10줄  필드3
		// 예제10) 레코드 10줄  필드3
		// 예제10) 레코드 10줄  필드3
		ArrayList<MemberDto> 예제10결과() {
			ArrayList<MemberDto> list = new ArrayList<>();
			String sql = "select mem_id , mem_name , debut_date from member order by debut_date desc";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					MemberDto dto = new MemberDto(
							rs.getString(1), rs.getString(2),
							rs.getString(3)
							);
					list.add(dto);
				}
				return list;
			} catch (Exception e) {System.out.println( "예제10) 오류 ");}
			return list;
		}
		// 예제11) 레코드 6줄  필드4
		// 예제11) 레코드 6줄  필드4
		// 예제11) 레코드 6줄  필드4
		ArrayList<MemberDto> 예제11결과() {
			ArrayList<MemberDto> list = new ArrayList<>();
			String sql = "select mem_id , mem_name , debut_date , height from member where height >= 164 order by height desc , debut_date asc";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					MemberDto dto = new MemberDto(
							 rs.getString(1), rs.getString(2),
							 rs.getString(3), rs.getShort(4)
							);
					list.add(dto);
				}
				return list;
			} catch (Exception e) {System.out.println( "예제11) 오류 ");}
			return list;
		}
		// 예제12) 레코드 2줄  필드2
		// 예제12) 레코드 2줄  필드2
		// 예제12) 레코드 2줄  필드2
		ArrayList<MemberDto> 예제12결과() {
			ArrayList<MemberDto> list = new ArrayList<>();
			String sql = "select mem_name , height from member order by height desc limit 3, 2";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					MemberDto dto = new MemberDto(
							rs.getString(1), rs.getString(2)
							);
					list.add(dto);
				}
				return list;
			} catch (Exception e) {System.out.println( "예제12) 오류 ");}
			return list;
		}
		// 예제13) 레코드 5줄  필드1
		// 예제13) 레코드 5줄  필드1
		// 예제13) 레코드 5줄  필드1
		ArrayList<MemberDto> 예제13결과() {
			ArrayList<MemberDto> list = new ArrayList<>();
			String sql = "select distinct addr from member";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					MemberDto dto = new MemberDto(
							rs.getString(1)
							);
					list.add(dto);
				}
				return list;
			} catch (Exception e) {System.out.println( "예제13) 오류 ");}
			return list;
		}
		// 예제14) 레코드 4줄  필드2
		// 예제14) 레코드 4줄  필드2
		// 예제14) 레코드 4줄  필드2
		ArrayList<buy> 예제14결과() {
			ArrayList<buy> list = new ArrayList<>();
			String sql = "select mem_id , sum(amount) as 수량합계 from buy group by mem_id";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					buy dto = new buy();
					dto.mem_id = rs.getString(1);
					dto.수량합계 = rs.getInt(2);
					list.add(dto);
				}
				return list;
			} catch (Exception e) {System.out.println( "예제14) 오류 ");}
			return list;
		}
		// 예제15) 레코드 4줄  필드2
		// 예제15) 레코드 4줄  필드2
		// 예제15) 레코드 4줄  필드2
		ArrayList<buy> 예제15결과() {
			ArrayList<buy> list = new ArrayList<>();
			String sql = "select mem_id as 회원_아이디 , sum( price*amount )  as 총_구매금액 from buy group by mem_id";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					buy dto = new buy();
					dto.mem_id = rs.getString(1);
					dto.총구매금액 = rs.getInt(2);
					list.add(dto);
				}
				return list;
			} catch (Exception e) {System.out.println( "예제15) 오류 ");}
			return list;
		}
		// 예제16) 레코드 4줄  필드2
		// 예제16) 레코드 4줄  필드2
		// 예제16) 레코드 4줄  필드2
		ArrayList<buy> 예제16결과() {
			ArrayList<buy> list = new ArrayList<>();
			String sql = "select mem_id , avg( amount ) as 수량평균 from buy group by mem_id";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					buy dto = new buy();
					dto.mem_id = rs.getString(1);
					dto.수량평균 = rs.getInt(2);
					list.add(dto);
				}
				return list;
			} catch (Exception e) {System.out.println( "예제16) 오류 ");}
			return list;
		}
		// 예제17) 레코드 10줄  필드2
		// 예제17) 레코드 10줄  필드2
		// 예제17) 레코드 10줄  필드2
		ArrayList<MemberDto> 예제17결과() {
			ArrayList<MemberDto> list = new ArrayList<>();
			String sql = "select mem_id , count( phone1 ) as 연락처 from member group by mem_id";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					MemberDto dto = new MemberDto(sql);
					dto.mem_id = rs.getString(1);
					dto.phone1 = rs.getString(2);
					list.add(dto);
				}
				return list;
			} catch (Exception e) {System.out.println( "예제17) 오류 ");}
			return list;
		}
		// 예제18) 레코드 4줄  필드2
		// 예제18) 레코드 4줄  필드2
		// 예제18) 레코드 4줄  필드2
		ArrayList<MemberDto> 예제18결과() {
			ArrayList<MemberDto> list = new ArrayList<>();
			String sql = "select mem_id , count( * ) as 회원수 from member group by mem_id";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					MemberDto dto = new MemberDto();
					dto.mem_id = rs.getString(1);
					dto.회원수 = rs.getInt(2);
					list.add(dto);
				}
				return list;
			} catch (Exception e) {System.out.println( "예제18) 오류 ");}
			return list;
		}
		// 예제19) 레코드 2줄  필드2
		// 예제19) 레코드 2줄  필드2
		// 예제19) 레코드 2줄  필드2
		ArrayList<buy> 예제19결과() {
			ArrayList<buy> list = new ArrayList<>();
			String sql = "select mem_id as 회원아이디 , sum( price * amount ) as 총구매금액\r\n"
					+ "    from buy\r\n"
					+ "    group by mem_id\r\n"
					+ "	having sum( price * amount ) > 1000\r\n"
					+ "    order by 총구매금액 desc;";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					buy dto = new buy();
					dto.mem_id = rs.getString(1);
					dto.총구매금액 = rs.getInt(2);
					list.add(dto);
				}
				return list;
			} catch (Exception e) {System.out.println( "예제19) 오류 ");}
			return list;
		}
}
























