package model.dao;


import model.dto.boardDto;

public class bboardDao extends bDao{
	
	public boolean board( boardDto bdto) {
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

}
