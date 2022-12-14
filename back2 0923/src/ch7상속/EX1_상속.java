package ch7상속;

public class EX1_상속 {
	
	public static void main(String[] args) {
		// 1. 객체 생성
		DmbCellPhone dmbCellPhone 
			= new DmbCellPhone("자바폰", "검정", 10);
		
		// 2. 객체[클래스]가 상속받은 필드 호출
		// DmbCellPhone 클래스가 extends를 했기 때문에 가능
		System.out.println("모델 : " + dmbCellPhone.model);
		System.out.println("색상 : " + dmbCellPhone.color);
		
		// 3. 본인 클래스
		System.out.println("채널 : " + dmbCellPhone.channel);
		
		// 4. 객체[클래스]가 상속받은 메소드 호출
		// DmbCellPhone 클래스가 extends를 했기 때문에 가능
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요.");
		dmbCellPhone.receiveVocie("안녕하세요 저는 홍길동인데요.");
		dmbCellPhone.sendVoice("아~~ 예 반갑습니다.");
		dmbCellPhone.hangUp();
		
		// 5. 본인 클래스
		dmbCellPhone.turnOnDmb();
	}
	
	
}
