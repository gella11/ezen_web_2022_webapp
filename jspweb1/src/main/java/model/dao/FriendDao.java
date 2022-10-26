package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import controller.member.signup;
import model.dto.BoardDto;
import model.dto.MemberDto;

public class FriendDao {
	
	private static FriendDao fdao =new FriendDao();
	public static FriendDao getInstacnDao() {return fdao;}
	
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public FriendDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/cacao", "root", "1234");
		} catch (Exception e) { System.out.println("DB오류:"+e);}
	}
	
	
	
	// 상진
	// 1. 이메일 세션으로 나의 회원번호 출력
	public int user_num(String my_num) {
		String sql ="select (user_num) from user where user_email = ?";
		int user_num = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1 , my_num);
			rs = ps.executeQuery();
			
			if(rs.next()) { user_num = rs.getInt(1); }
			
				return user_num;
			}catch (Exception e) {System.out.println(e);}
		return -1;
		} 
		
	
	
	// 상진  
	// 친구목록
	// 2-1) 내 친구 회원번호 출력 
	public ArrayList<F_list_Dto> getinfolist(int my_num){
		ArrayList<F_list_Dto> list = new ArrayList<>();
		String sql = "select friend_num from friend where 회원번호 = "+my_num+"; ";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				F_list_Dto dto = new F_list_Dto(
						rs.getInt( 1 ) , rs.getString( 2 ) , null ,
						rs.getString( 4 ), rs.getString( 5 ) ,
						rs.getString( 6 ), rs.getString( 7 ), 
						rs.getString( 8 ) , rs.getInt( 9 ) 
						);
				list.add(dto);
			}
			return list;
		} catch (Exception e) {	System.out.println(e);	}
		return list;
	}
	
	// 상진
	// 친구목록
	// 2-2) 회원번호로 이름 프로필 빼오기 
	public ArrayList<friend_num> f_list_info( int friend_num ){
		ArrayList<friend_num> friend_num = new ArrayList<>();
		
		for(int i = 0; i<=friend_num.length; i++) {
		
			String sql = "select (user_num, user_name, user_profile) from user where 회원번호 = ? ;";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1 , friend_num.get(i).getUser_num);
				rs = ps.executeQuery();
				while(rs.next()){
					signupUp_Dto dto = new signupUp_Dto(
							rs.getInt( 1 ) , rs.getString( 2 ) , null ,
							rs.getString( 4 ), rs.getString( 5 ) ,
							rs.getString( 6 ), rs.getString( 7 ), 
							rs.getString( 8 ) , rs.getInt( 9 ) 
							);
					friend_num.add(dto);
				}
				
			} catch (Exception e) {	System.out.println(e);	 return list; }
		}
		return user_num_list;
	}
	
	
	
	
	
	
	
	
	
}
