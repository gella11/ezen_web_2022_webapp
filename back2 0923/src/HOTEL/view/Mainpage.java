package HOTEL.view;

import HOTEL.controller.MemberController;

public class Mainpage {
	private static Mainpage Mpage = new Mainpage();
	private Mainpage() {}
	public static Mainpage getInstance() { 
		return Mpage; 
	}  
	
	
	// 0. 메인페이지 
	public void index( ) {
		System.out.println("1.메인페이지 열립니다.");
		signup();
	}
	
	// 1. 회원가입 페이지 
	private void signup() {
		System.out.println("2.회원가입 페이지 열립니다. ");
		String id = "qweqwe";
		String password =  "123123";
		boolean result =
				MemberController.getInStance().signup(  id , password );
		
		if( result ) { System.out.println("회원가입 성공 ");}
		else { System.out.println("회원가입 실패 "); }
		
	}
	
	
}









