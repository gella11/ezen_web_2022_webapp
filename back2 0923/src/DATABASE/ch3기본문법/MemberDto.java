package DATABASE.ch3기본문법;

public class MemberDto {

	// DB TABLE 필드명 동일하게 해야 보기 편함
	// 1. 필드
	String mem_id;
	String mem_name;
	int mem_number;
	String addr;
	String phone1;
	String phone2;
	short height;
	String debut_date;
	int 연락처;
	int 회원수;
	
	
	// 2. 생성자
	public MemberDto(String mem_id, String mem_name, int mem_number, String addr, String phone1, String phone2, short height,
			String debut_date) {
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_number = mem_number;
		this.addr = addr;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.height = height;
		this.debut_date = debut_date;
	}

	public MemberDto(String mem_id, String mem_name) {
		this.mem_id = mem_id;
		this.mem_name = mem_name;
	}

	public MemberDto(String mem_name, short height , int mem_number) {
		super();
		this.mem_name = mem_name;
		this.height = height;
		this.mem_number = mem_number;
	}

	public MemberDto(String mem_id, String mem_name, String debut_date) {
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.debut_date = debut_date;
	}

	public MemberDto(String mem_id, String mem_name, String debut_date,short height) {
		super();
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.debut_date = debut_date;
		this.height = height;
	}

	public MemberDto(String addr) {
		super();
		this.addr = addr;
	}

	



	


	
	
	
	
	
	
}
