package 키오스크.관리자;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminView {

	Scanner scanner = new Scanner(System.in);
	AdminControl acontrol = new AdminControl();
	
	public static void main(String[] args) {
		// 싱글톤 객체 호출
		// DAO에 public static AdminDAO getInstance() {return adao;} 중 static 있어야함
		// AdminDAO.getInstance();
		
		// main 밖 menu()를 불러오는데 방법1은 밖menu에 static 쓰거나 아래처럼 하기

		AdminView admin = new AdminView();
		admin.menu();
	}
	// 1. 관리자 메뉴
	void menu() {
		while(true) {
			System.out.println("1.메뉴추가 2.제품추가 3.주문확인");
			// ch에 인트 아닌 문자를 입력하면 멈춤.
			// try catch 이용
			try {
				int ch = scanner.nextInt();
				if	   (ch==1) { inMenu(); }
				else if(ch==2) { inProduct(); }
				else if(ch==3) { getOrder(); }
				else{}
			} catch (Exception e) {
				System.out.println("선택할 수 없는 작동입니다.");
				scanner = new Scanner(System.in); // scanner 객체 초기화
			}
		}
	}
	// 2. 메뉴 추가 화면
	void inMenu() {
		System.out.println("추가할 메뉴 이름: ");	String menuname = scanner.next();
		boolean result = acontrol.inMenu(menuname);
		if( result) {System.out.println("메뉴 등록햇습니다.");}
		else		{System.out.println("메뉴 등록 실패했습니다.");}
	}
	// 3. 제품 추가 화면
	void inProduct() {
		////////////현재 메뉴 목록
		ArrayList<MenuDTO> list = acontrol.getMenu();
		for(MenuDTO menu : list) {
			System.out.print(menu.getMno() + ".");
			System.out.print(menu.getMname() + "\n");
		}
		System.out.println("추가할 제품의 메뉴 번호 선택 : ");
		byte mno = scanner.nextByte();
		////////// 제품 추가
		System.out.print("제품명 : ");		scanner.nextLine(); String pname 	= scanner.next();
		System.out.print("가격 : ");								int pprice 	= scanner.nextInt();
		System.out.print("소개 : ");		scanner.nextLine(); String pcomment = scanner.next(); 
		System.out.print("초기재고 : ");						  short pamount = scanner.nextShort();
		boolean result = acontrol.inProduct(pname, pprice, pcomment, pamount, mno);
		if( result) {System.out.println("메뉴 등록햇습니다.");}
		else 		{System.out.println("메뉴 등록 실패했습니다.");}
		
	}
	// 4. 주문 확인 화면
	void getOrder() {}
}











