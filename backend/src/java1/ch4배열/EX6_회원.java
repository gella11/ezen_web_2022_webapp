package java1.ch4배열;

import java.util.Scanner;

import javax.sound.midi.MetaMessage;

public class EX6_회원 {
	public static void main(String[] args) {
		
		String[][] memberlist = new String[100][4];
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("=============회원제 페이지=============");
			System.out.println("메뉴 : 1.로그인 2.회원가입 3.아이디찾기 4.비밀번호찾기");
			System.out.println("====================================");
			System.out.println("선택 : "); int btn = scanner.nextInt();
			
			if( btn == 1 )   // 1 입력했을떄
			{ 
				System.out.println("================= 로그인 페이지 ===============");
				System.out.print("아이디 : ");	String id = scanner.next();
				System.out.print("비밀번호 : ");	String password = scanner.next();
				int login = 0 ; // 로그인 처리에 대한 상태를 저장하는 변수 
				int logincheck = 0 ; // *로그인 처리에 대한 상태를 저장하는 변수 
				for( int i = 0 ; i<memberlist.length ; i++ ) {
					if( memberlist[i][0] != null ) { 
						if( memberlist[i][0].equals( id ) ) { 
							login = 2;	// 아이디는 맞으나 비밀번호 틀렸을때 
							logincheck = 2;	// 아이디는 맞으나 비밀번호 틀렸을때 
							if( memberlist[i][1].equals( password ) ) {
								System.out.println("안내) 로그인 성공 !!");
								login = 1; // 로그인 성공 [ 아이디와 비밀번호가 모두 맞았을때 ]
									// (추후코드) 로그인 메뉴 // 
								logincheck = 1; // 로그인 성공 [ 아이디와 비밀번호가 모두 맞았을때 ]
									while(true) {
										System.out.print("회원 메뉴 : 1.회원탈퇴 2.로그아웃 ");
										int btn2 = scanner.nextInt();
										if( btn2 == 1 ) { 
											memberlist[i][0] = null;	memberlist[i][1] = null;
											memberlist[i][2] = null;	memberlist[i][3] = null;
												// 삭제된 회원 뒤로 한칸씩 당기기
												for( int j = i ; j<memberlist.length ; j++  ) {
													memberlist[j][0] = memberlist[j+1][0];
													memberlist[j][1] = memberlist[j+1][1];
													memberlist[j][2] = memberlist[j+1][2];
													memberlist[j][3] = memberlist[j+1][3];
													// 다음 인덱스의 null 이면 [ 회원이 없다는 뜻으로 ]
													if( memberlist[j+1][0] == null ) break; 
												} // for end 
											// --------------------------------------------// 
											System.out.println("안내) 회원탈퇴가 되었습니다.");
											break;
										}
										else if( btn2 == 2 ) { break; }
									} // while end 
								break;
							} // if end 
						}  // if end
					} // if end 
				} // for end 
				// // 3. 있으면 로그인 성공 없으면 로그인 실패
				if( login == 0 ) { System.out.println("안내) 동일한 아이디가 없습니다."); } 
				else if( login == 2){ System.out.println("안내) 비밀번호가 일치 하지 않습니다.");}
				else if( login == 1) { System.out.println("안내) 로그아웃 되었습니다.");}
			}
			else if(btn == 2)
				{
				
				System.out.println("=============회원제 페이지=============");
				System.out.println("아이디 : "); String id = scanner.next();
				boolean idcheck=true;
				for(int row = 0 ; row<memberlist.length ; row++) {
					if (memberlist[row][0] != null && memberlist[row][0].equals(id)) {
						System.out.println("사용 중인 아이디 입니다.");
						idcheck = false; break;
					}
				}
				
				System.out.println("비밀번호 : "); String password = scanner.next();
				System.out.println("이름 : "); String name = scanner.next();
				System.out.println("전화번호 : "); String phone = scanner.next();
				for( int row = 0 ; row < memberlist.length ; row++) {
					if(memberlist[row][0] == null) {
						memberlist[row][0] = id; 		memberlist[row][1] = password;
						memberlist[row][2] = name;	 	memberlist[row][3] = phone;
						System.out.println("회원가입 성공");
						break;
					}
					if(row==99) {System.out.println("최대 회원수가 찼습니다. 관리자에게 문의");
				}
				
					else if( btn == 3 )   // 3 입력했을떄
					{ 
						System.out.println("================= 아이디찾기 페이지 ===============");
						System.out.print("이름 : "); 	String name1 = scanner.next();
						System.out.print("전화번호 : ");	String phone1 = scanner.next();
						// 2. 배열내 모든 항목 비교해서 동일한 이름,전화번호
						for( int i = 0 ; i<memberlist.length ; i++ ) {	// 모든 항목 출력 
							if( memberlist[i][0] != null && 		// null 아니면서 
									memberlist[i][2].equals(name1) && 	// 이름이 같고 
										memberlist[i][3].equals( phone1 ) ) { // 전화번호가 같으면
								System.out.println("안내) 회원님의 아이디 : " + memberlist[i][0]);
								break;
							} // if end
							// 3. 존재하면 해당 아이디 출력 아니면 미출력
							if( i == memberlist.length-1 ){ // i가 마지막인덱스와 같으면 [ 모두 검사했는데 조건 못찾음 ] 
								System.out.println("안내) 동일한 회원정보가 없습니다. ");
							}
						}

					}
					else if( btn == 4 )
					{ 
						System.out.println("================= 비밀번호 페이지 ===============");
						System.out.print("아이디 : "); 	String id1 = scanner.next();
						System.out.print("전화번호 : ");	String phone1 = scanner.next();
						// 2. 배열내 모든 항목 비교해서 동일한 아이디 , 전화번호 
						for( int i = 0 ; i<memberlist.length ; i++ ) { // 인덱스 0 부터 마지막인덱스까지 반복
							if( memberlist[i][0] != null &&
									memberlist[i][0].equals(id1) &&
										memberlist[i][3].equals(phone1) ) {
								System.out.println("안내) 회원님의 비밀번호 : " + memberlist[i][1] );
								break;
							}
							// i가 마지막 인덱스 이면 	[ 인덱스 = 길이-1 ]
							// 3. 존재하면 해당 비밀번호 출력 아니면 미출력
							if( i == memberlist.length-1 ) {
								System.out.println("안내) 동일한 회원정보가 없습니다. ");
							}
						}

					}
			else {System.out.println("알 수 없는 번호입니다.");}
				}}}}}

	

	
