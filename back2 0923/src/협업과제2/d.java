package 협업과제2;

import java.util.Arrays;
import java.util.Random;

public class d {
	public static void main(String[] args) {
		String string = "12345669";
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
	    
	    
	    System.out.println(Arrays.toString(bytes1));
	    System.out.println(Arrays.toString(bytes2));
	    
	    System.out.println("String : " + bytes1);
	    System.out.println("a : " + bytes2);
	    


	    
	    String password="";
	    for(int i=0; i<bytes1.length; i++) {
	    	password+=Integer.toString(bytes1[i]);
	    	
	    }
	    Long password2= Long.parseLong(password);
	    
		 
	    
	    long[] array2=new long[4];
	    String qq="";
	    for(int i=0; i<array2.length;i++) {
	    	array2[i]=password2 * bytes2[i] * bytes2[i];
	    	qq+=array2[i];
	    }
	    
	    
	    
	    
	    
	    System.out.println("qq : " +qq);
	    System.out.println("password2 : " + password2);
	    System.out.println(bytes2[0]);
	    System.out.println(bytes2[1]);
	    System.out.println(bytes2[2]);
	    System.out.println(bytes2[3]);
	    System.out.println("첫번째"+password2 * bytes2[0] );
	    System.out.println("두번째"+password2 * bytes2[1] );
	    System.out.println("세번째"+password2 * bytes2[2] );
	    System.out.println("네번째"+password2 * bytes2[3] );
	   
	    
	    long ab=password2 * bytes2[0];
	    long ac=password2 * bytes2[1];
	    long ad=password2 * bytes2[2];
	    long ae=password2 * bytes2[3];
	    
	   
	    
	    
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
	    String sum = real+real2;
	    
// 복호화
// 복호화
// 복호화
	    // db자료 받아와서 끊기
	    String result1 = sum.substring(0,18);
	    String result2 = sum.substring(18,36);
	    String result3 = sum.substring(36,54);
	    String result4 = sum.substring(54,72);
	    
	    
	    //확인
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
	    
	    System.out.println(no1);
	    System.out.println(no2);
	    System.out.println(no3);
	    System.out.println(no4);
	    
	    
	    
	    
	    
	    //Integer password3= Integer.parseInt(a);
	    
	    //long pass=password2 *password3;
	   // System.out.println(pass);
	    
	    //pass=pass*bytes1[0];
	   // System.out.println(pass);
	    
	    // 계좌생성 로그인
	    // 생성- 비밀번호 , 계좌주 , 전환번호 받아서 계좌번호 생성해주기
	    // 로그인 - 계좌번호 , 비밀번호
	    // 계좌 찾기 - 계좌주 , 전화번호 -> 계좌번호 // 비밀번호 찾고 싶으면 은행 방문
	    
	    
	    
	    
	    // double sub_a = Math.random();
	    // double sub_b = Math.random()*100;
	    // double sub_c = Math.random()*10000;
	     
	    // 계좌 생성
	    String account = "77778888";
	    StringBuffer buf = new StringBuffer(account);
	    //String 사이에 특정 문자를 추가하려면 String은 변하지 못하므로 변할 수 있는 StringBuffer로 변환해줘야한다.
	    buf.insert(0 ,  "21-");
	    buf.insert(6 ,  "-");
	    System.out.println(buf);
	    
	    
	    
	}

	private static long substring(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
