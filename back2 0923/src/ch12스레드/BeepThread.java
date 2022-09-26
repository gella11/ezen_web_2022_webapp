package ch12스레드;

import java.awt.Toolkit;

public class BeepThread extends Thread{
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();	
		for( int i = 0 ; i<5 ; i++ ) {
			toolkit.beep(); 
			try{ Thread.sleep(500); }
			catch (Exception e) {}
		}
	}
}


/*
	오버로딩 : 동일한 이름ㄹ의 메소드명을 매개변수로 식별
	오버라이딩 : 부모클래스의 메소드를 자식클래스가 재정의
 */