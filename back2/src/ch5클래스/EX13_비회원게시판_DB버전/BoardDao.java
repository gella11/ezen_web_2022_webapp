package ch5클래스.EX13_비회원게시판_DB버전;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDao {
	
	// 1. 필드
	// 1. 필드
	// 1. 필드
	// JDBC 자주 사용하는 클래스/인터페이스
	Connection con; 		// DB 접속할 수 있는 인터페이스
		// con = DriverManager.getConnection("db주소" , "db계정명" , "db비밀번호")
				// MYSQL 연동할 때, 해당 클래스에서 예외(오류 발생)
				// *연동 실패 햇을 경우 그에 대한 대처코드를 안했기 때문
				// 해결방안 : 예외처리[ try ~ catch ]
				// >>> 만일 try 괄호 안에서 예외가 발생하면 catch로 코드흐름이 이동
				// >>> 예외가 없으면 try 괄호 실행 
	PreparedStatement ps; 	// 접속된 DB를 SQL 연결 조작하는 인터페이스 [Connection과 같이 써야함]
	ResultSet rs;			// SQL 결과를 조작하는 인터페이스
	
	
	// 2. 생성자
	// 2. 생성자
	// 2. 생성자
	public BoardDao() {
		// 빈생성자에 DB 접속 코드는 ( 객체 생성시 자동으로 DB 접속 )
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/boardtest",
					"root",
					"1234"
					);
		} catch (Exception e) { System.out.println("경고) DB 연동 실패" + e );	}
	}
	
	
	
	// 3. 메소드
	// 3. 메소드
	// 3. 메소드
	
		// 1) 등록 메소드
		// 1) 등록 메소드
		// 1) 등록 메소드
			boolean regist( BoardDto boardDto) {
				// sql 코드 들어갈 예정
				// 1. sql 작성
				// 2. sql 연결조작
				// 3. sql 결과
				String sql = "insert"
								+" into board( b_title , b_content , b_writer , b_password , b_view )"
								+"values    ( ?, ?, ?, ?, ? )";
							//  ? : 변수 들어갈 자리[ 와읻르카드 ]
				try {
					ps = con.prepareStatement(sql);
						// ? 에 변수 넣기
						ps.setString(1, boardDto.b_title);			// 1번째 ?에 b_title 		넣기
						ps.setString(2, boardDto.b_content);		// 2번째 ?에 b_content 	넣기
						ps.setString(3, boardDto.b_writer);			// 3번째 ?에 b_writer 	넣기
						ps.setString(4, boardDto.b_password);		// 4번째 ?에 b_password	넣기
						ps.setInt(5, 0);							// 5번째 ?에 b_view 		넣기
					ps.executeUpdate();
					return true;
				} catch (Exception e) {System.out.println("경고) DB오류 : " + e);}
				return false;
			}
			
			
// * 전체 게시물 수 메소드
// 배열의 길이만 큼 배열을 만든다..
	int getrows() {
		// 1. sql 작성
		// 2. sql 연결조작
		// 3. sql 결과
		String sql = "select count(*) from board";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) { return rs.getInt(1);}	//rs.next() 행을 하나씩 읽고 내려감 행이 없으면 끝
		}catch (Exception e) {System.out.println("경고) DB오류 :" + e);}
		
		return 0;	// 없으면 0
	}
			
			
		// 2) 모든 게시물 출력 메소드
		// 2) 모든 게시물 출력 메소드
		// 2) 모든 게시물 출력 메소드
			BoardDto[] getBoardlist() {
				int rowcount = getrows(); // 게시물 수 함수 호출 >>> 반환 count 저장
				BoardDto[] boardlist = new BoardDto[rowcount];
				// 1. sql 작성
				// 2. sql 연결조작
				// 3. sql 결과
				String sql = "select * from board";
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					int row = 0 ; //배열의 인덱스를 대체할 변수 선운
					// ResultSet rs : 쿼리[sql결과]에 조작
					// rs >>> null --.next() >>> 검색된레코드[행] >>> --.next() >>> 다음레코드[행]
					while(rs.next()) {
						// 레코드 한개당 6개의 필드 >>> 6개 변수 >>> 객채 >>> 배열에 담아야지
						int b_no 			= rs.getInt(1); // 해당 레코드의 첫번째 필드의 데이터 호출
						String b_title 		= rs.getString(2);
						String b_content 	= rs.getString(3);
						String b_writer 	= rs.getString(4);
						String b_password 	= rs.getString(5);
						int b_view 			= rs.getInt(6);
						BoardDto board = new BoardDto(b_no ,b_title , b_content , b_writer , b_password , b_view);
						// 위와 같음 BoardDto board = new BoardDto(rs.getInt(1) ,rs.getString(2) , rs.getString(3) ,  rs.getString(4) , rs.getString(5) , rs.getInt(6));
						boardlist[row] = board;
						row++;
					}
				} catch (Exception e) {System.out.println("경고) DB오류 : " + e);}
				
				
				return boardlist;
			}
			
		// 3) 개별 게시물 출력 메소드
		// 3) 개별 게시물 출력 메소드
		// 3) 개별 게시물 출력 메소드
			BoardDto getBoard( int b_no) {
				// 1. sql 작성
				// 2. sql 연결조작
				// 3. sql 결과
				BoardDto board = null;
				String sql = "select * from board where b_no = ?";
				try {
					ps = con.prepareStatement(sql);
					ps.setInt( 1, b_no );
					rs = ps.executeQuery();
					if( rs.next() ) {
						board = new BoardDto( 
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getInt(6)
								);
					}
				} catch (Exception e) {	System.out.println("경고) DB오류 : " + e);}
				
				return board;
			}
		// 4) 수정 처리 메소드
		// 4) 수정 처리 메소드
		// 4) 수정 처리 메소드
			boolean update( int b_no , String b_password , String new_title , String new_content) {
				// sql 코드 들어갈 예정
				return false;
			}
		// 5) 삭제 처리 메소드
		// 5) 삭제 처리 메소드
		// 5) 삭제 처리 메소드
			boolean delete( int b_no , int b_password ) {
				return false;
			}
			
			
			
}


























