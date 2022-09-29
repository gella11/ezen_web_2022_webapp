package ch7상속.EX5타이어예제;

public class EX5_실행 {
	public static void main(String[] args) {
		
		// 1. 자동차 생성
		// tire 객체가 4개 생성
		Car car = new Car();
		
		// 2. 자동차 5번 회전
		// 3. 만약에 펑크이면 타이어 교체
		//for(int i = 1 ; i<=3 ; i++) {
		//	int result = car.run();
		//	if(result == 1) { car.frontLefttire  = new HankookTire(15 , "앞왼쪽");  }
		//	if(result == 2) { car.frontRighttire = new HankookTire(13 , "앞오른쪽"); }
		//	if(result == 3) { car.backLefttire   = new KumhoTire(14 , "앞오른쪽"); }
		//	if(result == 4) { car.backRighttire  = new KumhoTire(17 , "앞오른쪽"); }
		//	System.out.println("정상");	
		//}
		
		for(int i = 1 ; i<=3 ; i++) {
			boolean[] result = car.run();
			if(!result[0]) { car.frontLefttire  = new HankookTire(15 , "앞왼쪽");  }
			if(!result[1]) { car.frontRighttire = new HankookTire(13 , "앞오른쪽"); }
			if(!result[2]) { car.backLefttire   = new KumhoTire(14 , "앞오른쪽"); }
			if(!result[3]) { car.backRighttire  = new KumhoTire(17 , "앞오른쪽"); }
			System.out.println("------------------------------");
			
		}
		
		
		
	}
}
