package ch7상속;

public class EX3_상속 {

	public static void main(String[] args) {
		int r = 10;
		// 부모클래스가 객체 직접 선언
		Calculater calculater = new Calculater();
		System.out.println("원 면적 : " + calculater.areaCircle(r));
		// 자식클래스가 객체 선언
		Computer computer = new Computer();
		System.out.println("원 면적 : " + computer.areaCircle(r));
	}
}
