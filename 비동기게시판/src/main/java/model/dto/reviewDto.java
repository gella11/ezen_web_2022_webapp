package model.dto;

public class reviewDto {

	   private int bno;
	   private int aa;
	   private int bb;
	   private int cc;
	   private String cname;
	   private String ccontent;
	   private String cpassword;
	   
	   
	   public reviewDto() {}


	public reviewDto(int bno, int aa, int bb, int cc, String cname, String ccontent, String cpassword) {
		super();
		this.bno = bno;
		this.aa = aa;
		this.bb = bb;
		this.cc = cc;
		this.cname = cname;
		this.ccontent = ccontent;
		this.cpassword = cpassword;
	}


	@Override
	public String toString() {
		return "reviewDto [bno=" + bno + ", aa=" + aa + ", bb=" + bb + ", cc=" + cc + ", cname=" + cname + ", ccontent="
				+ ccontent + ", cpassword=" + cpassword + "]";
	}


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public int getAa() {
		return aa;
	}


	public void setAa(int aa) {
		this.aa = aa;
	}


	public int getBb() {
		return bb;
	}


	public void setBb(int bb) {
		this.bb = bb;
	}


	public int getCc() {
		return cc;
	}


	public void setCc(int cc) {
		this.cc = cc;
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
