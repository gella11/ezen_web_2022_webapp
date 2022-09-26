package ch12스레드;

public class Music extends Thread{
	
	// on/off 저장하는 변수
	// run 메소드 제어하는 변수
	// run을 키고 끄는 것을 제엏나다
	private boolean stop = true;
	// on/off 변경하는 메소드
	public void setStop( boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {								// run 꼭 구현.
		while(stop) {
			System.out.println("음악재생중~~~");
			try {Thread.sleep(1000);}
			catch (Exception e) {
			}
		}
	}
}
