package ch7상속.EX5타이어예제;

public class HankookTire extends Tire {

	
	
	// 1.필드
	
	// 2. 생성자
	public HankookTire(int maxRotation, String location) {
		super(maxRotation, location);
	}
	
	// 3. 메소드
	@Override
	public boolean roll() {
		++accumulatedRoation;
		if(accumulatedRoation < maxRotation ) {
			System.out.println(    location + "HankookTire 수명 : " 
								+ (maxRotation-accumulatedRoation) 
								+ "회");
								return true;
								}
		else{
			System.out.println("***" + location + " HankookTire 펑크 ***");
			return false;
		}
	}
}







