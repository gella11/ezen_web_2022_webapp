package ch10예외처리;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EX4_실행 {

	public static void signup() throws SQLException {
		Dao.getInStance().signup();
	}
	public static void login() throws SQLException {
		Dao.getInStance().login();
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			try {
				System.out.println("1.회원가입 2.로그인");
				int ch = scanner.nextInt();
				if(ch == 1) {signup();}
				if(ch == 2) {login();}
			} catch (SQLException e) {
				System.out.println("DB 오류 : " + e);
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력해주세요");
				scanner = new Scanner(System.in);
			} catch (Exception e) {
				System.out.println("예상치 못한 오류 발생 : 초기화면으로 갑니다.");
			}
		}
		
		
		
		
	}
	
}
