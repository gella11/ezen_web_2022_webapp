package back2;

public class Calculator {
	
	//3. 메소드
		// 형태 :  반환타입 메소드명( 매개변수 ){ 실행문; return 반환값}
	
	// --- 반환x 매개변수x 함수 선언
	//void : 반환[ 함수가 종료되면서 반환값은 없다.]
	void powerOn() {
		System.out.println("전원을 켭니다.");
		return; // void 일 경우 생략 가능 . 대부분 생략
	}
	
	// --- 반환o 매개변수 2개인 함수 선언 [iut 변수 2개 받고 int 변수 1개 준다]	
	int plus(int x , int y) {
		int result = x + y;
		return result;
	}
	
	// --- 반환o 매개변수 3개인 함수 선언
	double divide( int x , int y ) {
		double result = (double)x / (double)y ; //(자료형)변수 : 강져형변환
		return result;
	}
	
	// --- 반환x 매개변수x 함수 선언
	void powerOff() {
		System.out.println("전원을 끕니다.");
		return;
	}
}
