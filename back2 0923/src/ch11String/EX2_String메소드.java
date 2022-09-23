package ch11String;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class EX2_String메소드 {
	
	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System.in);
		//char ch = scanner.next().charAt(0);
		
		// 1. 문자열.CharAt(인덱스) : 문자열의 해당 인덱스의 문자 추출
		String ssn ="010624-1230123";
		char sex = ssn.charAt(7);
		System.out.println(sex);
		switch(sex) {
		case '1' :
		case '3' :
			System.out.println("남자 입니다."); break;
		case '2' :
		case '4' :
			System.out.println("여자 입니다."); break;
		}
		
		// 2. 문자열1.equals(문자열2) : 두 문자열 비교
		String strVar1 = new String("신문철");
		String strVar2 = "신문철";// String 객체인데 왜 new 안쓰나요?? "" : String 뜻하기 때문
		
		if( strVar1 == strVar2) {
			System.out.println("(스택값(주소)이 같다.)같은 String 객체를 참조" );
		}else {System.out.println("(스택값(주소)이 다르다.)다른 String 객체를 참조");}
		
		if( strVar1.equals(strVar2)) {
			System.out.println("(힙 값이 같다.) 같은 문자열 가짐");
		}
		else {System.out.println("(힙 값이 다르다.) 다른 문자열 가짐");}
		
		// 3. getBytes( 인코딩타입 )
		// 바이트로 변환
		String str = "안녕하세요";
		byte[] bytes1 = str.getBytes(); 	System.out.println("문자열 -> 바이트열 길이 : " + bytes1.length);
		String str1 = new String(bytes1); 	System.out.println("바아트열 -> 문자열 : " + str1);
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		try {
			// EUC-KR : 영문/한글 지원 영문1바이트 한글2바이트
			byte[] bytes2 = str.getBytes("EUC-KR");		System.out.println("문자열 -> 바이트열(EUC-KR) : " + bytes2.length);
			String str2 = new String(bytes2,"EUC-KR");	System.out.println("바이트열(EUC-KR) -> 문자열 : " + str2);
			// UTF-8 : 전 세계 언어 지원 영문1바이트 한글3바이트
			byte[] bytes3 = str.getBytes("UTF-8");		System.out.println("문자열 -> 바이트열(UTF-8) : " + bytes3.length);
			String str3 = new String(bytes3, "UTF-8");	System.out.println("바이트열(UTF-8) -> 문자열 : " + str3);
		}
		catch (UnsupportedEncodingException e) {}
		
		
		// 4. indexOf( "문자" ) : 해당 문자 인덱스번호 찾기
		System.out.println();
		System.out.println();
		
		String subject = "자바 프로그래밍";
		System.out.println(subject.indexOf("프로그래밍"));		// 3
		int location = subject.indexOf("프로그래밍");
		if(location != -1) {System.out.println("찾았다.");}
		else {System.out.println("못찾았다");}
		
		// 5. length() : 문자열 길이
		System.out.println();
		System.out.println();
		
		String ssn2 = "7306241230123";
		int length = ssn.length();
		if( length == 13) {System.out.println("주민번호 자릿수가 맞습니다.");}
		else{System.out.println("주민번호 자릿수가 틀립니다.");}
		
		// 6. replace() : 치환
		System.out.println();
		System.out.println();
		String oldStr = "자바는 객체 지향 언어입니다. 자바는 풍부한 API를 지원힙니다.";
		String newStr = oldStr.replace("자바" , "java");
		
		System.out.println(oldStr);
		System.out.println(newStr);
		
		// 7.
		// toLowerCase()
		// toUpperCase()
		System.out.println();
		System.out.println();
		String str2 = "Java Programming";
		System.out.println(str2.toLowerCase()); // 소문자 변환
		System.out.println(str2.toUpperCase());	// 대문자 변환
		
		// 8. trim()
		// 문자 사이 x
		// 문자 앞뒤 o
		String tel1 = "     02";
		String tel2 = "  1 2 3     ";
		String tel3 = "        1 23 ";
		System.out.println( tel1.trim() );
		System.out.println( tel2.trim() );
		System.out.println( tel3.trim() );
		
		// 9. valueOf()
		// 다른자료형 --> 문자열(String) 변환
		// 숫자 + ""(String) = 숫자형
		System.out.println(10+"");						// 정수형 -> 문자열 10 		출력 ( 숫자 아님 )
		System.out.println( String.valueOf(10.5));		// 실수형 -> 문자열 10.5	
		System.out.println( String.valueOf(true));		// 논리형 -> 문자열 true
		
		// 10. substring( 시작 , 끝 ) : 문자열 자르기
		System.out.println();
		System.out.println();
		String ssn3 = "880815-1234567";
		String firstNum = ssn3.substring(0,6);
		System.out.println( firstNum );
		
		String secondNum = ssn3.substring(7);
		System.out.println( secondNum );
		
		// 11. split( 자르기 기준문자 )
		// 0 : 앞
		// 1 : 뒤
		System.out.println();
		System.out.println();
		String[] result = ssn3.split("-");
		System.out.println(result[0]);
		System.out.println(result[1]);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
