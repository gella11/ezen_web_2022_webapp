package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.cj.xdevapi.JsonArray;

import model.dto.BoardDto;

public class BoardDao2  {
	
	private static BoardDao2 bbdao = new BoardDao2();
	public static BoardDao2 getInstance() {return bbdao;}
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public BoardDao2() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/jsptest", "root", "1234");
		} catch (Exception e) { System.out.println("DB오류:"+e);}
	}
	
	// 11	아파트실거래가 테이블 호출
		public JSONArray getapi() {
			JSONArray array = new JSONArray();
			String sql ="select * from 아파트매매실거래가 where 시군구 like '%경기도 안산%' ";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					JSONObject object = new JSONObject();
					object.put("시군구", 		rs.getString(1) );
					object.put("번지본번부번",  rs.getInt(2)+"/"+ rs.getString(3) +"/"+ rs.getString(4));
					object.put("단지명", 		rs.getString(5) );
					object.put("전용면적", 	rs.getString(6) );
					object.put("계약년월",		rs.getString(7) );
					object.put("계약일",		rs.getString(8) );
					object.put("계약금액", 	rs.getString(9) );
					object.put("층",		 	rs.getString(10) );
					object.put("건축년도", 	rs.getString(11) );
					object.put("도로명", 		rs.getString(12) );
					object.put("해체사유발생일",rs.getString(13) );
					object.put("거래유형", 	rs.getString(14) );
					object.put("중개사소재지",  rs.getString(15) );
					array.add(object);
				}
				System.out.println(array);
				return array;
			} catch (Exception e) {System.out.println(e);	}
			return array;
		}
		
		
		
		
}
