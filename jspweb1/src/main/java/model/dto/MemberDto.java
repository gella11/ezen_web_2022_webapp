package model.dto;

public class MemberDto {
	private int mno;			
	private String mid 	;	
	private String mpassword ;
	private String mname	;	
	private String mphone	;	
	private String memail	;	
	private String maddress	;
	private String mdate	;	
	private int mpint	;
	
	
	public MemberDto() {}
	
	public MemberDto(int mno, String mid, String mpassword, String mname, String mphone, String memail, String maddress,
			String mdate, int mpint) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpassword = mpassword;
		this.mname = mname;
		this.mphone = mphone;
		this.memail = memail;
		this.maddress = maddress;
		this.mdate = mdate;
		this.mpint = mpint;
	}

	
	
	
	
	
	public MemberDto(int i, String mid2, String mpasswordconfirm, String mname2, String mphone2, String memail2,
			String maddress2, Object object, int j) {
		// TODO Auto-generated constructor stub
	}
	
	
	// to string
	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpassword=" + mpassword + ", mname=" + mname + ", mphone="
				+ mphone + ", memail=" + memail + ", maddress=" + maddress + ", mdate=" + mdate + ", mpint=" + mpint
				+ "]";
	}

	// get set
	public int getMno() {
		return mno;
	}


	public void setMno(int mno) {
		this.mno = mno;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getMpassword() {
		return mpassword;
	}


	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public String getMphone() {
		return mphone;
	}


	public void setMphone(String mphone) {
		this.mphone = mphone;
	}


	public String getMemail() {
		return memail;
	}


	public void setMemail(String memail) {
		this.memail = memail;
	}


	public String getMaddress() {
		return maddress;
	}


	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}


	public String getMdate() {
		return mdate;
	}


	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public int getMpint() {
		return mpint;
	}

	public void setMpint(int mpint) {
		this.mpint = mpint;
	}



	
	
}
