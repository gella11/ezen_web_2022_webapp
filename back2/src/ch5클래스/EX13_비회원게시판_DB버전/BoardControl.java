package ch5클래스.EX13_비회원게시판_DB버전;

public class BoardControl {
	
	BoardDao boardDao = new BoardDao();
	
	// 1.
	boolean regist( String b_title, String b_content, String b_writer, String b_password) {
		// 로직 or DAO 호출 작성 예정
		// - 4개의 매개변수 받는다.
		// - 변수 많을 때, 이동하면 매개변수 코드가 많으니까 객체화 하자
		// 유효성검사 [추후]
		// DB 처리
		BoardDto boardDto = new BoardDto(0, b_title, b_content, b_writer, b_password, 0);
		boolean result = boardDao.regist(boardDto);
		return result;
	}
	
	// 2.
	BoardDto[] getBoardlist() {
		// 로직 or DAO 호출 작성 예정
		BoardDto[] boardlist = null;
		boardlist = boardDao.getBoardlist();
		return boardlist;
		
		// return boardDao.getBoardlist(); 한 줄로 요약 할 수 있음 
	}
	

	// 3.
	BoardDto getBoard(int b_no) {
		// 로직 or DAO 호출 작성 예정
		BoardDto board = null;
		board = boardDao.getBoard(b_no);
		return board;
	}
	
	// 4.
	boolean update(  int b_no ,
					String b_passowrd,
					String new_title,
					String new_content) {
		// 로직 or DAO 호출 작성 예정
		return false;
		}
	
	// 5.
	boolean delete( int b_no, String b_password) {
		// 로직 or DAO 호출 작성 예정
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	

