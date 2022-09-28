package ch7상속;

public class Computer extends Calculater {
	
	@Override // 중복된 것이다.. 고쳐서 새로 사용하거나, 불러와서 사용해라 메모리 아까우니까
	double areaCircle(double r) {
		System.out.println(" 자식)컴퓨터 객체의 원 넓이 함수 실행");
		return Math.PI * r * r;
		
	}
}
