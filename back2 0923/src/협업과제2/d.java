package 협업과제2;

import java.util.Arrays;
import java.util.Random;

public class d {
	public static void main(String[] args) {
		String string = "14321566";
		String a = "1289";
		String eight="";
		String nine="";
		if(a.contains("8")) {a=a.replace("8", "+");}
		if(a.contains("9")) {a=a.replace("9", "-");}
		System.out.println(a);
		int b = 4568;
	    byte[] bytes1 = string.getBytes();
	    byte[] bytes2 = a.getBytes();
	    
	    
	    
	    ///////////////// 형 변환 ///////////////////////
	    String str1 = "123";
	    int str2 = 345;
	    
	    // string -> int
	    int str3 = Integer.parseInt(str1);
	    
	    // int -> string
	    String str4 = Integer.toString(str2);
	    ///////////////////////////////////////////////
	    
	    // 키워드 바이트 String 변환 출력
	    System.out.println(Arrays.toString(bytes1));
	    // 비밀번호 바이트배열 String 출력
	    System.out.println(Arrays.toString(bytes2));
	    // 키워드 String 출력
	    System.out.println("String : " + bytes1);
	    // 비밀번호 String 출력0
	    System.out.println("a : " + bytes2);
	    


	    // 키워드 복호화 후 String화
	    // password
	    // long 자료형 변환
	    // password2
	    String password="";
	    for(int i=0; i<bytes1.length; i++) {
	    	password+=Integer.toString(bytes1[i]);	}
	    Long password2= Long.parseLong(password);
	    
		 
	    // 키워드 * 비밀번호 한 자리수 곱하여 붙이기
	    // qq
	    long[] array2=new long[4];
	    String qq="";
	    for(int i=0; i<array2.length;i++) {
	    	array2[i]=password2 * bytes2[i] * bytes2[i];
	    	qq+=array2[i];
	    }
	    
	    
	    
	    
	    // 확인
	    System.out.println("qq : " + qq);
	    System.out.println("password2 : " + password2);
	    System.out.println(bytes2[0]);
	    System.out.println(bytes2[1]);
	    System.out.println(bytes2[2]);
	    System.out.println(bytes2[3]);
	    System.out.println("첫번째" + password2 * bytes2[0] );
	    System.out.println("두번째" + password2 * bytes2[1] );
	    System.out.println("세번째" + password2 * bytes2[2] );
	    System.out.println("네번째" + password2 * bytes2[3] );
	   
	    // passwrod2 *  비밀번호 각 자리수
	    long ab=password2 * bytes2[0];
	    long ac=password2 * bytes2[1];
	    long ad=password2 * bytes2[2];
	    long ae=password2 * bytes2[3];
	    
	    // String 화
	    String real=Long.toString(ab);
	    real+=Long.toString(ac);
	    real+=Long.toString(ad);
	    real+=Long.toString(ae);
	    
	    // String 화
	    String real2=Long.toString(ae);
	    real2+=Long.toString(ae);
	    real2+=Long.toString(ad);
	    real2+=Long.toString(ac);
	    real2+=Long.toString(ab);
	    
	    System.out.println( "자리수 채우기" + real+real2);
	    String sum = real+real2;
	    
// 복호화
// 복호화
// 복호화
	    // db자료 받아와서 끊기
	    String result1 = sum.substring(0,18);
	    String result2 = sum.substring(18,36);
	    String result3 = sum.substring(36,54);
	    String result4 = sum.substring(54,72);
	    System.out.println(result1);
	    System.out.println(result2);
	    System.out.println(result3);
	    System.out.println(result4);

	    // 롱으로 변환
	    long resultlong1 = Long.parseLong(result1);
	    long resultlong2 = Long.parseLong(result2);
	    long resultlong3 = Long.parseLong(result3);
	    long resultlong4 = Long.parseLong(result4);
	    
	    // 롱으로 패스워드 나누기
	    long no1 = (long) (resultlong1 / password2);
	    long no2 = (long) (resultlong2 / password2);
	    long no3 = (long) (resultlong3 / password2);
	    long no4 = (long) (resultlong4 / password2);
	    System.out.println(" no1 : " + no1);
	    System.out.println(" no2 : " + no2);
	    System.out.println(" no3 : " + no3);
	    System.out.println(" no4 : " + no4);
	    
	    // 롱에서 바이트 변환
	    byte return1 = (byte) no1;
	    byte return2 = (byte) no2;
	    byte return3 = (byte) no3;
	    byte return4 = (byte) no4;
	    System.out.println(return1);
	    System.out.println(return2);
	    System.out.println(return3);
	    System.out.println(return4);
	    
	    // 바이트 배열에 넣기
	    byte[] back = new byte[4];
	    back[0] = return1;
	    back[1] = return2;
	    back[2] = return3;
	    back[3] = return4;
	    System.out.println(back);
	    
	    // 바이트배열 String 화
	    // (+ -) ->  (8 9)  변환
	    String returnpw = new String(back);
	    if(returnpw.contains("+")) {returnpw=returnpw.replace("+", "8");}
		if(returnpw.contains("-")) {returnpw=returnpw.replace("-", "9");}
		
		// 복호화 완료된 String
	    System.out.println(returnpw);
	    
	    
	    
	    
	    
	    
	    //byte[] bytes = Longs.toByteArray(12345L);
	    
	    
	    //Integer password3= Integer.parseInt(a);
	    
	    //long pass=password2 *password3;
	   // System.out.println(pass);
	    
	    //pass=pass*bytes1[0];
	   // System.out.println(pass);
	    
	    // 계좌생성 로그인
	    // 생성- 비밀번호 , 계좌주 , 전환번호 받아서 계좌번호 생성해주기
	    // 로그인 - 계좌번호 , 비밀번호
	    // 계좌 찾기 - 계좌주 , 전화번호 -> 계좌번호 // 비밀번호 찾고 싶으면 은행 방문
	    
	    
	    
	    
	     
	    // 계좌 생성
	    
	    // int 8자리 랜덤
	    int random = (int)(Math.random()*10000000);
	    // String 변환
	    String randomaccount = Integer.toString(random);
	    // String 사이에 특정 문자를 추가하려면 String은 변하지 못하므로 변할 수 있는 StringBuffer로 변환해줘야한다.
	    StringBuffer outputaccount = new StringBuffer(randomaccount);
	    outputaccount.insert(0 ,  "21-");
	    outputaccount.insert(6 ,  "-");
	    System.out.println(outputaccount);
	    // buffer -> String 변환
	    String newaccount = outputaccount.substring(0);
	    System.out.println(newaccount);
	    
	    
	    
	}

	private static long substring(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
