package model.dao;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.cj.xdevapi.JsonArray;

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
	public ArrayList<BoardDto> getlist(int startrow , int listsize, String key , String keyword) {
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql ="";
		if(!key.equals("") && !keyword.equals("")) {
			sql = "select b.* , m.mid from member m , board b where m.mno = b.mno and "+key+" like '%"+keyword+"%' order by b.bdate desc limit "+startrow+" , "+listsize+";";
		}else {
			sql = "select b.* , m.mid from member m , board b where m.mno = b.mno order by b.bdate desc limit "+startrow+" , "+listsize+";";
		}
		
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
	
	// 4. 글 삭제
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
	
	// 5. 첨부파일만 삭제 [업데이트]
	public boolean bfiledelete(int bno) {
		String sql = "update board set bfile = null where bno = "+bno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);	}
		return false;
	}
	
	// 6. 게시물 수정
	public boolean bupdate(int bno, String btitle, String bcontent, String bfile) {
		String sql = "update board set btitle = ?, bcontent = ?, bfile = ? where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setString(3, bfile);
			ps.setInt(4, bno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 7. 조회수 [업데이트]
		public boolean view(int bno) {
			String sql2="update board set bview = bview +1 where bno = ?;";
			try {
				ps = con.prepareStatement(sql2);
				ps.setInt(1 , bno);
				ps.executeUpdate();
				return true;
			} catch (Exception e) {System.out.println("조회수 업데이트 실패");}
			return false;
		}
	
	// 8. 전체 페이지 수
		public int gettotal(String key, String keyword) {
			String sql ="";
			if(!key.equals("") && !keyword.equals("")) {
				// 검색이 있을 경우
				sql = "select count(*) from member m , board b where m.mno = b.mno and "+key+" like '%"+keyword+"%' ;" ;
			}else {
				// 검색이 없을 경우
				sql = "select count(*) from board;";
			}
			
			try {
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next())
					return rs.getInt(1);
				
			} catch (Exception e) {System.out.println(e);}
			return 0;
		}
	
	// 9. 댓글 등록
		public boolean rwrite(String rcontent, int mno, int bno ) {
			String sql="insert into reply(rcontent,mno,bno) value(?, ?, ?) ";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, rcontent );
				ps.setInt(2, mno );
				ps.setInt(3, bno );
				ps.executeUpdate();
				return true;
			} catch (Exception e) {System.out.println(e);}
			return false;
					
		}
	// 9-2. 댓글 등록
		public boolean rrwrite(String rcontent, int mno, int bno, int rindex ) {
			String sql="insert into reply(rcontent,mno,bno,rindex) value(?, ?, ?, ?) ";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, rcontent );
				ps.setInt(2, mno );
				ps.setInt(3, bno );
				ps.setInt(4, rindex );
				ps.executeUpdate();
				return true;
			} catch (Exception e) {System.out.println(e);}
			return false;
					
		}
	// 10. 댓글 리스트
		public JSONArray getrlist(int bno) {
			JSONArray array = new JSONArray();
			String sql = "select r.rcontent , r.rdate, m.mid , r.rno from reply r, member m where r.mno = m.mno and r.bno = "+bno+" and r.rindex = 0 order by r.rdate desc";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					JSONObject object = new JSONObject();
					object.put("rcontent", rs.getString(1) );
					object.put("rdate", rs.getString(2) );
					object.put("mid", rs.getString(3) );
					object.put("rno", rs.getString(4) );
					array.add(object);
				}
			} catch (Exception e) {System.out.println(e);}
			return array;
		} 
	
	// 10-2). 대댓글 리스트
		public JSONArray getrrlist(int bno, int rindex) {
			JSONArray array = new JSONArray();
			String sql = "select r.rcontent , r.rdate, m.mid , r.rno from reply r, member m where r.mno = m.mno and r.bno = "+bno+" and r.rindex = "+rindex+" order by r.rdate desc";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					JSONObject object = new JSONObject();
					object.put("rcontent", rs.getString(1) );
					object.put("rdate", rs.getString(2) );
					object.put("mid", rs.getString(3) );
					object.put("rno", rs.getString(4) );
					array.add(object);
				}
			} catch (Exception e) {System.out.println(e);}
			return array;
		}
}
