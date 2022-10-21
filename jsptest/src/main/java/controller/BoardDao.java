package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class BoardDao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/jsptest", "root", "1234");
		} catch (Exception e) { System.out.println("DB오류:"+e);}
	}
	
	
	
	// 삽입
		public boolean write( String btitle, String bcontent, String bname, String bpassword) {
			String sql = "insert into board(btitle,bcontent,bname,bpassword,view) values(?,?,?,?,0)";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, btitle );
				ps.setString(2, bcontent );
				ps.setString(3, bname );
				ps.setString(4, bpassword );
				ps.executeUpdate();
				return true;
			} catch (Exception e) {	System.out.println(e); }
			return false;
		}
		
		
		// 리스트
		public ArrayList<BoardDto> boardlist(){
			ArrayList<BoardDto> list = new ArrayList<>();
			String sql = "select * from board";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					BoardDto dto = new BoardDto(
							rs.getInt( 1 ) ,
							rs.getString( 2 ) ,
							rs.getString( 3 ) ,
							rs.getString( 4 ) ,
							rs.getString( 5 ) ,
							rs.getString( 6 ) ,
							rs.getInt( 7 ) 						
							);
					list.add(dto);
				}
				return list;
			} catch (Exception e) {	System.out.println(e);	}
			return null;
		}
		
		
		
		
		// 3. 글 조회 
			public BoardDto getboard(int bno2) {
				String sql2="update board set view = view +1 where bno = ?;";
				try {
					ps = con.prepareStatement(sql2);
					ps.setInt(1 , bno2);
					ps.executeUpdate();
				} catch (Exception e) {System.out.println("조회수 업데이트 실패");
				}
				String sql ="select * from board where bno = ?";
				try {
					ps = con.prepareStatement(sql);
					ps.setInt(1 , bno2);
					rs = ps.executeQuery();
					if(rs.next()) {
						BoardDto dto = new BoardDto(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getInt(7)
								);
						
						return dto;
					}
				} catch (Exception e) {System.out.println(e);}
				return null;
			}
	
	
}
