package ch8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class EX4_실행 {
	public static void main(String[] args) {
		// 1. 인터페이스 변수에 구현객체 대입
		Vehicle vehicle = new Bus();
		
		vehicle.run();
		
		// 2. 인터페이스에 없는 메소드 이므로 사용불가
		// vehicle.checkFare();
		
		// 3. 강제 형변환 [인터페이스 -> 객체]
		// 객체명or변수명 instanceof 클래스명
		System.out.println( "텔레비전 관계확인 : " + (vehicle instanceof Television) );
		System.out.println( "버스 관계확인 : " + (vehicle instanceof Bus) );
		Bus bus = (Bus)vehicle;
		bus.run();
		bus.checkFare();
		
		
		// *** 컬렉션프레임워크
		List< String > list;		// 인터페이스 변수 선언
		// 1. 인터페이스 변수에 Arraylist 탑제
		list = new ArrayList<>();
		// 2. 인터페이스 변수에 Vector 객체 탑재
		list = new Vector<>();
		// 3. 인터페이스변수에 Linkedlist 객체 탑재
		list = new LinkedList<>();
		
		
		
		
		
		
		
	}
}
