package 키오스크.관리자;

import java.security.PublicKey;

public class MenuDTO {
	
	private int mno;
	private String mname;
	
	public MenuDTO() {}
	public MenuDTO(int mno, String mname) {
		this.mno = mno;
		this.mname = mname;
	}
	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}
	
	

}
