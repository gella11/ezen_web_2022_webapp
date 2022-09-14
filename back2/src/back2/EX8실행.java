package back2;

import java.util.Scanner;

public class EX8실행 {
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		// 1. 객체 생성 [빈 생성자 사용]
		Member m1 = new Member();
		// 2. 객체 생성 [매개변수 1개 생성자]
		Member m2 = new Member("아이디");
		// 3. 객체 생성 [매개변수 2개 생성자]
		Member m3 = new Member("아이디" , "비밀번호");
		// 4. 객체 생성 [매개변수 3개 생성자]
		Member m4 = new Member("아이디" , "비밀번호" , "이름");
	}
}

/*
 객체지향 프로그램
 	1. 클래스 : 필드 , 생성자 , 메소드로 구성
 	2. 객체 	: 클래스로부터 new 연산자를 사용한 메모리 할당
 		객체 [선언] : 클래스명 변수명 = new 생성자명();
 		객체 [호출] : 변수명
 		객체 [멤버호출] :
 			변수명.멤버
 			변수명.필드명
 			변수명.메소드명
 */