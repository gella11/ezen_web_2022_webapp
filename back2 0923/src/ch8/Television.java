package ch8;
						// [ implement 인터페이스] RemoteConrol를 implement(구현하다) [추상 구현] 
public class Television implements RemoteControl{
			// Television 빨간 줄은 구현한다고 해놓고 구현 안해서 빨간 줄이 들어옴
	
	// 필드
	private int volume;
	
	
	
	
	// RemoteConrol 인터페이스의 추상메소드를 구현하자
	// 컨트롤 스페이스바 중에 A는 abstract 추상을 의미
	@Override
	public void turnOn() { System.out.println(" tv를 on니다."); }
	
	@Override
	public void turnOff() { System.out.println(" tv를 off합니다."); }
	
	@Override
	public void setVolume(int volume) {
		if( volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 볼륨 :" + this.volume);
	}
}
