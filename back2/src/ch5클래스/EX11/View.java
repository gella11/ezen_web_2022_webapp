package ch5클래스.EX11;

import java.util.Scanner;
import java.util.ResourceBundle.Control;

// 최대한 print , scanner : 입/출력 을 작성할 예쩡

public class View {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 변수는 괄호 밖으로 못나감 그래서 밖에 쓰고 static을 써줌
		// >>> 모든 함수에서 쓰려고 밖에다 씀
		// Scanner scanner = new Scanner(System.in);
		
		start();
		
	}
	
	
	
	
	
	// 1. 프로그램 시작하는 함수
	static void start() {
		while(true) {
			view_boardlist();
			System.out.println("1.글쓰기 2.글보기 :");
			int ch = scanner.nextInt();
			if( ch==1 ) {view_regist();}
			else if( ch==2 ) { view_board();}
			else { System.out.println("알 수 없는 번호입니다."); }
		}
	}
	
	// 2. 글쓰기 함수
	static void view_regist() {
		System.out.println("▶▶▶▶▶ 글쓰기");
		System.out.println(" 제목 : ");	String title = scanner.next();
		System.out.println(" 내용 : ");	String content = scanner.next();
		System.out.println(" 작성자 : ");	String writer = scanner.next();
		System.out.println(" 비번 : ");	String password = scanner.next();
		
		boolean result = 
		Controller.con_regist(title, content, writer, password);
		
		if( result) {
			System.out.println("게시물 등록 성공");
		} else {
			System.err.println("게시물 등록 실패 [ 관리자 문의 ]");
		}	
	}
		
	// 3. 글보기 함수 
	static void view_board() {
		System.out.println("게시물 번호 선택 : "); int bnum = scanner.nextInt();
		System.out.println("▶▶▶▶▶ 상세페이지");
		Board temp = Controller.boardlist[bnum];
		if(temp == null) {System.out.println("!!! 없는 번호입니다."); return;}
		System.out.println("제목 : " + temp.title + "     작성자 : " + temp.writer);
		System.out.println("내용 : " + temp.content);
		System.out.println("1.뒤로가기 2.수정 3.삭제 선택: ");	int ch = scanner.nextInt(); // 위에 ch가 있지만 함수가 다르기 때문에 사용 가능
		
			if( ch == 1) {}
			else if( ch==2 ) { view_update(bnum);}
			else if( ch==3 ) { view_delete(bnum);}
			else {}
			return;
	}
	
	// 4. 게시물 목록
	static void view_boardlist() {
		System.out.println("▶▶▶▶▶ 게시물 목록");
		System.out.println("번호 \t 작성자 \t 제목");
		for(int i = 0 ; i <Controller.boardlist.length ; i++) {
			Board temp = Controller.boardlist[i]; //코드가 길어서 //아니면 향상된 포문 쓰기
			if( temp != null) {
			System.out.print(i + "\t");
			System.out.print(temp.writer + "\t");
			System.out.print(Controller.boardlist[i].title + "\n");	// temp 안쓰면 
			}
		}
	}
	
	// 5. 게시물 삭제 함수
	static void view_delete( int bnum ) {
		System.out.println("비밀번호 : ");		String password = scanner.next();
		boolean result = Controller.con_delete(bnum, password);
		if(result) {System.out.println(" 게시물 삭제 성공");}
		else {System.out.println("게시물 삭제 실패");}
	}
	
	// 6. 게시물 수정 함수
	static void view_update(int bnum) {
		System.out.println("비밀번호 : ");		String password = scanner.next();
		System.out.println("수정할 제목 :");	String title = scanner.next();
		System.out.println("수정할 내용 :");	String content = scanner.next();
		boolean result = Controller.con_update(bnum, password, title, content);
		if( result) { System.out.println(" 수정 완료");}
		else {System.out.println("수정 실패");
		}
	}
}













