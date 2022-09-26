package ch12스레드;

public class 스레드A extends Thread {

	//생성자
	public 스레드A() {
		setName("스레드A");								// setName 메소드는 부모 클래스인 Thread 클래스로부터 물려받음 (extends)
	}
	
	//메소드
	@Override											// @Override : 재정의 지워도 됨. (왼쪽 초록색 화살표가 그뜻)
														// 부모 클래스인 Thread 클래스의 메소드를 재정의 _ 부모의 메소드를 불러와서 쓰지만 내 맘대로 수정해서 수정 가능
	public void run() {
		for( int i = 0 ; i<2; i++) {
			System.out.println(getName() +"가 출력한 내용");
		}
	}
}
