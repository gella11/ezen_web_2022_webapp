package 협업과제2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class abc {
	public static void main(String[] args) {
		System.out.println();

	      HashMap<String, Integer> jin = new HashMap<String, Integer>();

	      for( int i = 1 ; i <= 30 ; i++) {

	         int a = (int)(Math.random()*9999);

	       //  int b = (int)(Math.random()*100);

	        // int[] number = new int[]{ a ,b };   
	         
	       //  String to = Integer.toString(a);
	         

	         jin.put( "key"+i, a);

	         

	      }
    
	      //jin.forEach((key, value) -> {   

	        // System.out.println(key + " : " + String.format("%02d",value[0])+","+ String.format("%02d",value[1]) );   

	      //});
	      
	      jin.forEach((key, value) -> {  
	    	System.out.println(key + " : " + String.format("%04d",value));  
	      });
	      
	      
	      
	      
	      
	      
	      
	      
	      
	}
}
