package HOTEL.model.Dao;

public class MemberDao {

	private static MemberDao Mdao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() { return Mdao; }
	
	// 1. 
	public boolean signup( String id , String password ) { 
		System.out.println("4.회원가입 저장 합니다." );
		return false; 
	}
	

}
