package ch5클래스.EX17_final;

public class EX17실행 {
	public static void main(String[] args) {
		// 1.객체 선언
		//Person p1 = new Person();
		Person p2 = new Person("123456-1234567", "홍길동");
		
		//p2.nation = "USA"; 			// 오류 : final 때문
		//p2.ssn = "654321-9876541";	// 오류 : final 때문
		  p2.name = "홍삼원";				// 정상 : final이 아니기 때문
		
		
	}
}
