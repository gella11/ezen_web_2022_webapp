package ch8;

public class Car {
	Tire frontLeftTire = new 한국타이어();
	Tire frontRightTire = new 한국타이어();
	Tire backLeftTire = new 한국타이어();
	Tire backRightTire = new 한국타이어();
	void run() { 
		frontLeftTire.roll(); frontRightTire.roll();
		backLeftTire.roll(); backRightTire.roll();
	}
}
