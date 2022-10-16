package model.dto;

public class comentDto {

	private int bno;
	private String ccontent;
	private String cpassword;
	private String cname;
	private int cno;
	private String bcomment; 
	
	public comentDto() {}

	public comentDto(int bno, String ccontent, String cpassword, String cname, int cno, String bcomment) {
		super();
		this.bno = bno;
		this.ccontent = ccontent;
		this.cpassword = cpassword;
		this.cname = cname;
		this.cno = cno;
		this.bcomment = bcomment;
	}

	@Override
	public String toString() {
		return "comentDto [bno=" + bno + ", ccontent=" + ccontent + ", cpassword=" + cpassword + ", cname=" + cname
				+ ", cno=" + cno + ", bcomment=" + bcomment + "]";
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getBcomment() {
		return bcomment;
	}

	public void setBcomment(String bcomment) {
		this.bcomment = bcomment;
	}

	
	
	
}
