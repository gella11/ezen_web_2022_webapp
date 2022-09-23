package back2;

public class Member {

	//멤버
	//1.필드
	String id;
	String password;
	String name;
	//2.생성자 : 객체 생성시 초기값 [ 필드의 처읍값 설정 ]
		// * : 생성자가 하나도 정의하지 않으면 기본생성자(빈생성자) 자동 추가]
		// * : 클래스명 이름 동일
		// * : 매개변수 개수에 따라 오버로딩[여러개 사용 가능]
		//1)빈생성자 기본생성자 [무조건필요]
	Member(){}
		//2)매개변수 1개인 생성자
	Member( String id){
		this.id = id;
	}
		//3)매개변수 2개인 생성자
	Member( String id, String password){
		this.id = id;
		this.password = password;
	}
		//4)매개변수 3개인 생성자
		public Member(String id, String password, String name) {
			this.id = id;
			this.password = password;
			this.name = name;
		}
	
	//3. 메소드
		

}
