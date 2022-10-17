package model.dao;

import java.util.ArrayList;

import model.dto.BoardDto;

public class BoardDao extends Dao {
	
	private static BoardDao bdao = new BoardDao();
	public static BoardDao getInstance() {return bdao;}
	
	// 1. 글 등록
	public boolean write(String btitle, String bcontent, int mno ,String bfile) {
		String sql="insert into board(btitle,bcontent,mno,bfile)"
				+"value(?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, btitle );
			ps.setString(2, bcontent );
			ps.setInt(3, mno );
			ps.setString(4, bfile );
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
				
	}

	// 2. 글 출력 [ JSP 용 ]
	public ArrayList<BoardDto> getlist() {
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "select b.* , m.mid from member m , board b where m.mno = b.mno;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto dto = new BoardDto(
						rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6),
						rs.getInt(7), rs.getInt(8),
						rs.getString(9)
						);
					list.add(dto);
					
			}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	// 3. 글 조회 
	public BoardDto getboard(int bno) {
		String sql ="select b.* , m.mid from member m , board b where m.mno = b.mno and bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1 , bno);
			rs = ps.executeQuery();
			if(rs.next()) {
				BoardDto dto = new BoardDto(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getString(9)
						);
				return dto;
			}
		} catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	
	public boolean delete(int bno) {
		String sql = "delete from board where bno="+bno+"; ";
		try {
			ps = con.prepareStatement(sql);
			int count = ps.executeUpdate();
			if(count == 1)
				return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	
	
	
	
	
	
	
}