package DATABASE.ch3기본문법;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner( System.in);
		
		while(true) {
			for(int i = 1; i<=19 ; i++) {
				System.out.println( i + "번 select 예제결과");
			}
			System.out.println("예제 번호 선택 :");
			int ch = scanner.nextInt();
			// 메소드 호출 방법
			// 1. static(정적)  >>> 선언된 함수 : 클래스명.함수명()		
			// 2. 일반함수 >>> 객체명.함수명()
			DAO dao = new DAO(); // dao 객체 생성
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==1) {
				ArrayList<MemberDto> list = dao.예제1결과();
				for(MemberDto dto : list) {
					System.out.print( dto.mem_id 			+"\t");
					System.out.print( dto.mem_name			+"\t");
					System.out.print( dto.mem_number 		+"\t");
					System.out.print( dto.addr 				+"\t");
					System.out.print( dto.phone1 			+"\t");
					System.out.print( dto.phone2 			+"\t");
					System.out.print( dto.height			+"\t");
					System.out.println( dto.debut_date 		+"\t");
				}
			}
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==2) {
				ArrayList<String> list = dao.예제2결과();
				System.out.println("===========예제2 결과물============");
				for(String s : list) {
					System.out.println(s +"\t");
				}
				System.out.println();				
			}
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==3) {
				ArrayList<MemberDto> list = dao.예제3결과();
				System.out.println("===========예제3 결과물============");
				for(MemberDto dto : list) {
					System.out.print( dto.mem_id 			+"\t");
					System.out.print( dto.mem_name			+"\t");
					System.out.print( dto.mem_number 		+"\t");
					System.out.print( dto.addr 				+"\t");
					System.out.print( dto.phone1 			+"\t");
					System.out.print( dto.phone2 			+"\t");
					System.out.print( dto.height			+"\t");
					System.out.println( dto.debut_date 		+"\t");
				}	
			}
			// 예제3) 강사님
			//if(ch==3) {
			//	MemberDto dto = dao.예제3결과();
			//	System.out.println("===========예제3 결과물============");
			//	//하나의 값이므로 반복문 필요없음
			//		System.out.print( dto.mem_id 			+"\t");
			//		System.out.print( dto.mem_name			+"\t");
			//		System.out.print( dto.mem_number 		+"\t");
			//		System.out.print( dto.addr 				+"\t");
			//		System.out.print( dto.phone1 			+"\t");
			//		System.out.print( dto.phone2 			+"\t");
			//		System.out.print( dto.height			+"\t");
			//		System.out.println( dto.debut_date 		+"\t");
			//
			//}

			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==4) {
				ArrayList<MemberDto> list = dao.예제4결과();
				System.out.println("===========예제4 결과물============");
				for(MemberDto dto : list) {
					System.out.print( dto.mem_id 			+"\t");
					System.out.print( dto.mem_name			+"\n");
				}
			}
			//if(ch==4) {
			//	ArrayList<MemberDto> list = dao.예제4결과();
			//	System.out.println("===========예제4 결과물============");
			//	for(MemberDto dto : list) {
			//		System.out.print( dto.mem_id 			+"\t");
			//		System.out.print( dto.mem_name			+"\n");
			//	}
			//}
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==5) {
				ArrayList<MemberDto> list = dao.예제5결과();
				System.out.println("===========예제5 결과물============");
				for(MemberDto dto : list) {
					System.out.print( dto.mem_name			+"\t");
					System.out.print( dto.height			+"\t");
					System.out.print( dto.mem_number		+"\n");
				}
			}
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==6) {
				ArrayList<MemberDto> list = dao.예제6결과();
				System.out.println("===========예제6 결과물============");
				for(MemberDto dto : list) {
					System.out.print( dto.mem_name			+"\t");
					System.out.print( dto.height			+"\t");
					System.out.print( dto.mem_number		+"\n");
				}
			}
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==7) {
				ArrayList<MemberDto> list = dao.예제7결과();
				System.out.println("===========예제7 결과물============");
				for(MemberDto dto : list) {
					System.out.print( dto.mem_name			+"\t");
					System.out.print( dto.height			+"\t");
					System.out.print( dto.mem_number		+"\n");
				}
			}
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==8) {
				ArrayList<MemberDto> list = dao.예제8결과();
				System.out.println("===========예제8 결과물============");
				for(MemberDto dto : list) {
					System.out.print( dto.mem_id 			+"\t");
					System.out.print( dto.mem_name			+"\t");
					System.out.print( dto.mem_number 		+"\t");
					System.out.print( dto.addr 				+"\t");
					System.out.print( dto.phone1 			+"\t");
					System.out.print( dto.phone2 			+"\t");
					System.out.print( dto.height			+"\t");
					System.out.println( dto.debut_date 		+"\t");
				}	
			}
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==9) {
				ArrayList<MemberDto> list = dao.예제9결과();
				System.out.println("===========예제9 결과물============");
				for(MemberDto dto : list) {
					System.out.print( dto.mem_id 			+"\t");
					System.out.print( dto.mem_name			+"\t");
					System.out.print( dto.mem_number 		+"\t");
					System.out.print( dto.addr 				+"\t");
					System.out.print( dto.phone1 			+"\t");
					System.out.print( dto.phone2 			+"\t");
					System.out.print( dto.height			+"\t");
					System.out.println( dto.debut_date 		+"\t");
				}	
			}
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==10) {
				ArrayList<MemberDto> list = dao.예제10결과();
				System.out.println("===========예제10 결과물============");
				for(MemberDto dto : list) {
					System.out.print( dto.mem_id			+"\t");
					System.out.print( dto.mem_name			+"\t");
					System.out.print( dto.debut_date		+"\n");
				}
			}
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==11) {
				ArrayList<MemberDto> list = dao.예제11결과();
				System.out.println("===========예제11 결과물============");
				for(MemberDto dto : list) {
					System.out.print( dto.mem_id			+"\t");
					System.out.print( dto.mem_name			+"\t");
					System.out.print( dto.debut_date		+"\t");
					System.out.print( dto.height			+"\n");
				}
			}
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==12) {
				ArrayList<MemberDto> list = dao.예제12결과();
				System.out.println("===========예제12 결과물============");
				for(MemberDto dto : list) {
					System.out.print( dto.mem_id 			+"\t");
					System.out.print( dto.mem_name			+"\n");
				}
			}
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==13) {
				ArrayList<MemberDto> list = dao.예제13결과();
				System.out.println("===========예제13 결과물============");
				for(MemberDto dto : list) {
					System.out.print( dto.addr 			+"\n");
				}
			}
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==14) {
				ArrayList<buy> list = dao.예제14결과();
				System.out.println("===========예제14 결과물============");
				for(buy dto : list) {
					System.out.print( dto.mem_id 			+"\t");
					System.out.print( dto.수량합계 			+"\n");
				}
			}
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==15) {
				ArrayList<buy> list = dao.예제15결과();
				System.out.println("===========예제15 결과물============");
				for(buy dto : list) {
					System.out.print( dto.mem_id 			+"\t");
					System.out.print( dto.총구매금액 			+"\n");
				}
			}
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==16) {
				ArrayList<buy> list = dao.예제16결과();
				System.out.println("===========예제16 결과물============");
				for(buy dto : list) {
					System.out.print( dto.mem_id 			+"\t");
					System.out.print( dto.수량평균 			+"\n");
				}
			}
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==17) {
				ArrayList<MemberDto> list = dao.예제17결과();
				System.out.println("===========예제17 결과물============");
				for(MemberDto dto : list) {
					System.out.print( dto.mem_id 			+"\t");
					System.out.print( dto.phone1		+"\n");
				}
			}
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==18) {
				ArrayList<MemberDto> list = dao.예제18결과();
				System.out.println("===========예제18 결과물============");
				for(MemberDto dto : list) {
					System.out.print( dto.mem_id 			+"\t");
					System.out.print( dto.회원수 				+"\n");
				}
			}
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////
			if(ch==19) {
				ArrayList<buy> list = dao.예제19결과();
				System.out.println("===========예제19 결과물============");
				for(buy dto : list) {
					System.out.print( dto.mem_id 			+"\t");
					System.out.print( dto.총구매금액 				+"\n");
				}
			}
		}
	}
}



























