package 자율주제_무인아이스크림;

import java.util.Scanner;

import ch5클래스.EX7_비회원제게시판_객체버전.Board;

public class icecream_실행 {
	public static void main(String[] args) {
				
		
		Scanner scanner = new Scanner(System.in);
		
		int cash = 0;
		icecream list = new icecream();
		
		
		
		while(true) {
			int sum = ( (list.바밤바cost*list.바밤바count) + (list.누가바cost*list.누가바count) + (list.비비빅cost*list.비비빅count) );
			
			System.out.println("================ 품목 ================");
			System.out.println(" 1.바밤바 \t 2.누가바 \t 3.비비빅");
			System.out.println("================ 장바구니 =============");
			System.out.println(" 제품 \t\t 수량 \t\t 가격");
			System.out.println();
			System.out.println("바밤바 \t" +"\t"+ list.바밤바count +"\t\t"+ (list.바밤바cost*list.바밤바count));
			System.out.println("누가바 \t" +"\t"+ list.누가바count +"\t\t"+ (list.누가바cost*list.누가바count));
			System.out.println("비비빅 \t" +"\t"+ list.비비빅count +"\t\t"+ (list.비비빅cost*list.비비빅count));
			System.out.println();
			System.out.println("================ 결제================");
			System.out.println("\t\t  4.결제 \t 합계 : "  +  sum );
			System.out.println("\t\t  5.카드충전");
			System.out.println("\t\t  잔액 : " + cash);
			System.out.println("===구매하실 제품의 번호를 입력해주세요==="); 	int bar = scanner.nextInt();
			
					
			/////////////////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////////////////
			// 바밤바
			// 바밤바
			// 바밤바
				if( bar == 1 ) {
					System.out.println(" 바밤바 구매 수량을 입력하세요 "); int bar1 = scanner.nextInt();
					if( bar1 > 0 ) {list.바밤바count = bar1;}
					else{  System.out.println(" 구매 수량이 잘못되었습니다. ");}		
				}
			// 누가바
			// 누가바
			// 누가바
				else if( bar == 2 ) {
					System.out.println(" 누가바 구매 수량을 입력하세요 "); int bar2 = scanner.nextInt();
					if( bar2 > 0 ) {list.누가바count = bar2;}
					else{  System.out.println(" 구매 수량이 잘못되었습니다. ");}		
				}
			// 비비빅
			// 비비빅
			// 비비빅
				else if( bar == 3 ) {
					System.out.println(" 비비빅 구매 수량을 입력하세요 "); int bar3 = scanner.nextInt();
					if( bar3 > 0 ) {list.비비빅count = bar3;}
					else{  System.out.println(" 구매 수량이 잘못되었습니다. ");}
				}
				

			// 결제
			// 결제
			// 결제
				else if( bar == 4 ) {
					System.out.println("상품을 확인하였으면 0번을 눌러주세요 "); int confirm = scanner.nextInt();
					if( confirm == 0) {
						if( cash > sum ) {
							cash = cash-sum;
							System.out.println("결제가 완료되었습니다.");
							list.바밤바count = 0;
							list.누가바count = 0;
							list.비비빅count = 0;
							
						}
						else {
							System.out.println("충전해");
						}
					}
				}
			// 충전
			// 충전
			// 충전
				else if( bar == 5 ) {
					System.out.println("충전하실 금액을 입력해주세요"); int card = scanner.nextInt();
					cash = card;
					System.out.println("충전이 완료되었습니다.");
				}
			// 그 밖
			// 그 밖
			// 그 밖
				else {
					System.out.println("해당 번호의 제품이 없습니다.");
					System.out.println();
				}

		}
	}
}
	

		
		
		


