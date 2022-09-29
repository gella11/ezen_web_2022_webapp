package 협업과제2;

import java.util.Arrays;

public class d {
	public static void main(String[] args) {
		String string = "123456789";
		String a = "1234";
		int ccc = 123;
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
	    
	    
	    System.out.println(Arrays.toString(bytes1));
	    System.out.println(Arrays.toString(bytes2));
	    
	    System.out.println(bytes2);


	    
	    String password="";
	    for(int i=0; i<bytes1.length; i++) {
	    	password+=Integer.toString(bytes1[i]);
	    }
	    Long password2= Long.parseLong(password);
	    System.out.println(password2);
		 
	    
	    long ab=password2 * bytes2[0];
	    long ac=password2 * bytes2[1];
	    long ad=password2 * bytes2[2];
	    long ae=password2 * bytes2[3];
	    System.out.println(ab);
	    System.out.println(ac);
	    System.out.println(ad);
	    System.out.println(ae);
	    
	    String real=Long.toString(ab);
	    real+=Long.toString(ac);
	    real+=Long.toString(ad);
	    real+=Long.toString(ae);
	    
	    String real2=Long.toString(ae);
	    real2+=Long.toString(ae);
	    real2+=Long.toString(ad);
	    real2+=Long.toString(ac);
	    real2+=Long.toString(ab);
	    
	    System.out.println(real+real2);
	    
	    //Integer password3= Integer.parseInt(a);
	    
	    //long pass=password2 *password3;
	   // System.out.println(pass);
	    
	    //pass=pass*bytes1[0];
	   // System.out.println(pass);
	    
	    // 계좌생성 로그인
	    // 생성- 비밀번호 , 계좌주 , 전환번호 받아서 계좌번호 생성해주기
	    // 로그인 - 계좌번호 , 비밀번호
	    // 계좌 찾기 - 계좌주 , 전화번호 -> 계좌번호 // 비밀번호 찾고 싶으면 은행 방문
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
	
	
}
