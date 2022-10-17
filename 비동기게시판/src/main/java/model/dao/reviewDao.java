package model.dao;

public class reviewDao extends Dao{
	
	public boolean review(   String cname, String ccontent,String cpassword) {
		String sql = "insert into comment(cname,ccontent,cpassword) values(?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cname );
			ps.setString(2, ccontent );
			ps.setString(3, cpassword );
			ps.executeUpdate();
			return true;
		} catch (Exception e) {	System.out.println(e); }
		return false;
	}
}
