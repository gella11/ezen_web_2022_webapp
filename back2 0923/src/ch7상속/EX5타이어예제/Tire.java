package ch7상속.EX5타이어예제;

public class Tire {
	
	//필드
	public int maxRotation; // 최대 회전수(타이어무여)
	public int accumulatedRoation; // 누적 회전수
	public String location;
	//생성자
	public Tire(int maxRotation, String location) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	//메소드
	public boolean roll() {
		++accumulatedRoation;
		if(accumulatedRoation < maxRotation ) {
			System.out.println(    location + "Tire 수명 : " 
								+ (maxRotation-accumulatedRoation) 
								+ "회");
								return true;
								}
		else{
			System.out.println("***" + location + " Tire 펑크 ***");
			return false;
		}
	}
	
	
}
