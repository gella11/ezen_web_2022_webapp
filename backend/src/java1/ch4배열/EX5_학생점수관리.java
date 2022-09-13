package java1.ch4배열;

import java.util.Scanner;

public class EX5_학생점수관리 {
	public static void main(String[] args) {
		
		boolean run = true;		//무한루프 키고 끄는 역할 / 제어 변수
		int studentNum = 0; 	//학생수 저장할 변수
		int[] scores = null; 	//여러개 점수를 저장할 배열 [메모리 할당 전]
		Scanner scanner = new Scanner(System.in);
		
		while( run ) {
			System.out.println("----------------------");
			System.out.println("1.학생수 2.점수입력 3.점수리스트 4.분석 5.종료");
			System.out.println("선택 : "); int selectNo = scanner.nextInt();
			
			if(selectNo==1)
				{System.out.println("학생수 : ");
				studentNum = scanner.nextInt();
				scores = new int[studentNum];
				System.out.println("-배열에 " + studentNum + "명의 점수 입력 가능");
				}
				
			else if(selectNo==2)
				{
				
					for(int i = 0 ; i<scores.length ; i++) {
						System.out.println("scores["+i+"] : ");
						scores[i] = scanner.nextInt();
						
					}
				
				}
			else if(selectNo==3)
				{
					
					for(int i = 0; i<scores.length ; i++) {
						System.out.printf("socres[%d] > %d \n" , i ,  scores[i]);
					}
				
				}	
			else if(selectNo==4)
				{
					int max = 0;
					int sum = 0;
					for( int value : scores) {
						if(value > max) {max = value;}
						sum += value;
					}
					System.out.println("최고 점수 : " + max);
					double avg = (double)sum/scores.length; // 강제형변환 int >>> double
					System.out.println("평균 점수 : " + avg);
					//System.out.println("평균 점수 : " + (sum/scores.length) );
					
					for ( int i = 0 ; i<scores.length ; i++) {
						for( int j = i+1 ; j<scores.length ; j++) {
							if(scores[i] > scores[j]) {
								int temp = scores[i];
								scores[i] = scores[j];
								scores[j] = temp;
							}
						}
					}
					for(int value : scores ) {
						System.out.println(value);
					}
				}
			else if(selectNo==5)
				{run = false;}
			else
				{System.out.println("알 수 없는 번호입니다.");}	
			
		}
		System.out.println("프로그램 종료");
		
	}
}
