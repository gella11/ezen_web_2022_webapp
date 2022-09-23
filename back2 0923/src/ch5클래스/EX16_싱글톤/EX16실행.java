package ch5클래스.EX16_싱글톤;

public class EX16실행 {

	public static void main(String[] args) {
		
		// 객체 선언 [ 클래스명 객체명 = new 생성자(); ]
		// Singleten s1 = new Singleten();	//오류이유 : 생성자가 private 이기 때문
		// Singleten s2 = new Singleten();
		
		// Singleten.s1; 					// 오류이유 : s1객체 private
		Singleten.getInstance();
		Singleten s3 = Singleten.getInstance();
		Singleten s4 = Singleten.getInstance();
		//s3 s4 객체는 같다
		
		if(s3 == s4) {//주소 비교하려고 == 사용, 값까지 동일하려고 하면 equals
			System.out.println("주소값이 같다.");
		}else {
			System.out.println("다르다");}
		}	
	}
