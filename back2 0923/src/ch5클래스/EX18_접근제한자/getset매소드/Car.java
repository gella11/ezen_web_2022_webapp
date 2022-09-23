package ch5클래스.EX18_접근제한자.getset매소드;

public class Car {
	// 필드
	// 필드정보를 보호하기 위해 모든 필드 private 권장
	// private : 다른 클래스에서 접근 불가
	private int speed;
	private boolean stop;
	
	// 메소드
	// 필드에 직접 접근이 불가능하니까 필드에 간접접근 메소드 선언
	// getSpeed 아무거나 명시할 수 있지만
	// get이 빼오다 Speed를
	// 라는 의미로 쓰면 다른 사람도 보기에 편함
	public  int getSpeed() {return speed;};
	public void setSpeed() {
		if( speed< 0 ) { this.speed = 0; return;}
		else		   { this.speed = speed;}
	}
	
	public boolean isStop() {return stop;};
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = speed;
	}
	// 객체명.speed = 500;		이제는 이렇게 쓰지말기
	// 객체명.setSpeed = (500);	이렇게 쓰기
	
}
