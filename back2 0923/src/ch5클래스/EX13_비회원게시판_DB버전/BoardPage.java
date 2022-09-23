package ch5클래스.EX13_비회원게시판_DB버전;

import java.util.Scanner;



public class BoardPage {
	
	Scanner scanner = new Scanner(System.in);	// 메인 밖에 만든 이유는??? >>>
	BoardControl control = new BoardControl();	// 메인 밖에 만든 이유는??? >>> 모든 메소드에서 사용하려구
	
	public static void main(String[] args) {
		// 메소드 호출 방식 : 1.static 2.new 
		// 이번에는 new 써보겠음
		BoardPage page = new BoardPage();
		page.view();
	}
	// 0. 메인화면
	// 0. 메인화면
	// 0. 메인화면
	void view() {
		BoardPage page = new BoardPage();
		while(true) {
			page.getBoardlist();
			System.out.print("1.글쓰기 2.글제목 선택 : ");
			int btn = scanner.nextInt();
			if( btn == 1) { page.regist();}
			else if ( btn == 2) {page.getBoard();}
			else {System.out.println("알 수 없는 번호입니다."); }
		}
	}
	// 1. 등록화면
	// 1. 등록화면
	// 1. 등록화면
	void regist() {	
		System.out.println("====>>> 등록 페이지");
		System.out.println(">>제목 :");		String b_title = scanner.nextLine();
		System.out.println(">>내용 :");		String b_content = scanner.nextLine();
		System.out.println(">>작성자 :");		String b_writer = scanner.next();
		System.out.println(">> 패스워드 :");	String b_password = scanner.next();
		scanner.nextLine(); // nextLine() 겹치는 문제 해결방안
		//view에서 입력받은 데이터를 control로 이동
		boolean result = control.regist(b_title, b_content, b_writer, b_password);
		// 반환값을 result에 저장한 다음 제어
		if	(result) {System.out.println("게시물 등록 완료");}
		else 		 {System.out.println("게시물 등록 실패");}
	}
	// 2.모든 게시물 출력화면
	// 2.모든 게시물 출력화면
	// 2.모든 게시물 출력화면
	void getBoardlist() {
		System.out.println("====>>> 게시판 페이지");
		System.out.println("번호\t작성자\t제목\t조회수");
		BoardDto[] boardlist = control.getBoardlist();
		// control에서 모든 게시물호출 메소드 호출 >>> 모든 게시물호출 메소드 호출 >>> 모든 게시물의 배열을 반환 받음
		//for(int i = 0 ; i<boardlist.length ; i++) {}
		for( BoardDto dto : boardlist) {
			System.out.print( dto.b_no +"\t");
			System.out.print( dto.b_writer +"\t");
			System.out.print( dto.b_title +"\t");
			System.out.println( dto.b_view +"\t");
		}
	}

	// 3. 개별 게시물 출력 화면
	// 3. 개별 게시물 출력 화면
	// 3. 개별 게시물 출력 화면
	void getBoard() {
		System.out.println(">>> 게시물 번호 : ");
		int b_no = scanner.nextInt();
		BoardDto board = control.getBoard( b_no );
				if( board == null ) { System.out.println(" 없는 게시물"); return;} 
		System.out.println("====>>> 등록 페이지");
		System.out.println("제목 : board.b_title" +"\t");
		System.out.println("작성자 : board.b_writer" +"\t");
		System.out.println("조회수 : board.b_view");
		System.out.println("내용 : board.b_content");
		
		System.out.println("1.뒤로가기 2.수정 3.삭제:");
		int btn = scanner.nextInt();
		BoardPage page = new BoardPage();
		if(btn == 1) {return;}
		else if(btn == 2) {page.update();}
		else if(btn == 3) {page.delete();}
		else {}
	}
	// 4. 수정처리 출력 화면
	// 4. 수정처리 출력 화면
	// 4. 수정처리 출력 화면
	void update() {
		System.out.println("====>>> 수정처리 페이지");
	}
	// 5. 삭제처리 출력 화면
	// 5. 삭제처리 출력 화면
	// 5. 삭제처리 출력 화면
	void delete() {
		System.out.println("====>>> 삭제처리 페이지");}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


















