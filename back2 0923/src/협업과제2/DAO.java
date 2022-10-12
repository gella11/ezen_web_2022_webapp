package 협업과제2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private static DAO dao= new DAO();
	
	public DAO() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1234");
		} catch (Exception e) {System.out.println("DB 실행오류" +e);}
	}
	public static DAO getInstance() {return dao;}
	
	// 계좌생성 후 DB 입력
	boolean signupDB(DTO dto) {
		String sql="insert into customer values(0,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPhone());
			ps.setString(3, dto.getLockpassword());
			ps.setString(4, dto.getAccount());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("계좌DB 입력 오류"+e);}
		return false;		
	}
	

	
	// 로그인
	String loginDB(String account) {
		String sql="select lockpassword from customer where account=? ";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, account);
			rs=ps.executeQuery();
			if(rs.next()) {
				String lockpassword=rs.getString(1);
				// System.out.println(lockpassword);
				return lockpassword;
			}
		} catch (Exception e) {System.out.println("로그인 DB 출력 오류"+e);}
		return null;
	}
	//계좌찾기
	String search(String name, String phone) {
		String sql="select account from customer where name=? and phone=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phone);
			rs=ps.executeQuery();
			if(rs.next()) {
				String account=rs.getString(1);
				// System.out.println(account);
				return account;
			}
		} catch (Exception e) {System.out.println("계좌찾기 DB 오류"+e);}
		return null;
	}
	
	
}//class end
