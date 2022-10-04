package ch8;

public class EX1_실행 {
	
	public static void main(String[] args) {
		
		// 객체 [ 인터페이스 아님 ]
		Television tv = new Television();
		// 인터페이스 구현객체
		// 인터페이스 	변수명 = new 구현클래스();
		RemoteControl rc = new Television();
		Searchable sc = new SmartTelevision();
		
		// 2. 실행
		// 현재 rc는 텔레비젼
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		
		// 3. tv -> audio
		// 현재 rc 구현객체 오디오로 변경
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(7);
		rc.turnOff();
		
		System.out.println("audio ---> 스마트tv 변경");
		SmartTelevision stv = new SmartTelevision();
		
		rc = stv;		
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		Searchable sc = new SmartTelevision();
		sc.search("11번");
		
		
	}
	
}
