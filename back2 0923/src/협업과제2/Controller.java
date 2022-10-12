package 협업과제2;

import java.math.BigInteger;

public class Controller {

	//계좌생성 로직
	//계좌생성 로직
	//계좌생성 로직
	String signup(String name, String phone, String password) {
		
		//이름,핸드폰,비밀번호 제대로 입력받으면 계좌 생성해주기
		//계좌번호 생성
		String account= newaccount();
		
		// 비밀번호 암호화
		String lockPassword= makePassword(password);
		
		//암호화된 비밀번호, 계좌 포함해서 DB업데이트
		DTO dto=new DTO(0, name, phone, lockPassword, account);
		boolean result=DAO.getInstance().signupDB(dto);
		
		// 제대로 업데이트됐으면 계좌 반환
		if(result) {return account;}
		else 	   {return "DB업데이트에 오류가 있습니다.";}
	}
	
	

	//비밀번호 암호화시키는 로직
	//비밀번호 암호화시키는 로직
	//비밀번호 암호화시키는 로직
	String makePassword(String password) {
		
		String key = "12345678"; // 암호화 키 8자리
		if(password.contains("8")) {password=password.replace("8", "+");} // 9 ,8 숫자 넘쳐서 - 로 변환 문제 해결하기 위한...
		if(password.contains("9")) {password=password.replace("9", "-");}//이거 뭐로 바꾸기로 했더라...
		
		byte[] keybyte = key.getBytes();
		byte[] passwordbyte = password.getBytes();
		
	    
		String keybytebox="";
		for(int i=0; i<keybyte.length; i++) {
			keybytebox+=(keybyte[i]); //바이트열에 담긴 암호화키 숫자 하나씩 String으로 변환해서 누적 더하기
		}
		
		Long keyNum= Long.parseLong(keybytebox); // String으로 변환해서 한줄에 넣었던 암호화키 정수로 변환
	    
		Long[] array=new Long[4]; 
		// Long[] backarray=new Long[4];  //거꾸로 하나더
		
	    String lockPassword="";
	    for(int i=0; i<array.length;i++) {
	     array[i]=keyNum * passwordbyte[i]; 		 // password바이트배열에 숫자를 하나씩 꺼내서 정수로 변환시킨 암호화키 곱하기
	     lockPassword+=array[i];					 // 곱한걸 넣은 배열을 String으로 다 뽑아내기 
	    }
	    
	 // passwrod2 *  비밀번호 각 자리수
	    long ab=keyNum * passwordbyte[0];
	    long ac=keyNum * passwordbyte[1];
	    long ad=keyNum * passwordbyte[2];
	    long ae=keyNum * passwordbyte[3];
	    
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
	    
	    String sum = real+real2;
	    
	    return sum;
	
	}
	
	
	// 계좌생성
	// 계좌생성
	// 계좌생성
	String newaccount() {
		int random = (int)(Math.random()*10000000);
	    // String 변환
	    String randomaccount = Integer.toString(random);
	    // String 사이에 특정 문자를 추가하려면 String은 변하지 못하므로 변할 수 있는 StringBuffer로 변환해줘야한다.
	    StringBuffer bufferaccount = new StringBuffer(randomaccount);
	    bufferaccount.insert(0 ,  "21-");
	    bufferaccount.insert(6 ,  "-");
	    // buffer -> String 변환
	    String newaccount = bufferaccount.substring(0);
	    return newaccount;
		}
	

	
	
	// 로그인 로직
	// 로그인 로직
	// 로그인 로직
	int login(String account, String password) {
		
		String result = unlock(account, password);
		
			//입력한 비밀번호와 복호화된 비밀번호 대조
			if( password.equals(result) ) {
				return 1;
			}else {return 2;}
	}
	
	// 복호화 로직
	// 복호화 로직
	String unlock(String account,String password) {
		
		String lockpassword=DAO.getInstance().loginDB(account);
		String key = "12345678"; // 암호화 키 8자리
		if(password.contains("8")) {password=password.replace("8", "+");} // 9 ,8 숫자 넘쳐서 - 로 변환 문제 해결하기 위한...
		if(password.contains("9")) {password=password.replace("9", "-");}//이거 뭐로 바꾸기로 했더라...
		
		byte[] keybyte = key.getBytes();
		
		String keybytebox="";
		for(int i=0; i<keybyte.length; i++) {
			keybytebox+=(keybyte[i]); 
		}
		
		Long keyNum= Long.parseLong(keybytebox); 
		
		String result1 = lockpassword.substring(0,18);
	    String result2 = lockpassword.substring(18,36);
	    String result3 = lockpassword.substring(36,54);
	    String result4 = lockpassword.substring(54,72);

	    // 롱으로 변환
	    long resultlong1 = Long.parseLong(result1);
	    long resultlong2 = Long.parseLong(result2);
	    long resultlong3 = Long.parseLong(result3);
	    long resultlong4 = Long.parseLong(result4);
	    
	    // 롱으로 패스워드 나누기
	    long no1 = (long) (resultlong1 / keyNum);
	    long no2 = (long) (resultlong2 / keyNum);
	    long no3 = (long) (resultlong3 / keyNum);
	    long no4 = (long) (resultlong4 / keyNum);
	    
	    // 롱에서 바이트 변환
	    byte return1 = (byte) no1;
	    byte return2 = (byte) no2;
	    byte return3 = (byte) no3;
	    byte return4 = (byte) no4;
	    
	    // 바이트 배열에 넣기
	    byte[] back = new byte[4];
	    back[0] = return1;
	    back[1] = return2;
	    back[2] = return3;
	    back[3] = return4;
	    
	    // 바이트배열 String 화
	    // (+ -) ->  (8 9)  변환
	    String returnpw = new String(back);
	    if(returnpw.contains("+")) {returnpw=returnpw.replace("+", "8");}
		if(returnpw.contains("-")) {returnpw=returnpw.replace("-", "9");}
		
		if(lockpassword!=null) {
			//복호화
			String realpassword=returnpw;
			return realpassword;
	}
		return returnpw;
	}
	
	//계좌찾기 로직
	String search(String name, String phone) {
		return DAO.getInstance().search(name,phone);
	}

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}// class end
