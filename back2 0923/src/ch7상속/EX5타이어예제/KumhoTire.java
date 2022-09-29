package ch7상속.EX5타이어예제;

public class KumhoTire extends Tire{
	// 상속을 받았는데 빨간줄인 이유는 :
	// 생성자가 정의되지 않음.
	// 슈퍼클래스와 생성자가 다르기 때문에. 생성자가 동일해야 함.
	

	public KumhoTire(int maxRotation, String location) {
		super(maxRotation, location);
	}
	
	@Override
	public boolean roll() {
		++accumulatedRoation;
		if(accumulatedRoation < maxRotation ) {
			System.out.println(    location + "KumhoTire 수명 : " 
								+ (maxRotation-accumulatedRoation) 
								+ "회");
								return true;
								}
		else{
			System.out.println("***" + location + " KumhoTire 펑크 ***");
			return false;
		}
	}
	

}
