package ch12스레드.타이머스레드;

public class Timer extends Thread {
	// A클래스 extends B클래스 : 상속
	// A클래스 = 자식클래스
	// B클래스 = 부모클래스
	// A클래스는 B클래스의 멤버(필드,생성자,메소드) 접근할 수 있다.
	
	private boolean stop = true;
	private boolean wait = true;
	public void setStop( boolean stop) { this.stop = stop;}
	public void setWait( boolean wait) { this.wait = wait;}


	@Override
	public void run() {초단위();}	
	
	private void 초단위() {
		int i = 1;
		while(stop) {
			if(wait) {
				System.out.println(i + "초");
				i++;
			}
			try{Thread.sleep(1000);}
			catch (Exception e) {}
			System.out.println("스레드 회전중");
		}
	}
}

