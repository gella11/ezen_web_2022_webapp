package 협업과제2;

public class DTO {

	private int a_no;
	private String name;
	private String phone;
	private String lockpassword;
	private String account;
	
	public DTO() {}

	public DTO(int a_no, String name, String phone, String lockpassword, String account) {
		super();
		this.a_no = a_no;
		this.name = name;
		this.phone = phone;
		this.lockpassword = lockpassword;
		this.account = account;
	}

	public int getA_no() {
		return a_no;
	}

	public void setA_no(int a_no) {
		this.a_no = a_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLockpassword() {
		return lockpassword;
	}

	public void setLockpassword(String lockpassword) {
		this.lockpassword = lockpassword;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	
	
	
	
}
