package ch7상속;

// 상위[부모]클래스로 사용할 목적
public class CellPhone {
	// 1.필드
	String model;
	String color;
	// 2.생성자
	// 기본생성자 : 생성자 1개도 없을 때 자동으로 선언되는 생성자 CellPhone(){}
	// 만일 빈생성자가 아닌 다른 생성자를 선언했으면 기본생성자는 자동선언이 안_된다.
	// super(); 이것이 부모의 생성자를 호출하는 것인데,
	// 부모클래스에 빈생성자가 없거나, 매개변수가 일치하지 않는 생성자가 없으면 사용되지 못_함
	// super(); 생략해도 암묵적으로 명시됨.
	// 3.메소드
	void powerOn()  				 {System.out.println("전원을 켭니다.");}
	void powerOff() 				 {System.out.println("전원으르 끕니다.");}
	void bell()						 {System.out.println("벨이 울립니다..");}
	void sendVoice(String message)	 {System.out.println("자기 : " + message);}
	void receiveVocie(String message){System.out.println("상대방: " + message);}
	void hangUp()					 {System.out.println("전화를 끊습니다.");}
		
}
