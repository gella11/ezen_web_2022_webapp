package ch8;
/*
// 클래스 선언 		: 접근제한자 class 클래스명{}
// 인터페이스 선언	: 접근제한자 interface 인터페이스명{}
	// 필드 없음
	// 생성자 없음
	// 메소드
	 	1) 추상메소드 
*/	
public interface RemoteControl {
	// 1. static final 생략시 자동으로 상수 선언
	// 		정적		수정불가
	// 		인터페이스 안에 있는 것은 어차피 다 상수
	// 		변수(변하는 수) 상수(고정된 수)
	// 2. 초기값 필수 (처음 값) 
	public int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	
	// 메소드 부분
	// 추상 : abstract
	// 1. abstract 추상 키워드 생략시 자동으루 추상 선언
	// 선언만 하자!!!! ---> 각 클래스에서 정의하자 [구현 객체]
	public void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	
}
