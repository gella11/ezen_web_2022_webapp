package controller;

public class BoardDto {

	private int bno;
	private String btitle;
	private String bcontent;
	private String bname;
	private String bpassword;
	private String bdate;
	private int view;
	
	
	public BoardDto() {}


	public BoardDto(int bno, String btitle, String bcontent, String bname, String bpassword, String bdate, int view) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bname = bname;
		this.bpassword = bpassword;
		this.bdate = bdate;
		this.view = view;
	}


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getBtitle() {
		return btitle;
	}


	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}


	public String getBcontent() {
		return bcontent;
	}


	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}


	public String getBname() {
		return bname;
	}


	public void setBname(String bname) {
		this.bname = bname;
	}


	public String getBpassword() {
		return bpassword;
	}


	public void setBpassword(String bpassword) {
		this.bpassword = bpassword;
	}


	public String getBdate() {
		return bdate;
	}


	public void setBdate(String bdate) {
		this.bdate = bdate;
	}


	public int getView() {
		return view;
	}


	public void setView(int view) {
		this.view = view;
	}


	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bname=" + bname
				+ ", bpassword=" + bpassword + ", bdate=" + bdate + ", view=" + view + "]";
	}
	
	
	
}
