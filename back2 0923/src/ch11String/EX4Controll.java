package ch11String;

import 키오스크.관리자.AdminDAO;

public class EX4Controll {

	
	boolean 일정추가( String cdate, String ccoment ) {
		//싱글톤객체 메소드 호출
		return EX4DAO.getInstance().일정추가(cdate,ccoment);
	}
}
