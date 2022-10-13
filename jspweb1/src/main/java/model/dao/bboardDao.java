package model.dao;


import java.util.ArrayList;

import model.dto.MemberDto;
import model.dto.boardDto1;

public class bboardDao extends bDao{
	
	public boolean board( boardDto1 bdto) {
		String sql = "insert into board(btitle,bcontent,bname,bpassword) values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bdto.getTitle() );
			ps.setString(2, bdto.getContent() );
			ps.setString(3, bdto.getBname() );
			ps.setString(4, bdto.getBpassword() );
			ps.executeUpdate();
			return true;
		} catch (Exception e) {	System.out.println(e);}
		return false;
	}
	
	public ArrayList<boardDto1> boardlist(){
		ArrayList<boardDto1> list = new ArrayList<>();
		String sql = "select * from board; ";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				boardDto1 dto = new boardDto1(
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
		return list;
	}




	
	
	
}
