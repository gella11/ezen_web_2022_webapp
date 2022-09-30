package ch10예외처리;

public class EX3_예외던지기 {

	public static void main(String[] args) {
		
		try {findClass();} catch (Exception e) {System.out.println("함수에서 온 예외");}
	
	}
	
	
								//예외 던지기 : 해당 메소드를 호출했던 곳으로 [ findClass(); 그래서 findClass에 try/catch 이용하요 오류 메소드를 한 곳에 모음. 조금 덜 지저분함]
	public static void findClass() throws ClassNotFoundException{
		Class clazz = Class.forName("java.lang.String2"); // 예외 발생 시점
	}
	
}
