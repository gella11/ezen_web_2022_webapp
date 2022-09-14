package back2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC실행2 {
	public static void main(String[] args) {
		
		
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
				String sql = "insert into product values('바나나' , 1500 , '2021-07-01' , '델몬트' , 17 )";
				// 2) sql 조작 인터페이스
				PreparedStatement ps = con.prepareStatement(sql);
				// 3) sql 실행
				ps.executeUpdate();
				
				sql = "insert into product values('카스' , 2500 , '2022-03-01' , 'OB' , 3 )";
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				
				sql = "insert into product values('삼각김밥' , 800 , '2023-09-01' , 'CJ' , 22 )";
				ps = con.prepareStatement(sql);
				ps.executeUpdate();

				// 카스의 재고 수량을 10개로 수정
				sql = "update product set amount = '10' where product_name = '카스'";
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				
				// 삼각김밥 제거
				sql = "delete from product where product='삼각김밥'";
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
		*/		
				// 모든 제품의 정보를 콘솔에 출력
				String sql = "select * from product";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery(); //쿼리[SQL 결과]
					//결과가 레코드[행] 여러개 존재하기 때문
					//반복문 이용한 레코드 하나씩 출력
						//null >> 검색레코드1 >> 검색레코드2
						//.next() : 다음 레코드 호출 [ 다음 레코드가 있으면 true 없으면 false ]
						//.getString(필드순서번호 *세로) : 해당 필드의 데이터를 문자열로 가져오기
						//.getInt(필드순서번호)			: 해당 필드의 데이터를 정수형을 가져오기
				while( rs.next() ) {
					System.out.println("상품명 : "	+rs.getString(1) + "\t");	// 첫번째 필드의 데이터 가져오기 member_id
					System.out.println("가격 : "		+rs.getString(2) + "\t");		// 두번째 필드의 데이터 가져오기 member_name
					System.out.println("제조일 : "	+rs.getString(3) + "\t");		// 세번째 필드의 데이터 가져오기 member_addr
					System.out.println("제조사 : "	+rs.getString(4) + "\t");
					System.out.println("수량 : "		+rs.getString(5) + "\n");
				}
				
				
		} catch ( Exception e ) {System.out.println("연동 실패 : " + e);}
	}
}
