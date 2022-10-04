package ch8;

public class SmartTelevision implements RemoteControl, Searchable{
	
	private int volume;

	@Override
	public void turnOn() { System.out.println(" 오디오를 on니다."); }
	
	@Override
	public void turnOff() { System.out.println(" 오디오를 off합니다."); }
	
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
