package ch7상속.EX5타이어예제;

public class Car {
	
	//필드 [ 변수 객체 상수 배열 리스트 ](메모리면 다 들어감)
	Tire frontLefttire 	 = new Tire(6 , "앞왼쪽");
	Tire frontRighttire  = new Tire(2 , "앞오른쪽");;
	Tire backLefttire 	 = new Tire(3 , "뒤왼쪽");;
	Tire backRighttire   = new Tire(4 , "뒤오른쪽");;
	
	//생성자
	//메소드
	//int run() {
	//	System.out.println("자동차 부릉부릉 달립니다.");
	//	if(frontLefttire.roll()  == false) {stop(); return 1;	}
	//	if(frontRighttire.roll() == false) {stop(); return 2;	}
	//	if(backLefttire.roll() 	 == false) {stop(); return 3;	}
	//	if(backRighttire.roll()  == false) {stop(); return 4;	}
	//	return 0;
	//}
	
	// 위 메소드는 타이어가 하나 터지면 다른 타이어 카운트 차감이 안됨.
	// 보완한 메소드
	boolean[] run() {
		System.out.println("자동차 부릉부릉 달립니다.");
		boolean[] tirestate = new boolean[4];
		tirestate[0] = frontLefttire.roll();
		tirestate[1] = frontRighttire.roll();
		tirestate[2] = backLefttire.roll();
		tirestate[3] = backLefttire.roll();
		for(boolean b : tirestate) {
			if( b == false) { stop(); break;}
		}
		return tirestate;
	}
	void stop() {System.out.println("터졌습니다."); }
}
