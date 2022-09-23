package ch5클래스.EX16_싱글톤;

public class Singleten {

	private static Singleten s1 = new Singleten();
	//	싱글톤 : 객체 1개만 선언 가능한 클래스
	//	  1.방법 : 외부에서 생성자를 못쓰게 하자
	//	접근제한자 : private : 현재 클래스에서만 호출 가능
	//			  public : 프로젝트 안에 어디서든
	//	  2.방법 : 필드에 정적 객체 선언
	private Singleten() {}
	static Singleten getInstance() {
		return s1;
	}
}
