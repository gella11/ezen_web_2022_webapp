package ch12스레드;

import java.awt.Toolkit;

public class BeepTask implements Runnable {


	// implement : 구현 
	// Runnable : 스레드 인터페이스 
// 1. 필드
// 2. 생성자
// 3. 메소드[ 스레드 제공하는 함수 = run ]
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