package back2;

import java.util.Scanner;

public class EX9실행 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// 1. 객체 생성
		Calculator myCale = new Calculator();
		
		// 2. 메소드 호출 [매개변수x 반환x]
		myCale.powerOn();
		
		// 3. 메소드 호출 [매개변수2 반환1]
		System.out.println(  myCale.plus( 5, 6 ) );
		int result1 = myCale.plus( 5, 6 );
		System.out.println("result1 : " + result1 );
		
		//3.
		byte x = 10;
		byte y = 4;
		double result2 = myCale.divide(x, y);
		System.out.println("result2 : " + result2);
		
		//4.
		myCale.powerOff();
		
		
	}
}
