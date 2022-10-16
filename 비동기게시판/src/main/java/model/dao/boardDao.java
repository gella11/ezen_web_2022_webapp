package model.dao;


import java.util.ArrayList;


import model.dto.boardDto1;

public class boardDao extends Dao{
	
	public boolean board( boardDto1 bdto) {
		String sql = "insert into board(btitle,bcontent,bname,bpassword,view) values(?,?,?,?,0)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bdto.getBtitle() );
			ps.setString(2, bdto.getBcontent() );
			ps.setString(3, bdto.getBname() );
			ps.setString(4, bdto.getBpassword() );
			ps.executeUpdate();
			return true;
		} catch (Exception e) {	System.out.println(e);}
		return false;
	}
	
	//답글
	public boolean review( boardDto1 bdto) {
		String sql = "insert into board(btitle,bcontent,bname,bpassword,view) values(?,?,?,?,0)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bdto.getBtitle() );
			ps.setString(2, bdto.getBcontent() );
			ps.setString(3, bdto.getBname() );
			ps.setString(4, bdto.getBpassword() );
			ps.executeUpdate();
			return true;
		} catch (Exception e) {	System.out.println(e);}
		return false;
	}
	
	// 리스트
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
		return null;
	}

	// 3. 글 조회 
		public boardDto1 getboard(int bno) {
			String sql2="update board set view = view +1 where bno = ?;";
			try {
				ps = con.prepareStatement(sql2);
				ps.setInt(1 , bno);
				ps.executeUpdate();
			} catch (Exception e) {System.out.println("조회수 업데이트 실패");
			}
			String sql ="select * from board where bno = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1 , bno);
				rs = ps.executeQuery();
				System.out.println("dao");
				if(rs.next()) {
					boardDto1 dto = new boardDto1(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getInt(7)
							);
					System.out.println(dto);
					return dto;
					
				}
			} catch (Exception e) {System.out.println(e);}
			return null;
		}


	
	
	
}
