package ch12스레드;

public class 계산기 {
	
	private int 저장소;
	public int get저장소() {return 저장소;}
		

	public synchronized void set저장소(int 저장) {
		this.저장소 = 저장;
		try {Thread.sleep(2000);}
		catch (Exception e) {}
		System.out.println(
				Thread.currentThread().getName()
				+" : " + this.저장소 );
	}
	
	
}
