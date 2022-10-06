package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class bDao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public bDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/board", "root", "1234");
		} catch (Exception e) { System.out.println("DB오류:"+e);}
	}
}

