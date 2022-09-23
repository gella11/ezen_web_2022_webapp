package ch5클래스.EX11;

public class EX11실행 {

	public static void main(String[] args) {
		
		//run메소드 호출할 건데, 동일한 클래스에 존재
		
		//1. 메소드 선언시 main 함수가 해당 메소드 먼저 읽기 static사용 >>> 그냥 불러오면 됨
		//단점 : 프로그램 종료시 초기화 >> 항상 들고다녀야함 >> 메모리 효율성 떨어짐
		// run();
		
		//2. 객체 만들고 static 메소드 아닌 메소드를 호출한다.
		EX11실행 ex11실행 = new EX11실행();
		ex11실행.run2();
		
		
	}	
	
	
			
	///////////////////// main 밖 ///////////////////////
	
	
	
	
	//main 밖에 함수 선언
	static void run() {
		while(true) {
			System.out.println("1.회원가입 2.로그인 : ");
		}
	}
	void run2() {
		while(true) {
			System.out.println("1.회원가입 2.로그인 : ");
		}
	}
}
