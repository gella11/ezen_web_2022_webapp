package ch8;

public class EX3_실행 {
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.run();
		
		// 구현객체 교체
		myCar.frontLeftTire = new 금호타이어();
		myCar.frontRightTire = new 금호타이어();
		
		myCar.run();
	}
}
