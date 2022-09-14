package back2;

import java.sql.Connection;				// db 드라이버 클래스 [ 드라이버 데이터 ]
import java.sql.DriverManager;			// db 연동 인터페이스
import java.sql.PreparedStatement;		// sql 조작 인터페이스
import java.sql.ResultSet;				// sql 결과 조작 인터페이스

import com.mysql.cj.xdevapi.Result;

public class JDBC실행 {
	public static void main(String[] args) {
		// JDBC : 자바와 DB 연동
			// 1. 라이브러리 필요! [ mysql-connector-java-8.0.30.jar ]
				// 미리 만들어진 라이브러리
			// 2. 해당 프로젝트 라이브러리 추가
				// 1) 프로젝트 오른쪽 클릭 >>> build path >>> configure build path >>> 라이브러리 탭 >>> add external Jars >>> 나의 라이브러리 추가 >>> apply (jar파일 경로가 옮겨지면 경로를 재설정 해야함)
			// 3. 미리 만들어진 JDBC 관련된 클래스를 사용할 수 있다.
				// 1) Connection : 인터페이스
				// 2) DreverManager : 클래스
				// 3) .getConnection : 메소드
			
			// MYSQL 연동할 때, 해당 클래스에서 예외(오류 발생)
			// *연동 실패 햇을 경우 그에 대한 대처코드를 안했기 때문
			// 해결방안 : 예외처리[ try ~ catch ]
			// >>> 만일 try 괄호 안에서 예외가 발생하면 catch로 코드흐름이 이동
			// >>> 예외가 없으면 try 괄호 실행
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); //mysql 드라이버 이름
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/shop_db3",
				"root",
				"1234");
		System.out.println("DB 연동 성공");
	/*
		// JDBC에서 SQL 조작
		// 1. 테이블에 데이터 추가
			// 1) sql 문법을 "" 감싸고 문자열 변수에 저장
			String sql = "insert into member values('tess' , '나훈아' , '경기 부천시 중동')";
			// 2) sql 조작 인터페이스
			PreparedStatement ps = con.prepareStatement(sql);
			// 3) sql 실행
			ps.executeUpdate();
			
		// 아이유 추가
		// 1.sql 문법 작성
			sql = "insert into member values('iyou' , '아이유' , '인천 남구 주안동')";
		// 2.sql 조작 인터페이스
			ps = con.prepareStatement(sql);
		// 3.sql 실행
			ps.executeUpdate();
			
		// 박진영 추가
		// 1.sql 문법 작성
			sql = "insert into member values('jyp' , '박진영' , '경기 고양시 장황동')";
		// 2.sql 조작 인터페이스
			ps = con.prepareStatement(sql);
		// 3.sql 실행
			ps.executeUpdate();

		// 박진영 주소 변경
			sql = "update member set member_addr = '경기도 안산시 상록구' where memeber_id = 'jyp'";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		
		// 아이유 레코드 삭제
			sql = "delete from member where member_id='iyou'";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
	*/	
		// 모든 멤버 호출
			String sql = "select * from member";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); //쿼리[SQL 결과]
				//결과가 레코드[행] 여러개 존재하기 때문
				//반복문 이용한 레코드 하나씩 출력
					//null >> 검색레코드1 >> 검색레코드2
					//.next() : 다음 레코드 호출 [ 다음 레코드가 있으면 true 없으면 false ]
					//.getString(필드순서번호 *세로) : 해당 필드의 데이터를 문자열로 가져오기
					//.getInt(필드순서번호)			: 해당 필드의 데이터를 정수형을 가져오기
			while( rs.next() ) {
				System.out.println("회원아이디 : " + rs.getString(1) + "\t" );	// 첫번째 필드의 데이터 가져오기 member_id
				System.out.println("회원명 : " + rs.getString(2) + "\t");		// 두번째 필드의 데이터 가져오기 member_name
				System.out.println("회원주소 : " + rs.getString(3) + "\n");	// 세번째 필드의 데이터 가져오기 member_addr
			}
		
			
	} catch ( Exception e ) {System.out.println("연동 실패 : " + e);}
	}
}














