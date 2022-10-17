package model.dao;

public class reviewDao extends Dao{
	
	public boolean review( String btitle, int cno, int cindex, String cname, String ccontent, String cpassword) {
		String sql = "insert into comment(btitle,bcontent,bname,bpassword,view) values(?,?,?,?,0)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, btitle );
			ps.setString(2, bcontent );
			ps.setString(3, bname );
			ps.setString(4, bpassword );
			ps.executeUpdate();
			return true;
		} catch (Exception e) {	System.out.println(e); }
		return false;
	}
}
