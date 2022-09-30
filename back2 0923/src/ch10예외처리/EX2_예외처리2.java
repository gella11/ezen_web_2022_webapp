package ch10예외처리;

public class EX2_예외처리2 {

	public static void main(String[] args) {

		// try catch 는
		// try 중에 예외가 발생한 지점에!!!
		// catch로 이동
		
		// 0. Class.forName : 일반예외 발생. 그러므로 try catch이용
		try {
			  Class clazz = Class.forName("java.lang.String2");
		}catch ( ClassNotFoundException e) {System.out.println("클래스 없음!! : "+ e);
		}finally {System.out.println("예외가 있던 말던 무조건 실행");}
		
		// 1.NullPinter
		try {
		 String data = null;
		 System.out.println(data.toString());
		}catch (NullPointerException e) {System.out.println("객체의 내용이 없습니다.[참조가 없다] :" + e);}
		
		// 2.
		try {
		 System.out.println(args);
		 String data1 = args[0];
		 String data2 = args[1];
		 System.out.println("data1 : " + data1);
		 System.out.println("data2 : " + data2);
		}catch (ArrayIndexOutOfBoundsException e) {System.out.println("배열의 인덱스가 없습니다." + e);}
		
		try {
		 int[] 정수배열 = new int[3];
		 for(int i = 0 ; i<=정수배열.length ; i++) {
		 	System.out.println(정수배열[i]);
		 }
		}catch (ArrayIndexOutOfBoundsException e) {System.out.println("배열의 없는 인덱스 입니다.");}
		
		// 3. NumberFormat
		/*
		 	123 	<- 정수는 int
		 	12.3	<- double
		 	"안녕"	<- String(클래스)
		 	int 정수 = 123 
		 */
	try {
		String data1 = "100"; // 문자열 100 ""안에 있으니까
		String data2 = "a100";
		
		int value1 = Integer.parseInt(data2); // "100"  > 100
		int value2 = Integer.parseInt(data2); // "a100" > x
		
		int result = value1 + value2;
		System.out.println(data1 + data2 + "=" + result);
	}catch (NumberFormatException e) {System.out.println("정수형으로 변환 실패 : " + e);}
	
	
	try {
		// 1. 자식 객체 선언
		Dog dog = new Dog();
		changeDog(dog);			
		// 2. 자식 객체 선언
		Cat cat = new Cat();
		changeDog(cat);	// 예외발생시점 ---> catch 이동
	}catch (ClassNotFoundException e) {System.out.println("클래스형 변환 실패 : " + e);}
	
			
	
	
	
	}// main end

	public static void changeDog(Animal animal) {
		if( animal instanceof Dog) {
		Dog dog = (Dog)animal;
		System.out.println("개로 변환");
		}
	}
}