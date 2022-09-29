package 협업과제2;

import java.util.ArrayList;
import java.util.Random;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class dddd {
	public static void main(String[] args) {
		Random random = new Random();		//랜덤 함수 선언
		int createNum=0;
		
		createNum = random.nextInt(9);
		
		String str = "Java";
        byte[] bytes = str.getBytes();
 
        System.out.println(bytes.toString());
	
	}
}
