package HOTEL;

import HOTEL.view.Mainpage;

public class Start {
	
	public static void main(String[] args) {
		
		// 메소드 호출하는 방법
			// 1. new 객체 -> 객체명.메소드명()
			// 2. 메소드가 static -> 클래스명.메소드명();
			// 3. 싱글톤 --> 클래스명.getInstance().메소드명()
			// -- 4. 같은 클래스내 메소드 -> 메소드명()
		Mainpage.getInstance().index();
	}

}
