package 자율주제_무인아이스크림;

import java.util.Random;
import java.util.Scanner;

public class baseballgame {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("3가지 숫자를 입력해주세요 ");
		
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			if(a != b || a != c || b != c) {
				System.out.println("입력 한 숫자 : " + a + b + c  );
				
			}else { System.out.println("중복된 숫자가 있습니다. 재실행 하세요");}
		
	while(true) {
		Random random = new Random();
		int bound=10;	
		int A = random.nextInt(bound);
		int B = random.nextInt(bound);
		int C = random.nextInt(bound);
		if( A != B | A != C | B!= C) {
			System.out.println( A + B + C);
			break;
		}
			
		System.out.println(A);
		System.out.println(B);
		System.out.println(C);
	}
		
		
		
		
	}
	
}
