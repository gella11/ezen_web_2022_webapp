package 협업과제2;

public class abc {
	String key = "123456789"; // 암호화 키
    
    byte[] keybyte = key.getBytes();
    byte[] passwordbyte = password.getBytes();
    
     
    String firstbox="";
    for(int i=0; i<keybyte.length; i++) {
       firstbox+=(keybyte[i]); //배열에 담긴 키 숫자 하나씩 String으로 변환해서 누적 더하기
    }
    Long firstNum= Long.parseLong(firstbox); // 일렬로 된 숫자들 정수형으로 변환
     
    BigInteger[] array=new BigInteger[4]; 
       
     String secondbox="";
     for(int i=0; i<array.length;i++) {
      array[i]=firstNum * passwordbyte[i]; // 나열된 키숫자들에 password배열의 숫자 하나씩을 곱하기
      secondbox+=array[i]; // 곱한걸 String으로 누적 더하기
     }
}
