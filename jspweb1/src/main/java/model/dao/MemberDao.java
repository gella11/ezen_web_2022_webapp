package model.dao;

import model.dto.MemberDto;

public class MemberDao extends Dao {
	
	// 싱글톤
	//private static MemberDao mdao = new MemberDao();
	//public static MemberDao getInstance() {return mado;}
	
	// 기능 메소드 구현
	// 1. 회원가입 메소드
	public boolean signup( MemberDto dto) {
		String sql = "insert into member(mid,mpassword,mname,mphone,memail,maddress) values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMid() );
			ps.setString(2, dto.getMpassword() );
			ps.setString(3, dto.getMname() );
			ps.setString(4, dto.getMphone() );
			ps.setString(5, dto.getMemail() );
			ps.setString(6, dto.getMaddress() );
			ps.executeUpdate();
			return true;
		} catch (Exception e) {	System.out.println(e);}
		return false;
	}
	
	public boolean login( String mid, String mpassowrd) {
		String sql = "select * from member where mid = ? and where mpassword = ?";;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid );
			ps.setString(2, mpassowrd );			
			ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (Exception e) {	System.out.println(e);}
		return false;
	}
	
}
