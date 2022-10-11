package model.dao;

import java.util.ArrayList;

import model.dto.MemberDto;

public class MemberDao extends Dao {
	
	// 싱글톤
	private static MemberDao mdao = new MemberDao();
	public static MemberDao getInstance() {return mdao;}
	
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
	
	// 로그인
	public int login( String mid, String mpassowrd) {
		String sql = "select * from member where mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid );
			rs = ps.executeQuery();
			if(rs.next()){
				sql = "select * from member where mid = ? and mpassword = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, rs.getString(2) );
				ps.setString(2, mpassowrd );
				rs = ps.executeQuery();
				if(rs.next()) {
					return 1; // 로그인 성공 
				}else {
					return 2; // 패스워드 틀림
				}
			}
		} catch (Exception e) {	System.out.println(e); return 3;//데이터베이스 오류}
		
	}
		return 0;//아이디 없음
	}
	
	// 3. 아이디 찾기
	public String findid(String mname, String memail) {
		String sql = "select * from member where mname = ? and memail = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mname);
			ps.setString(2, memail);
			rs = ps.executeQuery();
			// 만일 동일한 정보가 있으면 찾은 레코드의 값 리턴
			if(rs.next()) return rs.getString(2); 
		} catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	// 4. 비밀번호 찾기 [ 임시 비밀번호 발급 ]
	public boolean findpassword(String mid, String memail) {
		String sql = "select * from member where mid = ? and memail = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, memail);
			rs = ps.executeQuery();
			// 만일 동일한 정보가 있으면 찾은 레코드의 값 리턴
			if(rs.next()) return true;//rs.getString(3); 
		} catch (Exception e) {System.out.println(e);}
		return false; //null;
	}
	
	// 5. 임시 비밀번호 적용
	public boolean passwordchange(String mid, String randstr) {
		String sql ="update member set mpassword = ? where mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, randstr);
			ps.setString(2, mid);
			ps.executeUpdate();
			if(rs.next()) return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 6. 회원정보 호출
		public MemberDto getinfo(String mid) {
			MemberDto dto = null;
			String sql = "select * from member where mid = ? ;";
			try {
				ps = con.prepareStatement(sql);
				ps.setString( 1 , mid );
				ps.executeQuery();
				if(rs.next()) {
					dto = new MemberDto(
							rs.getInt( 1 ) , rs.getString( 2 ) , null ,
							rs.getString( 4 ), rs.getString( 5 ) ,
							rs.getString( 6 ), rs.getString( 7 ), 
							rs.getString( 8 ) , rs.getInt( 9 ) 
							);
				//dto = new MemberDto(
					//		rs.getInt(1),
					//		rs.getString(2),
					//		null,
					//		rs.getString(4),
					//		rs.getString(5),
					//		rs.getString(6),
					//		rs.getString(8),
					//		rs.getInt(9), 0
					//		);
					//dto = new MemberDto();
					//dto.setMno(rs.getInt(1));
					//dto.setMid(rs.getString(2));
					//dto.setMname(rs.getString(4));
					//dto.setMphone(rs.getString(5));
					//dto.setMemail(rs.getString(6));
				//	dto.setMaddress(rs.getString(7));
				//	dto.setMdate(rs.getString(8));
				//	dto.setMpint(rs.getInt(9));
					return dto;
				}
			} catch (Exception e) {System.out.println(e);	}
			return dto;
		}
		
		
		public ArrayList<MemberDto> getinfolist(){
			ArrayList<MemberDto> list = new ArrayList<>();
			String sql = "select * from member; ";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					MemberDto dto = new MemberDto(
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
		
		//8. 회원탈퇴		
		public boolean delete(String mid, String mpassword) {
			String sql = "delete from member where mid = ? and mpassword = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, mid);
				ps.setString(2, mpassword);
				System.out.println(mid);
				System.out.println(mpassword);
				int count = ps.executeUpdate();
				if(count == 1) {
					return true;
					}				
			} catch (Exception e) { System.out.println(e);}
			return false;
		}
		
		
		
		
		
		
		
}