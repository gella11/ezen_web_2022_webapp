package ch3조건문반복문;

import java.util.Scanner;

public class EX5_예금프로그램 {// class start 
	
	// 2. main(메인 스레드 내장) 함수[ 코드 실행 ]
	public static void main(String[] args) { // main start 
		
		// P.161 확인문제7
		boolean run = true;	// boolean형 변수 선언 / 종료 하는 스위치(on/off , true/false 등) 변수
		int balance = 0;	// int형 변수 선언 / 금액 저장하는 변수 
		Scanner scanner = new Scanner(System.in); // 입력객체 선언 
		// 객체 선언 : 클래스명 변수명 = new 생성자명( 매개변수 )
			// 객체마다 변수와 메소드(함수) 포함 = 멤버 // 객체의 멤버호출 ( . )  접근연산자
		while( run ) { // while( true/false )  : true 이면 반복문 실행
			System.out.println("--------------------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료"); // 입력 경우의수 4개
			System.out.println("---------------------------");
			System.out.print("안내) 선택> "); int ch = scanner.nextInt();
			if( ch == 1 )  // 1 입력했을경우 
				{ System.out.print("안내) 예금액>"); balance += scanner.nextInt(); } 
			else if( ch == 2 ) // 2 입력했을경우  
				{ 
					System.out.print("안내) 출금액>"); 
					// 잔액부족 [ 경우의수 2개 : 1. 예금액보다 출금액 더 크거나 같으면 / 2. 더 작으면  ]
					// 잔액부족 [ 경우의수 2개 : 1. 예금액보다 출금액 더 크면 / 2. 더 작거나 같으면  ]
					int money = scanner.nextInt();
					if( balance < money ) { System.out.println("안내) 잔액이 부족합니다.");}
					else { balance -=money;  }
				}
			else if( ch == 3 ) // 3 입력했을경우 
				{ System.out.println("안내) 잔고>"+balance ); } 
			else if( ch == 4 ) // 4 입력했을경우 
				{ break; } 
			else // 그외 입력했을경우 
				{ System.out.println("안내) 알수없는 번호 입니다. "); }	
		} // while end 
		System.out.println("프로그램 종료");
	} // main end 
} // class end 

