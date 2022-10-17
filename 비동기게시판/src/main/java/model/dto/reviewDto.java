package model.dto;

public class reviewDto {

	   private int bno;
	   private int cno;
	   private int cindex;
	   private String cname;
	   private String ccontent;
	   private String cpassword;
	   
	   
	   public reviewDto() {}


	public reviewDto(int bno, int cno, int cindex, String cname, String ccontent, String cpassword) {
		super();
		this.bno = bno;
		this.cno = cno;
		this.cindex = cindex;
		this.cname = cname;
		this.ccontent = ccontent;
		this.cpassword = cpassword;
	}


	@Override
	public String toString() {
		return "reviewDto [bno=" + bno + ", cno=" + cno + ", cindex=" + cindex + ", cname=" + cname + ", ccontent="
				+ ccontent + ", cpassword=" + cpassword + "]";
	}


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public int getCno() {
		return cno;
	}


	public void setCno(int cno) {
		this.cno = cno;
	}


	public int getCindex() {
		return cindex;
	}


	public void setCindex(int cindex) {
		this.cindex = cindex;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
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

	   
	  
	
	
	
}
