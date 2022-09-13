package java1.ch4배열;

public class EX4_배열2 {
	public static void main(String[] args) {
		
		
			// 1. 1차원 배열 []
			String[] 배열1 = new String[10]; //String 객체를 10개 저장할 수 잇는 배열
				//1. 값 대입
				배열1[0] = "유재석";	배열1[1] = "강호동";	배열1[2]="신동엽";
				//2. 항목에 값 수정
				배열1[0] = "하하";
				//3. 항목에 값 삭제 [ 메모리자체삭제x >>> 데이터초기화 ]
				배열1[1] = null;
				//4. 모든 항목 호출
				for( String value : 배열1) { System.out.println(value);}
			
				
				
				
				
				
				
			// 2. 2차원 배열
			String[] [] 배열2 = new String[10][5]; //가로 row 세로 col string 객체를 20개 저장
				//1. 값 대입
				배열2[0][0] = "유재석"; 배열2[0][1]="0110-4444-4444";
				//2. 수정 동일
				//3. 값 삭제 동일
				배열2[0][0]=null; 배열2[1][1]=null;
				//4.항목 호출
				for ( int 행 = 0 ; 행<배열2.length ; 행++) {
					//1부터 마지막 행까지 반복
					for(int 열 = 0 ; 열<배열2[행].length; 열++) {
						System.out.print(배열2[행][열] + "\t");
					}
					System.out.println();
				}
				
				
				
				
				
				
				
				
				
				
			
			// 3. 3차원 배열
			String[][][] 배열3 = new String[10][2][3]; //가로 세로 높이 string 객체 60개 저장
			
	
}
}