package ch12스레드;

public class 스레드B extends Thread {
	@Override
	public void run() {
		for(int i = 0 ; i<2;  i++) {
			System.out.println(getName() + "가 출력한 내용");
		}
	}
	public 스레드B() {
		setName("스레드B");
	}
}
