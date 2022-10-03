package 협업과제2;

import java.util.Scanner;

public class View {

	Scanner scanner = new Scanner(System.in);
	Controller controller= new Controller();
	
	public static void main(String[] args) {
		View view = new View();
		view.start();
	}
	
	
	void start() {
		while(true) {
			System.out.println(" ====== 땡땡 은행 ====== ");
			try {
				System.out.println("1. 계좌생성 2. 계좌 로그인 3. 내 계좌 찾기");
				int ch= scanner.nextInt();
				if(ch==1) {signup();}
				else if(ch==2) {login();}
				else if(ch==3) {search();}
				else {System.out.println("안내 ) 다시 선택해주세요. ");}
			}catch(Exception e) {
				System.out.println("안내 ) 숫자만 입력부탁드립니다.");
				scanner = new Scanner(System.in);
			}
		}
	}
	
	
	
	
	
	
	 // 생성- 비밀번호 , 계좌주 , 전화번호 받아서 계좌번호 생성해주기
	void signup() {
		System.out.println(" ====== 땡땡 은행 계좌 생성 ====== ");
		System.out.print("성함을 입력해주세요 : "); 		String name=scanner.next();
		System.out.print("전화번호를 입력해주세요 : ");	String phone=scanner.next();
		
		try {
			System.out.print("사용할 비밀번호 숫자 4자리를 입력해주세요 : ");
			String password=scanner.next();
			int numCheck=Integer.parseInt(password); // 숫자만 입력했는지 확인용 변수 - 이거 안되면 catch로 이동
			if (password.length()!=4) {System.out.println("반드시 4자리를 입력해주세요"); return;}//4자리 체크
			
			//제대로 다 입력됐으면 계좌생성 & DB업데이트 이동
			String account=controller.signup(name,phone,password);
			System.out.println("계좌생성이 완료됐습니다. 고객님의 계좌는 "+account+" 입니다.");
		}catch (Exception e) {
			System.out.println("부디 숫자만 입력해주세요 ");
			scanner=new Scanner(System.in);
		}	
	}

	
	// 로그인 - 계좌번호 , 비밀번호
	void login() {
		System.out.println(" ====== 땡땡 은행 로그인 ====== ");
		System.out.print("계좌번호를 입력해주세요 : "); String account=scanner.next();
		System.out.print("비밀번호 4자리를 입력해주세요 "); String password=scanner.next();
		
		int result=controller.login(account,password);
		
		if(result==1) {
			System.out.println("로그인 성공했습니다. ");
			System.out.println(" ====== 회원 페이지 ====== ");
			System.out.println("아직 구현되지 않은 페이지입니다."); return;
		}
		else if(result==0) {System.out.println("존재하지 않는 계좌입니다.");}
		else if(result==2){System.out.println("비밀번호가 틀렸습니다.");}
	}
	
	
	
	
	// 계좌 찾기 - 계좌주 , 전화번호 -> 계좌번호 // 비밀번호 찾고 싶으면 은행 방문
	void search() {
		System.out.println(" ====== 땡땡 은행 계좌 찾기 ====== ");
		System.out.print("성함 입력해주세요 : ");  String name=scanner.next();
		System.out.print("전화번호를 입력해주세요 : "); String phone=scanner.next();
		
		String account=controller.search(name, phone);
		if(account!=null) {
			System.out.println("고객님의 계좌번호는 " +account+" 입니다.");
			System.out.print("로그인 페이지로 이동하시겠습니까? [예:1][비밀번호 찾기:2]");
			int ch=scanner.nextInt();
			if(ch==1) {login();}
			else if(ch==2) {System.out.println("비밀번호를 찾고싶다면 신분증을 가지고 은행을 방문해주세요.");}
			else {System.out.println("잘못된 입력입니다."); return;}
		}
		else {System.out.println("입력하신 정보에 해당하는 계좌가 없습니다.");}
		
	}
	
}
