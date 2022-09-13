package java1.ch4배열;

import java.util.Scanner;

public class EX7_비회원게시판 {
	public static void main(String[] args) {
		
		
		String[][] boardlist = new String[100][4];
		Scanner scanner = new Scanner(System.in);
		int listnumber = 0;
		
		while(true) {
			System.out.println("============= 커뮤니티 =============");
			System.out.println("번호\t작성자\t제목");
			for( int i = 0 ; boardlist[i][0] != null ; i++) {
				System.out.print(i +
							  "\t" + boardlist[i][2] +
							  "\t" + boardlist[i][0] + "\n");
			}
			System.out.println("1.글쓰기\t2.글보기");
			System.out.println("======================================");
			System.out.println("선택 : "); 			  int btn = scanner.nextInt();
				
			
			if(btn==1) {
				System.out.println("============= 글쓰기 페이지 =============");
				System.out.println("title : "); 	String title 	= scanner.next();
				System.out.println("content : "); 	String content 	= scanner.next();
				System.out.println("writer : "); 	String writer 	= scanner.next();
				System.out.println("password : "); 	String password = scanner.next();
					boardlist[listnumber][0] = title; 
					boardlist[listnumber][1] = content;
					boardlist[listnumber][2] = writer;
					boardlist[listnumber][3] = password;
					System.out.println("글이 등록되었습니다.");
					listnumber++;
					}
			
		else if(btn==2) {
				System.out.println("열람할 게시글 번호를 입력해주세요 : "); int btn2 = scanner.nextInt();
						System.out.println("============ 게시물 상세페이지 ============");
						System.out.println("작성자	: " + boardlist[btn2][2] );
						System.out.println("제 목	: " + boardlist[btn2][0] );
						System.out.println("내 용	: " + boardlist[btn2][1] );
						System.out.println("=======================================");
						System.out.println("1.뒤로가기 \t 2.글삭제 \t 3.글 수정");
						System.out.println("선택 : "); 				 int btn3 = scanner.nextInt();
						
							 if(btn3 == 1) {System.out.println();}
							 
						else if(btn3 == 2){
							System.out.println("현 삭제 게시물 비밀번호 :"); String btn4 = scanner.next();
							if( boardlist[btn2][3].equals(btn4) ) {
								boardlist[btn2][0] = null; 
								boardlist[btn2][1] = null;
								boardlist[btn2][2] = null;
								boardlist[btn2][3] = null;
								listnumber--;
								System.out.println("해당 게시물이 삭제되었습니다.");
								for( int j = btn2 ; j<boardlist.length ; j++  ) {
									boardlist[j][0] = boardlist[j+1][0];
									boardlist[j][1] = boardlist[j+1][1];
									boardlist[j][2] = boardlist[j+1][2];
									boardlist[j][3] = boardlist[j+1][3];
									if( boardlist[j+1][0] == null )					
									break;	
								}
						} else {System.out.println("글삭제)비밀번호가 다릅니다.");}}
						
						else if(btn3 == 3){
							System.out.println("현 수정 게시물 비밀번호 :"); 	String btn5 = scanner.next();
							if( boardlist[btn2][3].equals(btn5) ) {
								
								System.out.println("제목을 수정하십시오 : ");	String title 	= scanner.next();
								boardlist[btn2][0] = title;

								System.out.println("내용을 수정하십시오 : ");	String content  = scanner.next();
								boardlist[btn2][1] = content;
								
								System.out.println("수정되었습니다.");
								continue;
								}else {System.out.println("글수정)비밀번호가 다릅니다.");}
							} 	
						}	
					}
				}
			}


