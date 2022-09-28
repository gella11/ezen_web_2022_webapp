package ch12스레드.타이머스레드;

import java.util.Scanner;

public class EX_실행 {
	
	public static void main(String[] args) {
		
		Timer timer = new Timer();	// 타이머객체 = 멀티스레드선언
		boolean timerstate = false;	// 타이머 현재 실행상태 변수
		boolean waitstate = true;
		
		while(true) {
		Scanner scan = new Scanner(System.in);
		System.out.println("1.타이머시작 2.리셋 3.저장[db]");
		int ch = scan.nextInt();
		
		if(ch == 1 && timerstate == false && waitstate == true) {
			timer.start();
			timerstate = true;
			}
		if(ch == 1 && timerstate == true && waitstate == true) {	
			timer.setWait(false); waitstate = false;
		}
		if(ch == 1 && timerstate == true && waitstate == false) {	
			timer.setWait(true); waitstate = true;
		}
		if(ch == 2) {
			//timer.stop();
			//public void run() {초단위();} 이것이 일시정시가 아닌 아예 끝내버리는 것이기 때문에
			//객체를 다시 지정해줘야 함, 또한 일시정지가 아닌 팍! 끝내는 것이기 때문에.
			//다시 시작할 때 0부터 시작하니 나노초 오차가 생기는 듯
			timer.setStop(false);
			timer = new Timer();
			timerstate = false;
			}
		
		
		
		}
	}
}

/*

	멀티스레드
		1. Thread 클래스 상속
		2. Runnable 인터페이스 구현
		
		* run 메소드 구현 			[ main . new Timer ]
		* start 메소드로 run 호출 	[ timer.start ]

*/