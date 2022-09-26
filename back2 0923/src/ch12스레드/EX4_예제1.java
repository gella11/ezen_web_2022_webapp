package ch12스레드;

import java.util.Scanner;

public class EX4_예제1 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean musicstate = false;							// 현재 음악 재생여부 판단 변수
		Music music = new Music();							// 음악스레드 선언
		
		boolean moviestate = false;							// 영화 재생여부 판단 변수
		Movie movie = new Movie();
		Thread thread = new Thread(movie);					// 영화 스레드 선언
		
		while(true) {
					
			if(musicstate == false) {System.out.println("1.음악[재생]");}
			else {System.out.println("1.음악[중지]");}
			if(moviestate == false) {System.out.println("2.영화[재생]");}
			else {System.out.println("2.영화[중지]");}
			
			int ch = scanner.nextInt();
			
			//	if(ch == 1) {
				//	music.start();									// 스타트		// 예제의 매인따로, 뮤직클래스 무한루프 따로 놈
				//	music.setStop(false);							// [stop필드 값 변경]음악스레드 중지
				//	musicstate = true;
				//	}
			if( ch == 1 && musicstate == false) {
				music.start();
				musicstate = true;
				}
			else if( ch == 1 && musicstate == true) {
				music.setStop(false);
				musicstate = false;
				music = new Music();								// 음악 재생하고 끄고 다시 재생할때 메모리 할당을 다시 해주기 위함
				}
			
			
			if( ch == 2 && moviestate == false ) {
				thread.start();
				moviestate = true;
			}
			else if( ch == 2 && moviestate == true){
				//thread.stop();									// 밑줄은 권장하지 않음 // 거진 강제 종료 >> 비권장 // 메모리 손실이 있을 수 있음
				movie.setStop(false);								// while문을 제어하자
				moviestate = false;
			}
		}	
	}
}


// Thread 클래스
// Runnable 인터페이스