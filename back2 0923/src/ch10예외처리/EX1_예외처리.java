package ch10예외처리;

public class EX1_예외처리 {

	public static void main(String[] args) {

		// 1.NullPinter
		// String data = null;
		// System.out.println(data.toString());
		
		// 2.
		// System.out.println(args);
		// String data1 = args[0];
		// System.out.println("data1 : " + data1);
		// System.out.println("data2 : " + data2);
		
		// int[] 정수배열 = new int[3];
		// for(int i = 0 ; i<=정수배열.length ; i++) {
		// 	System.out.println(정수배열[i]);
		// }
		
		// 3. NumberFormat
		/*
		 	123 	<- 정수는 int
		 	12.3	<- double
		 	"안녕"	<- String(클래스)
		 	int 정수 = 123 
		 */
		String data1 = "100"; // 문자열 100 ""안에 있으니까
		String data2 = "a100";
		
		int value1 = Integer.parseInt(data2); // "100"  > 100
		int value2 = Integer.parseInt(data2); // "a100" > x
		
		int result = value1 + value2;
		System.out.println(data1 + data2 + "=" + result);
		
		
		//////////////////////
		
		// 1. 자식 객체 선언
		Dog dog = new Dog();
		changeDog(dog);
		
		// 2. 자식 객체 선언
		Cat cat = new Cat();
		changeDog(cat);
		
	}// main end
	
	// Animal anumal
	// Dog dog 로 받아도 되지만.
	// 다형성 성질로 이용할 수 있음
	public static void changeDog(Animal animal) {
		if( animal instanceof Dog) {
		Dog dog = (Dog)animal;
		System.out.println("개로 변환");
		}
		
		
	}
	
}
