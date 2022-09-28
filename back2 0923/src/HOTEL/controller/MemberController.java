package HOTEL.controller;

import HOTEL.model.Dao.MemberDao;

public class MemberController {
	
	private static MemberController
			Mcontrol = new MemberController();
	private MemberController() {}
	public static MemberController getInStance() { return Mcontrol; }
	

	
	// 1.
	public boolean signup( String id , String password ) { 
		System.out.println("3.회원가입 처리합니다." );
		return MemberDao.getInstance().signup( id , password  );
	}
	
}

