package ch10예외처리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {

	//필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private static Dao dao = new Dao();
	public static Dao getInStance() {return dao;}
	//생성자
	private Dao() {
		try {
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/Insurance_DB",
				"root",
				"1234");
		}catch (Exception e) {System.out.println(e);}
	}
	
	//메소드
	public void signup() throws SQLException {
		String sql="";
		ps = con.prepareStatement(sql); // 예외 처리 던지기. 누가 처리하느냐
		ps.executeUpdate();
	}
	public void login() throws SQLException {
		String sql="";
		ps = con.prepareStatement(sql); // 예외 처리 던지기. 누가 처리하느냐
		ps.executeQuery();	
	}
	
}
