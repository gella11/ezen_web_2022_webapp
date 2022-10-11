package model.dto;

public class boardDto {

	private int bno;
	private String title;
	private String content;
	private String bname;
	private String bpassword;
	private String bdate;
	private int view;
	
	public boardDto() {	}

	public boardDto(int bno, String title, String content, String bname, String bpassword, String bdate) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.bname = bname;
		this.bpassword = bpassword;
		this.bdate = bdate;
	}

 







	public boardDto(int bno, String title, String content, String bname, String bpassword, String bdate, int view) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.bname = bname;
		this.bpassword = bpassword;
		this.bdate = bdate;
		this.view = view;
	}

	@Override
	public String toString() {
		return "boardDto [bno=" + bno + ", title=" + title + ", content=" + content + ", bname=" + bname
				+ ", bpassword=" + bpassword + "]";
	}


	
	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	
	
	
	
	
}
